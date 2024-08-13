package edu.neu.csye7374.customer_observer;

import java.util.Observer;

/**
 * @InterfaceName Subject
 * @Description TODO
 * @Author Oneby
 * @Date 2023/12/8 14:17
 * @Version 1.0
 */
public interface Subject {
    void attach(TicketObserver observer);
    void detach(TicketObserver observer);
    void notifyObservers(String message);
}
