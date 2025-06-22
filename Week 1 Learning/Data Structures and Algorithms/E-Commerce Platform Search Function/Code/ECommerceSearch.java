// Step 1: Understand Asymptotic Notation
// Big O notation describes the upper bound of an algorithm's time or space complexity in terms of input size.
// Linear Search: Best - O(1), Average/Worst - O(n)
// Binary Search: Best - O(1), Average/Worst - O(log n) [Requires sorted array]

import java.util.*;

class Product implements Comparable<Product> {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class ECommerceSearch {

    // Step 3: Linear Search Implementation
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Step 3: Binary Search Implementation
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Step 2: Setup Products
        Product[] products = {
            new Product("101", "Laptop", "Electronics"),
            new Product("102", "Shirt", "Clothing"),
            new Product("103", "Book", "Education"),
            new Product("104", "Mobile", "Electronics"),
            new Product("105", "Shoes", "Footwear")
        };

        // Linear Search Demo
        System.out.println("--- Linear Search ---");
        Product result1 = linearSearch(products, "Mobile");
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort for Binary Search
        Arrays.sort(products); // Step 3 requirement

        // Binary Search Demo
        System.out.println("\n--- Binary Search ---");
        Product result2 = binarySearch(products, "Mobile");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}