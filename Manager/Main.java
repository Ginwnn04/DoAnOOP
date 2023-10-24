package DoAnOOP.Manager;

import DoAnOOP.Entity.Foods;
import DoAnOOP.Entity.Genarate;
import DoAnOOP.Entity.Drinks;
import DoAnOOP.Entity.Product;

public class Main {
    public static void main(String[] args) {
        Product[] listP = new Product[3];
        listP[0] = new Foods(new Genarate().genarateIdProduct("FD"), "Ca chua", "Trai", 5, "20/10/202301", "30/10/2023", 100000, "Rau cu", 332);
        listP[1] = new Drinks(new Genarate().genarateIdProduct("DK"), "C2 tra dao", 440, "Chai", 3, "22/2/2022", "22/2/2030", 150000);
        listP[2] = new Foods(new Genarate().genarateIdProduct("FD"), "Thit bo", "Kg", 5, "11/2/2023", "21/6/2024", 235000, "Gia cam", 221);
        for(Product x: listP) {
            x.print();
        }
    }
}