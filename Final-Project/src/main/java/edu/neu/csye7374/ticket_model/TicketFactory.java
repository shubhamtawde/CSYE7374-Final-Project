package edu.neu.csye7374.ticket_model;

import edu.neu.csye7374.logger.Logger;

public class TicketFactory {
    public static Ticket createTicket(String type, String title, String eventDate, double price) {
        Logger logger = Logger.getInstance();
        switch (type.toLowerCase()) {
            case "concert":
                logger.log("Creating concert ticket");
                return new ConcertTicket(title, eventDate, price);
            case "movie":
                logger.log("Creating movie ticket");
                return new MovieTicket(title, eventDate, price);
            default:
                throw new IllegalArgumentException("Unknown ticket type");
        }
    }
}

