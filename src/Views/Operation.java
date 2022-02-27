package Views;

import Controllers.MaterialManager;
import Models.Flour;
import Models.Material;
import Models.Meat;

import java.time.LocalDate;
import java.util.LinkedList;

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
        Material breadFlour = new Flour("c2", "Bột bánh mì", 52000.0, 0.9);
        Material cornFlour = new Flour("c2", "Bột ngô", 53000.0, 1.3);
        Material oatFlour = new Flour("c2", "Bột yến mạch", 54000.0, 1.7);
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
        //  Thêm vật liệu mới

        //  Sửa vật liệu

        //  Xoá vật liệu

        //  Tính chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay

    }
}
