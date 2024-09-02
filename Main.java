import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import models.Ticket;
import utils.FileReader;
import utils.TimeDiffCalculator;

public class Main {
    public static void main(String[] args) {
        List<Ticket> ticketList = FileReader.readFile("/Users/aalimbay/Desktop/abilda/projects/test1/src/tickets.json");
        System.out.println("Min flight time is - " + findMinTime(ticketList));
        List<Double> prices = new ArrayList<>();
        Double totalPrice = 0.0;
        for (Ticket ticket : ticketList) {
            if (ticket.getOrigin_name().equals("Владивосток") && ticket.getDestination_name().equals("Тель-Авив")) {
                prices.add(ticket.getPrice());
                totalPrice += ticket.getPrice();
            }
        }
        Double averagePrice = totalPrice / ticketList.size();
        Collections.sort(prices);
        Double medianPrice = 0.0;
        if (prices.size()%2 == 1) {
            medianPrice = prices.get(prices.size()/2);
        } else {
            int size = prices.size();
            double middle1 = prices.get((size / 2) - 1);
            double middle2 = prices.get(size / 2);
            medianPrice = (middle1 + middle2)/2;
        }
        System.out.println("Median price is - " + medianPrice);
        System.out.println("The difference between median and average price is - " + Math.abs(averagePrice-medianPrice));
    }

    public static int findMinTime(List<Ticket> ticketList) {
        int minTime = Integer.MAX_VALUE;
        for (Ticket ticket : ticketList) {
            if (ticket.getOrigin_name().equals("Владивосток") && ticket.getDestination_name().equals("Тель-Авив")) {
                int flightTime = TimeDiffCalculator.getTimeDiffInMinutes(ticket.getDeparture_date(),
                    ticket.getDeparture_time(), ticket.getArrival_date(), ticket.getArrival_time());
                minTime = Math.min(minTime, flightTime);
            }
        }
        return minTime;
    }
}