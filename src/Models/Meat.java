package Models;

import java.time.LocalDate;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(String ID, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(ID, name, manufacturingDate, cost);
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
                "weight=" + weight + "kg" +
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
        double moneyPayable;
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
        } else {
            //  Thịt đã quá hạn
            moneyPayable = -1;
        }
        return moneyPayable;
    }
}
