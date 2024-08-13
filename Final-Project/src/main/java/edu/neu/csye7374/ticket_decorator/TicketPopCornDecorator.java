package edu.neu.csye7374.ticket_decorator;

import edu.neu.csye7374.ticket_model.Ticket;

public  class TicketPopCornDecorator extends Ticket {
    private Ticket ticket;
    private double popcornCost;

    public TicketPopCornDecorator(Ticket ticket, double popcornCost) {
        super(ticket);
        this.ticket = ticket;
        this.popcornCost = popcornCost;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + popcornCost;
    }

    @Override
    public void printTicketInfo() {
        ticket.printTicketInfo();
        System.out.println(" + Popcorn has been added to your ticket. Cost: " + popcornCost);
    }
}
