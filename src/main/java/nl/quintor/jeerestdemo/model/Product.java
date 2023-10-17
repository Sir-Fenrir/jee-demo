package nl.quintor.jeerestdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import nl.quintor.jeerestdemo.Category;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Naam mag niet leeg zijn")
    private String name;

    @PositiveOrZero
    private float price;

    @Enumerated(EnumType.STRING)
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
