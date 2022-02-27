package Models;

import java.time.LocalDate;

public class Flour extends Material implements Discount {
    public static final int OUT_OF_DATE = 0;
    private double quantity;

    public Flour() {
    }

    public Flour(String ID, String name, double cost, double quantity) {
        super(ID, name, cost);
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
                "ID='" + getID() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate='" + getManufacturingDate() + '\'' +
                ", cost= " + getCost() +
                ", quantity= " + quantity + " kg" +
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

    @Override
    public double getMoneyPayable() {
        LocalDate today = LocalDate.now();
        LocalDate expiryDate = getExpiryDate();
        double discount;
        double moneyPayable = OUT_OF_DATE;
        double payment = getPayment();

        if (today.isBefore(expiryDate) || today.equals(expiryDate)) {
            if (today.isAfter(expiryDate.minusMonths(2))) {
                //  Nếu bột chiên giòn còn 2 tháng hết hạn thì giảm giá 40%
                discount = 40d / 100; //thể hiện kiểu dữ liệu là double
            } else if (today.isAfter(expiryDate.minusMonths(4))) {
                //  Nếu bột chiên giòn còn 4 tháng hết hạn thì giảm giá 20%
                discount = 20d / 100;
            } else {
                //  Các trường hợp còn lại chỉ giảm giá 5%
                discount = 5d / 100; //thể hiện kiểu dữ liệu là double
            }
            moneyPayable = payment * (1 - discount);
        }
        return moneyPayable;
    }
}
