package co.edu.udea.backend.service;

import co.edu.udea.backend.model.Flight;
import co.edu.udea.backend.utils.common.FilterUtils;
import co.edu.udea.backend.utils.common.DataValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    /**
     * Flight search by date logic method
     *
     * @param startDate the start date of the range
     * @param endDate   the end date of the range
     * @return List of flights within the range
     */
    public List<Flight> searchFlightsByDate(LocalDateTime startDate, LocalDateTime endDate) {
        DataValidation.dateIsAfter(endDate, startDate, "Flight Date");
        return searchFlightsByCriteria(
                flight -> FilterUtils.isDateInRange(flight.getDepartureDate(), startDate, endDate));
    }

    /**
     * Flight search by airline logic method
     *
     * @param airline the airline to search for, case is ignored
     * @return List of flights that the airline operates
     */
    public List<Flight> searchFlightsByAirline(String airline) {
        DataValidation.validateNotNull(airline, "Airline");
        return searchFlightsByCriteria(flight -> flight.getAirline().equalsIgnoreCase(airline));
    }

    /**
     * Flight search by price logic method
     *
     * @param minPrice the minimum price of the range
     * @param maxPrice the maximum price of the range
     * @return List of flights with the exact price
     */
    public List<Flight> searchByPrice(int minPrice, int maxPrice) {
        DataValidation.validatePositive(minPrice, "Minimum Price");
        DataValidation.validatePositive(maxPrice, "Maximum Price");
        DataValidation.numberIsGreater(maxPrice, minPrice, "Price");
        return searchFlightsByCriteria(flight -> FilterUtils.isPriceInRange(flight.getPrice(), minPrice, maxPrice));
    }

    /**
     * Flight search by all criteria logic method
     *
     * @param startDate   the start date of the range
     * @param endDate     the end date of the range
     * @param airline     the airline to search for
     * @param minPrice    the minimum price of the flight
     * @param maxPrice    the maximum price of the flight
     * @param origin      the origin of the flight
     * @param destination the destination of the flight
     * @return List of flights with all the criteria
     */
    public List<Flight> searchByAll(LocalDateTime startDate, LocalDateTime endDate, String airline, int minPrice,
            int maxPrice, String origin, String destination) {
        DataValidation.dateIsAfter(endDate, startDate, "Flight Date");
        DataValidation.validateNotNull(airline, "Airline");
        DataValidation.validatePositive(minPrice, "Minimum Price");
        DataValidation.validatePositive(maxPrice, "Maximum Price");
        DataValidation.numberIsGreater(maxPrice, minPrice, "Price");

        return searchFlightsByCriteria(
                flight -> FilterUtils.isDateInRange(flight.getDepartureDate(), startDate, endDate)
                        && flight.getAirline().equalsIgnoreCase(airline)
                        && FilterUtils.isPriceInRange(flight.getPrice(), minPrice, maxPrice)
                        && flight.getOrigin().equalsIgnoreCase(origin)
                        && flight.getDestination().equalsIgnoreCase(destination));
    }

    /**
     * Flight search by origin and destination logic method
     *
     * @param origin      the origin of the flight
     * @param destination the destination of the flight
     * @return List of flights with the origin and destination
     */
    public List<Flight> searchOriginDestination(String origin, String destination) {
        Predicate<Flight> originPredicate = flight -> flight.getOrigin().equalsIgnoreCase(origin);
        Predicate<Flight> destinationPredicate = flight -> flight.getDestination().equalsIgnoreCase(destination);
        Predicate<Flight> combinedPredicate = originPredicate.and(destinationPredicate);
        return searchFlightsByCriteria(combinedPredicate);
    }

    /**
     * Private method for common search logic using a criteria
     *
     * @param criteria The anonymous function to filter the flights by a criteria
     * @return List of flights filtered by criteria function
     */
    private List<Flight> searchFlightsByCriteria(Predicate<Flight> criteria) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("flights.json");

            if (inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.stream(flights)
                        .filter(criteria)
                        .collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot reading JSON file datasource");
        }
    }
}
