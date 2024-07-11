/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 25-11-23
 * Products by Category
 */


import java.util.List;
import java.util.Scanner;

public class ProductsByCategoryApp {public static void main(String[] args) {
        ProductDB productDB = new ProductDB();
        Scanner scanner = new Scanner(System.in);

        int userInput;

        do {
            displayCategories(productDB.getAllCategories());

            System.out.print("Enter a category id (999 to exit): ");
            userInput = scanner.nextInt();

            if (userInput != 999) {
                displayProducts(productDB.getProductsByCategory(userInput));
            }

        } while (userInput != 999);

        System.out.println("\nBye!");
    }

    private static void displayCategories(List<Category> categories) {
        System.out.println("\nCATEGORIES\n");
        for (Category category : categories) {
            System.out.printf("%d - %s\n", category.getCategoryId(), category.getCategoryName());
        }
    }

    private static void displayProducts(List<Product> products) {
        System.out.println("\nPRODUCTS\n");
        System.out.printf("%-12s%-40s%-10s\n", "Code", "Name", "Price");
        System.out.println("-----------------------------------------------");

        for (Product product : products) {
            System.out.printf("%-12s%-40s$%-10.2f\n", product.getProductCode(), product.getProductName(), product.getListPrice());
        }
    }
    
}
