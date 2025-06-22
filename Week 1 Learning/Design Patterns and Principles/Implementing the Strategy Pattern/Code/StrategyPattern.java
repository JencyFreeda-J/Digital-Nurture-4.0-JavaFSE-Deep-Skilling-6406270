// Filename: StrategyPattern.java

// Step 2: Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}

// Step 4: Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment strategy set.");
        } else {
            strategy.pay(amount);
        }
    }
}

// Step 5: Test Class
public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("--- Paying with Credit Card ---");
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.processPayment(100.0);

        System.out.println("--- Paying with PayPal ---");
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.processPayment(250.5);
    }
}