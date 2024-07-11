/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 25-11-23
 * Products by Category
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    
    private static final String JDBC_URL = "jdbc:sqlite:guitar_shop.sqlite";

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Category");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int categoryId = resultSet.getInt("categoryID");
                String categoryName = resultSet.getString("categoryName");
                categories.add(new Category(categoryId, categoryName));
            }

        } catch (SQLException e) {
            System.out.println("Error" + e);// Handle exception
        }

        return categories;
    }

    public List<Product> getProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE categoryID = ?");
        ) {
            statement.setInt(1, categoryId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int productId = resultSet.getInt("productID");
                    String productCode = resultSet.getString("productCode");
                    String productName = resultSet.getString("productName");
                    double listPrice = resultSet.getDouble("listPrice");
                    products.add(new Product(productId, categoryId, productCode, productName, listPrice));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error" + e);// Handle exception
        }

        return products;
    }
}