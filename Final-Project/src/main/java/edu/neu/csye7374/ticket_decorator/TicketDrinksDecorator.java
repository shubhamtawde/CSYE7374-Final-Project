package edu.neu.csye7374.ticket_decorator;

import edu.neu.csye7374.ticket_model.Ticket;

public class TicketDrinksDecorator extends Ticket {
    private Ticket ticket;
    private double drinksCost;

    public TicketDrinksDecorator(Ticket ticket, double drinksCost) {
        super(ticket);  // Call the copy constructor
        this.ticket = ticket;
        this.drinksCost = drinksCost;
    }

    @Override
    public double getPrice() {
        return ticket.getPrice() + drinksCost;
    }

    @Override
    public void printTicketInfo() {
        ticket.printTicketInfo();
        System.out.println(" + Drinks: $" + drinksCost);
    }
}