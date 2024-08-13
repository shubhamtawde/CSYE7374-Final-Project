package edu.neu.csye7374.ticket_state;

public class CancelledState implements TicketState {

    @Override
    public void handleState(TicketContext ticketContext) {
        System.out.println("Ticket booking is cancelled.");
        ticketContext.setState(this);
    }
}


