package Views;

import controllers.MaterialManager;
import Models.Flour;
import Models.Material;
import Models.Meat;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        LinkedList<Material> listOfMaterial = new LinkedList<>();
        //  Khởi tạo 5 đối tượng thịt
        Material beef = new Meat("b1", "Thịt bò", 200000.0, 1.5);
        Material pork = new Meat("p1", "Thịt lợn", 150000.0, 2.0);
        Material chicken = new Meat("c1", "Thịt gà", 120000.0, 2.5);
        Material duck = new Meat("d1", "Thịt vịt", 130000.0, 3.0);
        Material goose = new Meat("g1", "Thịt ngỗng", 100000.0, 3.5);
        //  Khởi tạo 5 đối tượng bột
        Material crispyFlour = new Flour("c2", "Bột chiên giòn", 40000.0, 0.5);
        Material wheatFlour = new Flour("w2", "Bột mì", 42000.0, 0.7);
        Material breadFlour = new Flour("b2", "Bột bánh mì", 52000.0, 0.9);
        Material cornFlour = new Flour("co2", "Bột ngô", 53000.0, 1.3);
        Material oatFlour = new Flour("o2", "Bột yến mạch", 54000.0, 1.7);
        //  Thiết lập ngày sản xuất cho 5 đối tượng thịt
        beef.setManufacturingDate(LocalDate.of(2022, 2, 23));
        pork.setManufacturingDate(LocalDate.of(2022, 2, 24));
        chicken.setManufacturingDate(LocalDate.of(2022, 2, 25));
        duck.setManufacturingDate(LocalDate.of(2022, 2, 26));
        goose.setManufacturingDate(LocalDate.of(2022, 2, 27));
        //  Thiết lập ngày sản xuất cho 5 đối tượng bột
        crispyFlour.setManufacturingDate(LocalDate.of(2019, 9, 22));
        wheatFlour.setManufacturingDate(LocalDate.of(2021, 10, 16));
        breadFlour.setManufacturingDate(LocalDate.of(2021, 11, 12));
        cornFlour.setManufacturingDate(LocalDate.of(2021, 12, 30));
        oatFlour.setManufacturingDate(LocalDate.of(2022, 1, 15));
        //  Thêm các vật liệu ban đầu vào LinkedList
        listOfMaterial.add(beef);
        listOfMaterial.add(pork);
        listOfMaterial.add(chicken);
        listOfMaterial.add(duck);
        listOfMaterial.add(goose);
        listOfMaterial.add(crispyFlour);
        listOfMaterial.add(wheatFlour);
        listOfMaterial.add(breadFlour);
        listOfMaterial.add(cornFlour);
        listOfMaterial.add(oatFlour);
        //  Hiển thị menu
        final int MENU_CHOICE = -1;
        int choice = MENU_CHOICE;
        while (choice != 0) {
            System.out.println("Lựa chọn mà bạn muốn:");
            System.out.println("1. Hiển thị tất cả các sản phẩm");
            System.out.println("2. Thêm mới sản phẩm Meat");
            System.out.println("3. Thêm mới sản phẩm Flour");
            System.out.println("4. Sửa sản phẩm");
            System.out.println("5. Xoá sản phẩm theo ID");
            System.out.println("6. Chênh lệch chiết khấu ngày hôm nay");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    MaterialManager.displayMaterial(listOfMaterial);
                    break;
                case 2: //  Thêm vật liệu mới
                    MaterialManager.addNewMeat(listOfMaterial);
                    break;
                case 3: //  Thêm vật liệu mới
                    MaterialManager.addNewFlour(listOfMaterial);
                    break;
                case 4: //  Sửa vật liệu theo tên
                    System.out.println("Nhập tên sản phẩm muốn sửa:");
                    Scanner inputName = new Scanner(System.in);
                    String initialName = inputName.nextLine();
                    MaterialManager.editMaterialByName(listOfMaterial, initialName);
                    break;
                case 5: //  Xoá vật liệu theo ID
                    System.out.println("Nhập ID sản phẩm muốn xoá:");
                    Scanner inputIdDeletion = new Scanner(System.in);
                    String IdDeletion = inputIdDeletion.nextLine();
                    MaterialManager.deleteMaterialByID(listOfMaterial, IdDeletion);
                    break;
                case 6: //  Tính chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
