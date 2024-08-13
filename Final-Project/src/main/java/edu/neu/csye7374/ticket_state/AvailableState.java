package edu.neu.csye7374.ticket_state;

public class AvailableState implements TicketState {

    @Override
    public void handleState(TicketContext ticketContext) {
        System.out.println("Ticket is available for booking.");
        ticketContext.setState(this);
    }
}


