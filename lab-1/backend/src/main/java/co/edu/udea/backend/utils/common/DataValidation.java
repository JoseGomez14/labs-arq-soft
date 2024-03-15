package co.edu.udea.backend.utils.common;

import java.time.LocalDate;

public class DataValidation {

    /**
     * Method to check if a value is not null or empty
     *
     * @param value the value to check
     */
    public static void validateNotNull(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value can't be null or empty");
        }
    }

    /**
     * Method to check if a value is not null or empty and throw a custom message
     *
     * @param value        the value to check
     * @param propertyName the name of the property to check
     */
    public static void validateNotNull(String value, String propertyName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(propertyName + ": The value can't be null or empty");
        }
    }

    /**
     * Method to check if a date is after another date
     *
     * @param dateToCheck  the date to check
     * @param startDate    the start date to compare with
     * @param propertyName the name of the property to check
     */
    public static void dateIsAfter(LocalDate dateToCheck, LocalDate startDate, String propertyName) {
        if (dateToCheck.isBefore(startDate)) {
            throw new IllegalArgumentException(propertyName + ": The date is before the start date");
        }
    }

    /**
     * Method to check if a date is before another date
     *
     * @param number       the number to check
     * @param propertyName the name of the property to check
     */
    public static void validatePositive(int number, String propertyName) {
        if (number < 0) {
            throw new IllegalArgumentException(propertyName + ": The value cannot be negative");
        }
    }

    /**
     * Method to check if a number is greater than another number
     *
     * @param number          the number to check
     * @param numberToCompare the number to compare with
     * @param propertyName    the name of the property to check
     */
    public static void numberIsGreater(int number, int numberToCompare, String propertyName) {
        if (number < numberToCompare) {
            throw new IllegalArgumentException(propertyName + ": The number is less than the number to compare");
        }
    }

}
