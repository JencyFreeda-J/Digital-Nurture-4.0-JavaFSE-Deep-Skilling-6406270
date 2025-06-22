// Exercise 3: Sorting Customer Orders

import java.util.*;

// Step 2: Setup - Order class
class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

public class OrderSorting {

    // Step 3: Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Step 3: Quick Sort Implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Utility: Print array
    public static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order("O001", "Alice", 1500.0),
                new Order("O002", "Bob", 750.0),
                new Order("O003", "Charlie", 3000.0),
                new Order("O004", "Diana", 1200.0),
                new Order("O005", "Evan", 2200.0)
        };

        // Copy for different sorting methods
        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        Order[] quickSorted = Arrays.copyOf(orders, orders.length);

        // Bubble Sort
        System.out.println("--- Bubble Sort ---");
        bubbleSort(bubbleSorted);
        printOrders(bubbleSorted);

        // Quick Sort
        System.out.println("\n--- Quick Sort ---");
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders(quickSorted);
    }
}