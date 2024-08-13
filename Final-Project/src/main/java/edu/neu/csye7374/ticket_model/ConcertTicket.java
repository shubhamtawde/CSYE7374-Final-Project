package edu.neu.csye7374.ticket_model;

public class ConcertTicket extends Ticket {
    public ConcertTicket(String title, String eventDate, double price) {
        super(title, eventDate, price);
    }

    @Override
    public void printTicketInfo() {
        System.out.println("Concert Ticket: " + getTitle() + " on " + getEventDate() + " for $" + getPrice());
    }
}

