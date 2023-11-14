package com.qzh.overview.behavioral;

/**
 * 策略模式
 * 是一种行为型设计模式，它定义了一组算法，将每个算法都封装起来，并使它们可以相互替换。策略模式让算法的变化独立于使用算法的客户端。
 */
public class StrategyPattern {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        shoppingCart.setPaymentStrategy(creditCardPayment);
        shoppingCart.checkout(1000);
        // 输出：使用信用卡支付：1000.0，卡号：1234-5678-9012-3456，持卡人：John Doe

        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        shoppingCart.setPaymentStrategy(payPalPayment);
        shoppingCart.checkout(500);
    }

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String name;

        public CreditCardPayment(String cardNumber, String name) {
            this.cardNumber = cardNumber;
            this.name = name;
        }

        @Override
        public void pay(double amount) {
            System.out.println("使用信用卡支付：" + amount + "，卡号：" + cardNumber + "，持卡人：" + name);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(double amount) {
            System.out.println("使用PayPal支付：" + amount + "，邮箱：" + email);
        }
    }

   static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(double amount) {
            paymentStrategy.pay(amount);
        }
    }
}
