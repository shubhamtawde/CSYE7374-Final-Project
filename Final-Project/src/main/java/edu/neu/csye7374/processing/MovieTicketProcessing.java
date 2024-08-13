package edu.neu.csye7374.processing;

public class MovieTicketProcessing extends TicketProcessingTemplate {
    @Override
    protected void stepOne() {
        System.out.println("Movie Ticket Step 1: Choose a movie.");
    }

    @Override
    protected void stepTwo() {
        System.out.println("Movie Ticket Step 2: Select seats.");
    }

    @Override
    protected void stepThree() {
        System.out.println("Movie Ticket Step 3: Make a payment.");
    }

    @Override
    protected void finalizeTicket() {
        System.out.println("Movie Ticket: Printing and sending the ticket.");
    }
}

