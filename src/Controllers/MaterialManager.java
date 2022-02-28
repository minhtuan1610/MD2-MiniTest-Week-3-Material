package Controllers;

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

    //  Sửa vật liệu
    public static void editMaterial(LinkedList<Material> listOfMaterial) {

    }

    //  Hiển thị thông tin sản phẩm
    public static void displayMaterial(LinkedList<Material> listOfMaterial) {
        for (Material i : listOfMaterial
        ) {
            System.out.println(i);
        }

    }
    //  Tính chênh lệch giá giữa sản phẩm chiết khấu và không chiết khấu

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
}
