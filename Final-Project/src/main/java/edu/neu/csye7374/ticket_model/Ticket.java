package edu.neu.csye7374.ticket_model;

import edu.neu.csye7374.customer_observer.Customer;
import edu.neu.csye7374.ticket_state.AvailableState;
import edu.neu.csye7374.ticket_state.TicketContext;
import edu.neu.csye7374.ticket_state.TicketState;

public abstract class Ticket implements Cloneable {
    protected String title;
    protected String eventDate;
    protected double price;
    private TicketContext context;
    private Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket() {
        this.context = new TicketContext(); // Initialize with no state
    }

    public Ticket(Ticket ticket){
        this.title = ticket.title;
        this.eventDate = ticket.eventDate;
        this.price = ticket.price;
        this.context = new TicketContext(); // Initialize with no state
    }

    public Ticket(String title, String eventDate, double price) {
        this.title = title;
        this.eventDate = eventDate;
        this.price = price;
        this.context = new TicketContext(); // Initialize with no state
    }

    public void handleState() {
        context.getState().handleState(context);
    }

    public void setState(TicketState state) {
        context.setState(state);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return context.getState() instanceof AvailableState;
    }

    public void book() {
        if (context.getState() instanceof AvailableState) {
            System.out.println("Booking the ticket...");
            setState(new edu.neu.csye7374.ticket_state.BookedState());
            handleState();
        } else {
            System.out.println("Ticket cannot be booked. Current state: " + context.getState().getClass().getSimpleName());
        }
    }

    public void cancel() {
        if (context.getState() instanceof edu.neu.csye7374.ticket_state.BookedState) {
            System.out.println("Cancelling the ticket...");
            setState(new edu.neu.csye7374.ticket_state.CancelledState());
            handleState();
        } else {
            System.out.println("Ticket cannot be cancelled. Current state: " + context.getState().getClass().getSimpleName());
        }
    }

    public void reset() {
        System.out.println("Resetting the ticket to available state...");
        setState(new AvailableState());
        handleState();
    }

    public abstract void printTicketInfo();

    @Override
    public Ticket clone() {
        try {
            return (Ticket) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
