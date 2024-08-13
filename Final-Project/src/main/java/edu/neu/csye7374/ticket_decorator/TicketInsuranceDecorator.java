package edu.neu.csye7374.ticket_decorator;

import edu.neu.csye7374.ticket_model.Ticket;

public  class TicketInsuranceDecorator extends Ticket {
    private Ticket ticket;
    private double insuranceCost;

    public TicketInsuranceDecorator(Ticket ticket, double insuranceCost) {
        super(ticket);
       this.ticket = ticket;
       this.insuranceCost = insuranceCost;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + insuranceCost;
    }

    @Override
    public void printTicketInfo() {
        ticket.printTicketInfo();
        System.out.println(" + Insurance has already been added to your ticket. Cost: " + insuranceCost);
    }
}
