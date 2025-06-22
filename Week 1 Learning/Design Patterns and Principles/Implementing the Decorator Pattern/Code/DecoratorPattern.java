// Filename: DecoratorPattern.java

// Step 2: Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Concrete Component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent with message: " + message);
    }
}

// Step 4a: Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Step 4b: Concrete Decorators
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS sent with message: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack message sent: " + message);
    }
}

// Step 5: Test class
public class DecoratorPattern {
    public static void main(String[] args) {
        // Base email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS notification
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Add Slack on top of SMS and Email
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("--- Sending Notifications ---");
        slackNotifier.send("System maintenance at 11 PM");
    }
}