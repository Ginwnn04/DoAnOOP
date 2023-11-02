package DoAnOOP.Entity;
import java.util.Scanner;

public class detailBill {
    public static Scanner in= new Scanner(System.in);
    String idProduct;
    String nameProduct;
    int quantity;
    float price;

    public detailBill(){
        this.idProduct="";
        this.nameProduct="";
        this.quantity=0;
        this.price=0;
    }

    public detailBill(String idProduct, String nameProduct, int quantity, float price){
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.quantity=quantity;
        this.price=price;
     }

    public String getidProduct(){
        return idProduct;
    }
    public void setidProduct(String idProduct){
        this.idProduct=idProduct;
    }

    public String getnameProduct(){
        return nameProduct;
    }
    public void setnameProduct(String nameProduct){
        this.nameProduct=nameProduct;
    }

    public int getquantity(){
        return quantity;
    }
    public void setquantity(int quantity){
        this.quantity=quantity;
    }

    public float getprice(){
        return price;
    }
    public void setprice(int price){
        this.price=price;
    }

    public float total(){
        return price*quantity;
    }
    
    public void xuat(){
        System.out.println(nameProduct+" "+quantity+" : "+(quantity*price));
    }

    public void nhap(){
        System.out.print("Nhap ma san pham : ");
        idProduct=in.nextLine();
        System.out.print("Nhap ten san pham : ");
        nameProduct=in.nextLine();
        System.out.print("Nhap so luong san pham : ");
        quantity=in.nextInt();
        System.out.print("Nhap gia san pham : ");
        price=in.nextFloat();in.nextLine();
    }
}
