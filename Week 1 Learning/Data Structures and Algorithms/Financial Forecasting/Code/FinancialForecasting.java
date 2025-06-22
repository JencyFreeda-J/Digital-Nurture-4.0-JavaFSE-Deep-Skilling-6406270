// Exercise 7: Financial Forecasting using Recursion

// Step 1: Understanding Recursion
// Recursion is a method where the solution to a problem depends on solutions to smaller instances of the same problem.
// It is useful for problems that have a natural recursive structure (like financial projections, Fibonacci, etc.).

public class FinancialForecasting {

    // Step 2 & 3: Recursive method to calculate future value
    // FV = PV * (1 + rate)^years
    public static double forecastRecursive(double currentValue, double growthRate, int years) {
        if (years == 0)
            return currentValue;
        return forecastRecursive(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using memoization (if multiple branches, not needed here as
    // it's linear)
    // Iterative version for better performance and avoiding stack overflow on large
    // inputs
    public static double forecastIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        double initialValue = 10000.0;
        double growthRate = 0.05; // 5% annual growth
        int years = 5;

        System.out.println("--- Recursive Forecast ---");
        double futureValueRecursive = forecastRecursive(initialValue, growthRate, years);
        System.out.printf("Future Value (Recursive): %.2f\n", futureValueRecursive);

        System.out.println("\n--- Iterative Forecast (Optimized) ---");
        double futureValueIterative = forecastIterative(initialValue, growthRate, years);
        System.out.printf("Future Value (Iterative): %.2f\n", futureValueIterative);
    }
}

/*
 * Step 4: Analysis
 * - Recursive Time Complexity: O(n) where n = number of years.
 * - Space Complexity: O(n) due to recursive call stack.
 * - Optimized Iterative Time Complexity: O(n), Space: O(1).
 * - Prefer iterative for large datasets to avoid stack overflow.
 */