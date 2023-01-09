package Dishes;

import java.io.Serializable;

public class Dish implements Serializable {

    private static final long serialVersionUID = 6L;
    private int id;
    private String name;
    private float price;
    private String description;
    private int timeToCook;
    private String type;

    public Dish(int id, String name, float price, String description, int timeToCook, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.timeToCook = timeToCook;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeToCook() {
        return timeToCook;
    }
    public void setTimeToCook(int timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", timeToCook=" + timeToCook +
                ", type='" + type + '\'' +
                '}';
    }
}
