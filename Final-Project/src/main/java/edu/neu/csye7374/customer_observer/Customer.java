package edu.neu.csye7374.customer_observer;

import edu.neu.csye7374.ticket_model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author Panzi
 * @Date 2023/12/8 13:53
 * @Version 1.0
 */
public class Customer implements TicketObserver{
    private String name;
    private String email;
    private List<Ticket> tickets;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        tickets = new ArrayList<>();
    }

    public Customer() {
        tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification. Message: " + message);
    }
}
