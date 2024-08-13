package edu.neu.csye7374.ticket_state;

public class BookedState implements TicketState {

    @Override
    public void handleState(TicketContext ticketContext) {
        System.out.println("Ticket has been booked.");
        ticketContext.setState(this);
    }
}


