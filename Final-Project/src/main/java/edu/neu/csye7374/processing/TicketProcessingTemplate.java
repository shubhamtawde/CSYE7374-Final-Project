package edu.neu.csye7374.processing;

public abstract class TicketProcessingTemplate {
    // Template Method, defines the steps for handling ticketing
    public final void processTicket() {
        stepOne();
        stepTwo();
        stepThree();
        finalizeTicket();
    }

    protected abstract void stepOne();
    protected abstract void stepTwo();
    protected abstract void stepThree();
    protected abstract void finalizeTicket();

}

