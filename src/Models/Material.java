package Models;

import java.time.LocalDate;

public abstract class Material {
    private String ID;
    private String name;
    private LocalDate manufacturingDate;
    private double cost;

    public Material() {
    }

    public Material(String ID, String name, double cost) {
        this.ID = ID;
        this.name = name;
        this.cost = cost;
    }

    public abstract double getPayment();

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract LocalDate getExpiryDate();

    @Override
    public String toString() {
        return "Material{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}
