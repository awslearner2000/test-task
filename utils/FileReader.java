package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Ticket;

public class FileReader {
    public static List<Ticket> readFile(String filepath) {
        List<Ticket> tickets = new ArrayList<>();
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            if (myReader.hasNextLine())
                myReader.nextLine();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (line.contains("}") && !line.contains("{"))
                    line = myReader.nextLine();
                Ticket ticket = readTicket(myReader);
                if (ticket != null)
                    tickets.add(ticket);
            }
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
        }
        return tickets;
    }

    private static Ticket readTicket(Scanner myReader) {
        Ticket ticket = new Ticket();
        try {
            String origin = myReader.nextLine();
            origin = origin.substring(origin.indexOf(':')+3, origin.lastIndexOf('"'));
            String origin_name = myReader.nextLine();
            origin_name = origin_name.substring(origin_name.indexOf(':')+3, origin_name.lastIndexOf('"'));
            String destination = myReader.nextLine();
            destination = destination.substring(destination.indexOf(':')+3, destination.lastIndexOf('"'));
            String destination_name = myReader.nextLine();
            destination_name = destination_name.substring(destination_name.indexOf(':')+3, destination_name.lastIndexOf('"'));
            String departure_date = myReader.nextLine();
            departure_date = departure_date.substring(departure_date.indexOf(':')+3, departure_date.lastIndexOf('"'));
            String departure_time = myReader.nextLine();
            departure_time = departure_time.substring(departure_time.indexOf(':')+3, departure_time.lastIndexOf('"'));
            String arrival_date = myReader.nextLine();
            arrival_date = arrival_date.substring(arrival_date.indexOf(':')+3, arrival_date.lastIndexOf('"'));
            String arrival_time = myReader.nextLine();
            arrival_time = arrival_time.substring(arrival_time.indexOf(':')+3, arrival_time.lastIndexOf('"'));
            String carrier = myReader.nextLine();
            carrier = carrier.substring(carrier.indexOf(':')+3, carrier.lastIndexOf('"'));
            String stops = myReader.nextLine();
            stops = stops.substring(stops.indexOf(':')+2, stops.lastIndexOf(','));
            String price = myReader.nextLine();
            price = price.substring(price.indexOf(':')+2);
            ticket.setOrigin(origin);
            ticket.setOrigin_name(origin_name);
            ticket.setDestination(destination);
            ticket.setDestination_name(destination_name);
            ticket.setDeparture_date(departure_date);
            ticket.setDeparture_time(departure_time);
            ticket.setArrival_date(arrival_date);
            ticket.setArrival_time(arrival_time);
            ticket.setCarrier(carrier);
            ticket.setStops(Integer.valueOf(stops));
            ticket.setArrival_date(arrival_date);
            ticket.setCarrier(carrier);
            ticket.setPrice(Double.valueOf(price));
        } catch (Exception e) {
            System.out.println("An error occurred." + e.getMessage());
            return null;
        }
        return ticket;
    }
}
