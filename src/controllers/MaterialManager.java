package controllers;

import Models.Flour;
import Models.Material;
import Models.Meat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class MaterialManager {
    //  Thiết lập thông tin của vật liệu
    public static Material setMeatInfo() {
        System.out.println("Nhập ID, tên loại thịt, đơn giá, khối lượng:");
        Scanner inputID = new Scanner(System.in);
        String ID = inputID.nextLine();

        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();

        Scanner inputCost = new Scanner(System.in);
        double cost = inputCost.nextDouble();

        Scanner inputWeight = new Scanner(System.in);
        double weight = inputWeight.nextDouble();

        Material meatInfo = new Meat(ID, name, cost, weight);
        return meatInfo;
    }   //  Thông tin của thịt

    public static Material setFlourInfo() {
        System.out.println("Nhập ID, tên loại bột, đơn giá, khối lượng:");
        Scanner inputID = new Scanner(System.in);
        String ID = inputID.nextLine();

        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();

        Scanner inputCost = new Scanner(System.in);
        double cost = inputCost.nextDouble();

        Scanner inputQuantity = new Scanner(System.in);
        double quantity = inputQuantity.nextDouble();

        Material flourInfo = new Flour(ID, name, cost, quantity);
        return flourInfo;
    }   //  Thông tin của bột

    public static LocalDate setMFD() {
        System.out.println("Nhập ngày sản xuất:");
        Scanner inputDate = new Scanner(System.in);
        int DD = inputDate.nextInt();
        System.out.println("Nhập tháng sản xuất:");
        Scanner inputMonth = new Scanner(System.in);
        int MM = inputMonth.nextInt();
        System.out.println("Nhập năm sản xuất:");
        Scanner inputYear = new Scanner(System.in);
        int YYYY = inputYear.nextInt();

        LocalDate manufacturingDate = LocalDate.of(YYYY, MM, DD);
        return manufacturingDate;
    }   //  Thông tin ngày sản xuất

    //  Tạo mới vật liệu thịt
    public static void addNewMeat(LinkedList<Material> listOfMaterial) {
        Material meat = setMeatInfo();
        meat.setManufacturingDate(setMFD());
        listOfMaterial.add(meat);
    }

    //  Tạo mới vật liệu bột
    public static void addNewFlour(LinkedList<Material> listOfMaterial) {
        Material flour = setFlourInfo();
        flour.setManufacturingDate(setMFD());
        listOfMaterial.add(flour);
    }

    //  Sửa vật liệu theo tên
    public static void editMaterialByName(LinkedList<Material> listOfMaterial, String name) {
        displayMaterial(listOfMaterial);
        //  Nhập thông tin mới của các sản phẩm
        System.out.println("New ID:");
        Scanner inputNewID = new Scanner(System.in);
        String newID = inputNewID.nextLine();
        System.out.println("New Name:");
        Scanner inputNewName = new Scanner(System.in);
        String newName = inputNewName.nextLine();
        System.out.println("New Price:");
        Scanner inputNewPrice = new Scanner(System.in);
        double newPrice = inputNewPrice.nextDouble();

        System.out.println("New manufacturing date:");
        Scanner inputNewDate = new Scanner(System.in);
        int newDate = inputNewDate.nextInt();
        System.out.println("New manufacturing month:");
        Scanner inputNewMonth = new Scanner(System.in);
        int newMonth = inputNewMonth.nextInt();
        System.out.println("New manufacturing year:");
        Scanner inputNewYear = new Scanner(System.in);
        int newYear = inputNewYear.nextInt();
        //  Sửa thông tin của sản phẩm
        for (Material i : listOfMaterial
        ) {
            if (i.getName().equals(name)) {
                i.setID(newID);
                i.setName(newName);
                i.setCost(newPrice);
                i.setManufacturingDate(LocalDate.of(newYear, newMonth, newDate));
                if (i instanceof Meat) {
                    System.out.println("New Weight:");
                    Scanner inputNewWeight = new Scanner(System.in);
                    double newWeight = inputNewWeight.nextDouble();
                    ((Meat) i).setWeight(newWeight);
                } else {
                    System.out.println("New Quantity:");
                    Scanner inputNewQuantity = new Scanner(System.in);
                    double newQuantity = inputNewQuantity.nextDouble();
                    ((Flour) i).setQuantity(newQuantity);
                }
            }
        }
    }

    // Xoá vật liệu
    public static void deleteMaterialByID(LinkedList<Material> listOfMaterial, String ID) {
        for (Material i : listOfMaterial
        ) {
            if (i.getID().equals(ID)) {
                listOfMaterial.remove(i);
                return;
            }
        }
    }

    //  Hiển thị thông tin sản phẩm
    public static void displayMaterial(LinkedList<Material> listOfMaterial) {
        for (Material i : listOfMaterial
        ) {
            System.out.println(i);
        }

    }
    //  Tính chênh lệch giá giữa sản phẩm chiết khấu và không chiết khấu

}
