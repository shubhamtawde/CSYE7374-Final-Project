package edu.neu.csye7374.ticket_command;

import edu.neu.csye7374.ticket_model.Ticket;

public class CancelTicketCommand implements Command {
    private Ticket ticket;

    public CancelTicketCommand(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void execute() {
        System.out.println("Cancelling ticket: " + ticket.getTitle() + ", Event Date: " + ticket.getEventDate());
        ticket.cancel();
    }
}
