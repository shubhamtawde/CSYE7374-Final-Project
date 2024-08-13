package edu.neu.csye7374.customer_observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @ClassName TicketSubject
 * @Description TODO
 * @Author Panzi
 * @Date 2023/12/8 14:17
 * @Version 1.0
 */
public class TicketSubject  implements Subject {
    private List<TicketObserver> observers = new ArrayList<>();

    @Override
    public void attach(TicketObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(TicketObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (TicketObserver observer : observers) {
            observer.update(message);
        }
    }
}
