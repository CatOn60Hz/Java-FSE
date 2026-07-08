package Exercise2_EcommerceSearch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Desk Chair", "Furniture"),
            new Product("P004", "Notebook", "Stationery"),
            new Product("P005", "Monitor", "Electronics")
        };

        // Linear Search test
        System.out.println("Linear Search:");
        Product foundLinear = SearchAlgorithms.linearSearch(products, "P003");
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        // Binary Search test
        // First sort the array for binary search
        Arrays.sort(products);
        
        System.out.println("\nBinary Search:");
        Product foundBinary = SearchAlgorithms.binarySearch(products, "P004");
        System.out.println(foundBinary != null ? foundBinary : "Product not found");
    }
}
