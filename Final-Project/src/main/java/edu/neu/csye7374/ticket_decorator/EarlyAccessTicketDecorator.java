package edu.neu.csye7374.ticket_decorator;

import edu.neu.csye7374.ticket_model.Ticket;

public class EarlyAccessTicketDecorator extends Ticket {
    private Ticket ticket;
    private double earlyAccessCost;

    public EarlyAccessTicketDecorator(Ticket ticket, double earlyAccessCost) {
        super(ticket);  // Call the copy constructor
        this.ticket = ticket;
        this.earlyAccessCost = earlyAccessCost;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + earlyAccessCost;
    }

    @Override
    public void printTicketInfo() {
        ticket.printTicketInfo();
        System.out.println(" + Early Access: $" + earlyAccessCost);
    }
}
