package Manager;

import Entity.Food;
import Entity.Genarate;
import Entity.HouseholdItems;
import Entity.Product;

public class Main {
    public static void main(String[] args) {
        Product[] listP = new Product[3];
        listP[0] = new Food(new Genarate().genarateIdProduct("FD"), "Ca chua", "Rau cu", "Trai", 5, "20/10/202301", "30/10/2023", 100000);
        listP[1] = new HouseholdItems(new Genarate().genarateIdProduct("HA"), "Con dao", "Inox khong ri", "Cai", 3, "22/2/2022", "22/2/2030", 150000);
        listP[2] = new Food(new Genarate().genarateIdProduct("FD"), "Thit bo", "Gia cam", "Kg", 5, "11/2/2023", "21/6/2024", 235000);
        for(Product x: listP) {
            x.print();
        }
    }
}