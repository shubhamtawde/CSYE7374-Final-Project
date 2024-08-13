package edu.neu.csye7374.builder;

import edu.neu.csye7374.ticket_model.Ticket;
import edu.neu.csye7374.ticket_state.TicketContext;

public class TicketBuilder {
    private String title;
    private String eventDate;
    private double price;
    private TicketContext context;

    public TicketBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public TicketBuilder setEventDate(String eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public TicketBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public TicketBuilder setContext(TicketContext context) {
        this.context = context;
        return this;
    }

    public Ticket build() {
        return new Ticket(title, eventDate, price) {
            @Override
            public void printTicketInfo() {
                System.out.println("Ticket: " + getTitle() + " on " + getEventDate() + ", Price: $" + getPrice());
            }
        };
    }
}
