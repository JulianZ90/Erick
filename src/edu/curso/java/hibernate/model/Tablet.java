package edu.curso.java.hibernate.model;


public class Tablet {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String operatingSystem;

    private String capacity;

    public Tablet(String name, String description, Double price,
            String operatingSystem, String capacity) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Tablet [id=" + id + ", name=" + name + ", description="
                + description + ", price=" + price + ", operatingSystem="
                + operatingSystem + ", capacity=" + capacity + "]";
    }

}
