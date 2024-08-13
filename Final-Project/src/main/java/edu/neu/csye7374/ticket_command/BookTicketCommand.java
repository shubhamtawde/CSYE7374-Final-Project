package edu.neu.csye7374.ticket_command;

import edu.neu.csye7374.payment_adapter.PaymentGateway;
import edu.neu.csye7374.ticket_model.Ticket;
import edu.neu.csye7374.ticket_state.BookedState;

public class BookTicketCommand implements Command {
    private Ticket ticket;
    private PaymentGateway paymentGateway;

    public BookTicketCommand(Ticket ticket, PaymentGateway paymentGateway) {
        this.ticket = ticket;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void execute() {
        // Check if the ticket is available for booking
        if (ticket.isAvailable()) {
            // Process the booking
            bookTicket();

            // Process payment using the payment gateway
            paymentGateway.processPayment(ticket.getPrice());

            // Update the ticket's state to booked
            ticket.setState(new BookedState());

            // Optionally, send a booking confirmation
            sendBookingConfirmation();
        } else {
            System.out.println("Ticket booking failed, ticket is not available.");
        }
    }

    private void bookTicket() {
        // Implement the booking logic, e.g., deducting the amount from the user's account
        System.out.println("Booking the ticket: " + ticket.getTitle() + " on " + ticket.getEventDate());
    }

    private void sendBookingConfirmation() {
        // Implement the logic to send booking confirmation, e.g., via email or SMS
        System.out.println("Sending booking confirmation for " + ticket.getTitle());
    }
}
