/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 25-11-23
 * Products by Category
 */

public class Product {
    
    private int productId;
    private int categoryId;
    private String productCode;
    private String productName;
    private double listPrice;

    public Product(int productId, int categoryId, String productCode, String productName, double listPrice) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productCode = productCode;
        this.productName = productName;
        this.listPrice = listPrice;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getListPrice() {
        return listPrice;
    }
}