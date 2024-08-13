package edu.neu.csye7374.payment_adapter;

/**
 * @ClassName PaymentGatewayAdapter
 * @Description TODO
 * @Author Panzi
 * @Date 2023/12/8 14:46
 * @Version 1.0
 */
public class PaymentGatewayAdapter implements PaymentGateway {
    private ExternalPaymentGateway externalPaymentGateway;

    public PaymentGatewayAdapter(ExternalPaymentGateway externalPaymentGateway) {
        this.externalPaymentGateway = externalPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        externalPaymentGateway.makePayment(amount);
    }
}