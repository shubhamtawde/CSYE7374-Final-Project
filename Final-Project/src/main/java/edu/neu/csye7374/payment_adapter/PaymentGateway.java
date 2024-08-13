package edu.neu.csye7374.payment_adapter;

/**
 * @InterfaceName PaymentGateway
 * @Description TODO
 * @Author Oneby
 * @Date 2023/12/8 14:45
 * @Version 1.0
 */
public interface PaymentGateway {
    void processPayment(double amount);
}
