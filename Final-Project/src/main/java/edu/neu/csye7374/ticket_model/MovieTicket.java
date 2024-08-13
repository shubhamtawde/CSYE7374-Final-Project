package edu.neu.csye7374.ticket_model;

public class MovieTicket extends Ticket {
    public MovieTicket(String title, String eventDate, double price) {
        super(title, eventDate, price);
    }

    @Override
    public void printTicketInfo() {
        System.out.println("Movie Ticket: " + getTitle() + " on " + getEventDate() + " for $" + getPrice());
    }
}

