package co.edu.udea.backend.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import co.edu.udea.backend.model.Flight;
import co.edu.udea.backend.service.FlightService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Flight search controller with endpoints for searching with filters
 * Includes endpoints for searching by date, airline, price, origin and
 * destination
 */
@RestController
@RequestMapping("/flights/search")
@Tag(name = "Flight Search", description = "Search with filters for flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Flight search by date endpoint
     *
     * @param startDate the start date of the range
     * @param endDate   the end date of the range
     * @return List of flights within the range
     */
    @GetMapping("/date")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<Flight> searchFlightsByDate(
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate) {

        LocalDateTime parsedStarDate = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime parsedEndDate = LocalDate.parse(endDate).atStartOfDay();

        return flightService.searchFlightsByDate(parsedStarDate, parsedEndDate);
    }

    /**
     * Flight search by airline endpoint
     *
     * @param airline the airline to search for
     * @return List of flights with the airline
     */
    @GetMapping("/airline")
    public List<Flight> searchFlightsByAirline(
            @RequestParam(name = "airline") String airline) {
        return flightService.searchFlightsByAirline(airline);
    }

    /**
     * Flight search by price range endpoint
     *
     * @param minPrice minimum price of the flight
     * @param maxPrice maximum price of the flight
     * @return List of flights that its price is in the range
     */
    @GetMapping("/price")
    public List<Flight> searchByPrice(
            @RequestParam(name = "minPrice") int minPrice,
            @RequestParam(name = "maxPrice") int maxPrice) {
        return flightService.searchByPrice(minPrice, maxPrice);
    }

    /**
     * Flight search by origin and destination endpoint
     *
     * @param origin      the origin of the flight
     * @param destination the destination of the flight
     * @return List of flights with the origin and destination
     */
    @GetMapping("/originanddestination")
    public List<Flight> searchOriginDestination(
            @RequestParam(name = "origin") String origin,
            @RequestParam(name = "destination") String destination) {
        return flightService.searchOriginDestination(origin, destination);
    }

    /**
     * Flight search by all criteria endpoint
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
    @GetMapping("/all")
    public List<Flight> searchAll(
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate,
            @RequestParam(name = "airline") String airline,
            @RequestParam(name = "minPrice") int minPrice,
            @RequestParam(name = "maxPrice") int maxPrice,
            @RequestParam(name = "origin") String origin,
            @RequestParam(name = "destination") String destination) {

        LocalDateTime parsedStarDate = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime parsedEndDate = LocalDate.parse(endDate).atStartOfDay();
        return flightService.searchByAll(parsedStarDate, parsedEndDate, airline, minPrice, maxPrice, origin,
                destination);
    }
}
