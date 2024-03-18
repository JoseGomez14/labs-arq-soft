package co.edu.udea.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

/**
 * This class represents a flight entity.
 */
public class Flight {
    /**
     * Unique identifier of the flight entity, assigned as a sequence of integers.
     */
    private int id;
    /**
     * Name of the airline operating the flight
     */
    private String airline;
    /**
     * Name of city from which the flight departs
     */
    private String origin;
    /**
     * Name of city to which the flight arrives
     */
    private String destination;
    /**
     * The flight price in dollars.
     */
    private int price;
    /**
     * The departure date and time of the flight.
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime departureDate;
    /**
     * The arrival date and time of the flight.
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime arrivalDate;

    /**
     * Default constructor
     */
    public Flight() {
    }

    /**
     * Constructor with all parameters
     *
     * @param id            Identifier of the flight entity
     * @param airline       Name of the airline operating the flight
     * @param origin        Name of city from which the flight departs
     * @param destination   Name of city to which the flight arrives
     * @param price         Flight price in dollars
     * @param departureDate The departure date and time of the flight
     * @param arrivalDate   The arrival date and time of the flight
     */
    public Flight(int id, String airline, String origin, String destination, int price, LocalDateTime departureDate,
            LocalDateTime arrivalDate) {
        this.id = id;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
