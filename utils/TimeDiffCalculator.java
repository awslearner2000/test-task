package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeDiffCalculator {
    public static Integer getTimeDiffInMinutes(String departureDate, String departureTime, String arrivalDate, String arrivalTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate departureLocalDate = LocalDate.parse(departureDate, formatter);
        LocalDate arrivalLocalDate = LocalDate.parse(arrivalDate, formatter);
        int departedTimeInMinutes = parseTimeInMinutes(departureTime);
        int arrivedTimeInMinutes = parseTimeInMinutes(arrivalTime);
        if (departureLocalDate.isBefore(arrivalLocalDate)) {
            int departedHour = (departureTime.charAt(0) - '0') * 10 + departureTime.charAt(1) - '0';
            int departedMinute = (departureTime.charAt(3) - '0') * 10 + departureTime.charAt(4) - '0';
            return arrivedTimeInMinutes + (24 - departedHour) * 60 - departedMinute;
        } else if (departureLocalDate.isEqual(arrivalLocalDate)) {
            return arrivedTimeInMinutes - departedTimeInMinutes;
        }
        return 0;
    }

    private static int parseTimeInMinutes(String timeInHourAndMinutes) {
        int hour = 0;
        int minutes = 0;
        if (timeInHourAndMinutes.indexOf(':') == 2) {
            hour = (timeInHourAndMinutes.charAt(0) - '0') * 10 + timeInHourAndMinutes.charAt(1) - '0';
            minutes = (timeInHourAndMinutes.charAt(3) - '0') * 10 + timeInHourAndMinutes.charAt(4) - '0';
        } else {
            hour = timeInHourAndMinutes.charAt(0) - '0';
            minutes = timeInHourAndMinutes.charAt(2) - '0' * 10 + timeInHourAndMinutes.charAt(3) - '0';
        }
        return hour * 60 + minutes;
    }
}
