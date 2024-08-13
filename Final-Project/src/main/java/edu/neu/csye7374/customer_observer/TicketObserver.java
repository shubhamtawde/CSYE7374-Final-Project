package edu.neu.csye7374.customer_observer;

import edu.neu.csye7374.ticket_model.Ticket;

/**
 * @InterfaceName TicketObserver
 * @Description TODO
 * @Author Oneby
 * @Date 2023/12/8 13:57
 * @Version 1.0
 */
public interface TicketObserver {
    void update(String message);
}
