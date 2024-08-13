package edu.neu.csye7374.payment_adapter;

/**
 * @ClassName ExternalPaymentGateway
 * @Description TODO
 * @Author Panzi
 * @Date 2023/12/8 14:46
 * @Version 1.0
 */
public class ExternalPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through external gateway.");
    }
}
