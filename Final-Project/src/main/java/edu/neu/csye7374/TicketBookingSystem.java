package edu.neu.csye7374;

import edu.neu.csye7374.builder.TicketBuilder;
import edu.neu.csye7374.customer_observer.Customer;
import edu.neu.csye7374.customer_observer.TicketObserver;
import edu.neu.csye7374.customer_observer.TicketSubject;
import edu.neu.csye7374.payment_adapter.ExternalPaymentGateway;
import edu.neu.csye7374.payment_adapter.PaymentGatewayAdapter;
import edu.neu.csye7374.processing.ConcertTicketProcessing;
import edu.neu.csye7374.processing.TicketProcessingTemplate;
import edu.neu.csye7374.ticket_command.BookTicketCommand;
import edu.neu.csye7374.ticket_command.CancelTicketCommand;
import edu.neu.csye7374.ticket_command.Command;
import edu.neu.csye7374.ticket_decorator.TicketDrinksDecorator;
import edu.neu.csye7374.ticket_decorator.TicketInsuranceDecorator;
import edu.neu.csye7374.ticket_decorator.TicketPopCornDecorator;
import edu.neu.csye7374.ticket_facade.TicketBookingFacade;
import edu.neu.csye7374.ticket_model.Ticket;
import edu.neu.csye7374.ticket_model.TicketFactory;
import edu.neu.csye7374.ticket_state.AvailableState;

public class TicketBookingSystem {
    public static void demo() {
        // 1. Use the Builder pattern to create a movie ticket
        TicketBuilder ticketBuilder = new TicketBuilder();
        Ticket movieTicket = ticketBuilder
                .setTitle("Inception")
                .setEventDate("2024-08-15")
                .setPrice(12.0)
                .build();

        // 2. Create a concert ticket using the factory pattern
        Ticket concertTicket = TicketFactory.createTicket("concert", "Rock Fest", "2024-09-05", 55.0);

        // 3. Set initial state for the tickets (State Pattern)
        movieTicket.setState(new AvailableState());
        concertTicket.setState(new AvailableState());

        // 4. Manage ticket states
        movieTicket.book();    // Book the movie ticket
        concertTicket.book();  // Book the concert ticket

        // 5. Decorate the movie ticket with additional features (Decorator Pattern)
        Ticket insuredMovieTicket = new TicketInsuranceDecorator(movieTicket, 5.0);
        Ticket insuredPopcornAndDrinksMovieTicket = new TicketDrinksDecorator(new TicketPopCornDecorator(insuredMovieTicket, 3.0), 4.0);

        // 6. Process the concert ticket using the template method pattern (Template Method Pattern)
        TicketProcessingTemplate concertProcessing = new ConcertTicketProcessing();
        concertProcessing.processTicket();

        // 7. Use the command pattern to book and cancel tickets (Command Pattern)
        ExternalPaymentGateway externalPaymentGateway = new ExternalPaymentGateway();
        PaymentGatewayAdapter paymentAdapter = new PaymentGatewayAdapter(externalPaymentGateway);

        Command bookMovieCommand = new BookTicketCommand(insuredPopcornAndDrinksMovieTicket, paymentAdapter);
        Command cancelConcertCommand = new CancelTicketCommand(concertTicket);


        bookMovieCommand.execute();
        cancelConcertCommand.execute();

        // 8. Observer pattern - notify customers (Observer Pattern)
        TicketSubject ticketSubject = new TicketSubject();
        TicketObserver customer1 = new Customer("John Doe", "john.doe@gmail.com");
        TicketObserver customer2 = new Customer("Jane Smith", "jane.smith@gmail.com");

        ticketSubject.attach(customer1);
        ticketSubject.attach(customer2);

        ticketSubject.notifyObservers("The movie 'Inception' has been booked successfully.");

        // 9. Use the facade pattern to simplify the booking process (Facade Pattern)
        TicketBookingFacade bookingFacade = new TicketBookingFacade();
        bookingFacade.bookTicket("movie", false);  // Book a movie ticket with multiple features
        bookingFacade.bookTicket("concert", true); // Book a concert ticket with one-click processing

        // 10. Display final ticket information
        insuredPopcornAndDrinksMovieTicket.printTicketInfo();
        concertTicket.printTicketInfo();
    }
}

