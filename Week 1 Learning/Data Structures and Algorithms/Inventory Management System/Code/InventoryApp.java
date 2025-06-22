import java.util.*;

// Step 1: Product class definition
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

// Step 3: Inventory Management class
class InventoryManagement {
    // Using HashMap for fast lookup, insertion, and deletion (average O(1) time
    // complexity)
    private Map<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    // Add product to inventory
    public boolean addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            return false; // Product already exists
        }
        inventory.put(product.getProductId(), product);
        return true;
    }

    // Update existing product
    public boolean updateProduct(String productId, String newName, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product == null)
            return false;
        product.setProductName(newName);
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        return true;
    }

    // Delete product from inventory
    public boolean deleteProduct(String productId) {
        return inventory.remove(productId) != null;
    }

    // Display inventory
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}

// Main class to test the system
public class InventoryApp {
    public static void main(String[] args) {
        InventoryManagement im = new InventoryManagement();

        // Adding products
        im.addProduct(new Product("P001", "Laptop", 10, 75000.00));
        im.addProduct(new Product("P002", "Mouse", 50, 500.00));
        im.addProduct(new Product("P003", "Keyboard", 30, 1500.00));

        // Display inventory
        System.out.println("--- Inventory After Adding ---");
        im.displayInventory();

        // Updating product
        im.updateProduct("P002", "Wireless Mouse", 45, 600.00);

        // Display inventory after update
        System.out.println("\n--- Inventory After Update ---");
        im.displayInventory();

        // Deleting product
        im.deleteProduct("P001");

        // Display inventory after deletion
        System.out.println("\n--- Inventory After Deletion ---");
        im.displayInventory();
    }
}