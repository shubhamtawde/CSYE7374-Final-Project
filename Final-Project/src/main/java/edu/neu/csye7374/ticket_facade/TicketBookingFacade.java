package edu.neu.csye7374.ticket_facade;

import edu.neu.csye7374.payment_adapter.ExternalPaymentGateway;
import edu.neu.csye7374.payment_adapter.PaymentGateway;
import edu.neu.csye7374.payment_adapter.PaymentGatewayAdapter;
import edu.neu.csye7374.processing.ConcertTicketProcessing;
import edu.neu.csye7374.processing.MovieTicketProcessing;
import edu.neu.csye7374.processing.TicketProcessingTemplate;
import edu.neu.csye7374.ticket_command.BookTicketCommand;
import edu.neu.csye7374.ticket_command.Command;
import edu.neu.csye7374.ticket_decorator.EarlyAccessTicketDecorator;
import edu.neu.csye7374.ticket_decorator.TicketDrinksDecorator;
import edu.neu.csye7374.ticket_decorator.TicketInsuranceDecorator;
import edu.neu.csye7374.ticket_decorator.TicketPopCornDecorator;
import edu.neu.csye7374.ticket_model.Ticket;
import edu.neu.csye7374.ticket_model.TicketFactory;
import edu.neu.csye7374.ticket_state.BookedState;
import edu.neu.csye7374.ticket_state.TicketState;
import edu.neu.csye7374.ticket_strategy.PricingStrategy;
import edu.neu.csye7374.ticket_strategy.VIPPricingStrategy;

public class TicketBookingFacade {

    public TicketBookingFacade() {
    }

    public void bookTicket(String ticketType, boolean oneClick) {
        if (oneClick) {
            // Handling tickets using template method pattern
            if ("movie".equals(ticketType)) {
                TicketProcessingTemplate ticketProcessing = new MovieTicketProcessing();
                ticketProcessing.processTicket();
                return;
            }
            if ("concert".equals(ticketType)) {
                TicketProcessingTemplate ticketProcessing = new ConcertTicketProcessing();
                ticketProcessing.processTicket();
                return;
            }
        }

        // Create movie ticket using factory pattern
        Ticket ticket = TicketFactory.createTicket(ticketType, "Event Title", "2024-12-12", 50.0);

        // Use prototype mode to copy the ticket (if needed)
        Ticket clonedTicket = ticket.clone();

        // Decorate the ticket with multiple features (Decorator Pattern)
        Ticket decoratedTicket = new TicketPopCornDecorator(
                new TicketInsuranceDecorator(
                        new TicketDrinksDecorator(
                                new EarlyAccessTicketDecorator(clonedTicket, 10.0), 5.0), 7.0), 3.0);

        // Update the ticket price using a pricing strategy
        PricingStrategy pricingStrategy = new VIPPricingStrategy(0.2);
        ticket.setPrice(pricingStrategy.calculatePrice(decoratedTicket.getPrice()));

        // Create a payment gateway adapter
        PaymentGateway paymentGateway = new PaymentGatewayAdapter(new ExternalPaymentGateway());

        // Create a command to book the ticket
        Command bookTicket = new BookTicketCommand(decoratedTicket, paymentGateway);
        // Execute the command
        bookTicket.execute();

        // Update the status of a ticket using state pattern
        TicketState bookedState = new BookedState();
        decoratedTicket.setState(bookedState);
        decoratedTicket.handleState();

        decoratedTicket.printTicketInfo();
    }
}
