package Models;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    public static final int OUT_OF_DATE = 0;
    private double weight;

    public Meat() {
    }

    public Meat(String ID, String name, double cost, double weight) {
        super(ID, name, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "ID='" + getName() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate='" + getManufacturingDate() + '\'' +
                ", cost= " + getCost() +
                ", weight= " + weight + " kg" +
                '}';
    }

    @Override
    public double getPayment() {
        double payment = getCost() * getWeight();
        return payment;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate expiryDate = getManufacturingDate().plusDays(7);
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
            if (today.isAfter(expiryDate.minusDays(5))) {
                //  Nếu thịt còn 5 ngày hết hạn thì giảm giá 30%
                discount = 30d / 100; //thể hiện kiểu dữ liệu là double
            } else {
                //  Các trường hợp còn lại chỉ giảm giá 10%
                discount = 10d / 100; //thể hiện kiểu dữ liệu là double
            }
            moneyPayable = payment * (1 - discount);
        }
        return moneyPayable;
    }
}
