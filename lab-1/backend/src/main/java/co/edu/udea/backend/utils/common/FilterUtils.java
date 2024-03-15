package co.edu.udea.backend.utils.common;

import java.time.LocalDate;

public class FilterUtils {

    /**
     * Method to check if a date is in a range
     *
     * @param dateToCheck the date to check
     * @param startDate   the start date of the range
     * @param endDate     the end date of the range
     * @return true if the date is in the range, false otherwise
     */
    public static boolean isDateInRange(LocalDate dateToCheck, LocalDate startDate, LocalDate endDate) {
        return !dateToCheck.isBefore(startDate) && !dateToCheck.isAfter(endDate);
    }

    /**
     * Method to check if a price is in a range
     *
     * @param priceToCheck the price to check
     * @param minPrice     the start price of the range
     * @param maxPrice     the end price of the range
     * @return true if the price is in the range, false otherwise
     */

    public static boolean isPriceInRange(int priceToCheck, int minPrice, int maxPrice) {
        return priceToCheck >= minPrice && priceToCheck <= maxPrice;
    }
}
