/*
 * Olga Lashko
 * Programming II
 * CITC-1311-C01
 * 25-11-23
 * Products by Category
 */

public class Category {
    
    private int categoryId;
    private String categoryName;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}