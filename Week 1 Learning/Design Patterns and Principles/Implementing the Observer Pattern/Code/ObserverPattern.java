// Filename: ObserverPattern.java

import java.util.*;

// Step 2: Subject Interface
interface Stock {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// Step 4: Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

// Step 5: Concrete Observers
class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("[Mobile] " + user + " notified: " + stockName + " is now $" + price);
    }
}

class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double price) {
        System.out.println("[Web] " + user + " notified: " + stockName + " is now $" + price);
    }
}

// Step 6: Test Class
public class ObserverPattern {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Alice");
        Observer webUser = new WebApp("Bob");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        System.out.println("--- Updating Stock Price ---");
        market.setStockPrice("AAPL", 210.5);

        market.removeObserver(webUser);

        System.out.println("--- Updating Stock Price Again ---");
        market.setStockPrice("AAPL", 215.0);
    }
}