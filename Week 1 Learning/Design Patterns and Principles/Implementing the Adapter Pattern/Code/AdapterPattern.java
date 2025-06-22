// Filename: AdapterPattern.java

// Step 2: Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Adaptee Classes (3rd party gateways)
class PayPalGateway {
    public void makePayment(double amountInUSD) {
        System.out.println("Payment of $" + amountInUSD + " processed via PayPal.");
    }
}

class StripeGateway {
    public void pay(double dollars) {
        System.out.println("Payment of $" + dollars + " processed via Stripe.");
    }
}

class RazorpayGateway {
    public void executeTransaction(double amountINR) {
        System.out.println("Payment of ₹" + amountINR + " processed via Razorpay.");
    }
}

// Step 4: Adapter Classes
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter() {
        this.paypal = new PayPalGateway();
    }

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    public StripeAdapter() {
        this.stripe = new StripeGateway();
    }

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter() {
        this.razorpay = new RazorpayGateway();
    }

    public void processPayment(double amount) {
        razorpay.executeTransaction(amount);
    }
}

// Step 5: Test class
public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        PaymentProcessor stripeProcessor = new StripeAdapter();
        PaymentProcessor razorpayProcessor = new RazorpayAdapter();

        System.out.println("--- Processing payments using adapters ---");
        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(250.5);
        razorpayProcessor.processPayment(4500.75);
    }
}