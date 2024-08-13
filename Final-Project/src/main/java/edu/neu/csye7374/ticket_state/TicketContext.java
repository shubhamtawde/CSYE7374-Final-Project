package edu.neu.csye7374.ticket_state;

public class TicketContext {
    private TicketState state;

    public TicketContext() {
        state = new AvailableState(); // Default state
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public TicketState getState() {
        return state;
    }
}