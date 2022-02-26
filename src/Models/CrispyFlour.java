package Models;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private double quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String ID, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(ID, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity + "kg" +
                "}";
    }

    @Override
    public double getPayment() {
        double payment = getQuantity() * getCost();
        return payment;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate expiryDate = getManufacturingDate().plusYears(1);
        return expiryDate;
    }
}
