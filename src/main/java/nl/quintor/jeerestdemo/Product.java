package nl.quintor.jeerestdemo;

public class Product {

    private String name;

    private float price;

    private Category category;

    public Product() {
        // Necessary for JSON deserialization
    }

    public Product(String name, float price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
