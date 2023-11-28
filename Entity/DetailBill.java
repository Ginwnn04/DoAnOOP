package DoAnOOP.Entity;
import DoAnOOP.Manager.Validate;

import java.io.BufferedReader;
import java.io.FileReader;

public class DetailBill {
    String idProduct;
    String nameProduct;
    int price;
    int quantity;
    int quantityCheck;
    int total;

    public DetailBill(){
        this.idProduct="";
        this.nameProduct="";
        this.price=0;
        this.quantity=0;
        this.total=0;
    }

    public DetailBill(String nameProduct,String idProduct,int price, int quantity, int total ){
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.price=price;
        this.quantity=quantity;
        this.total=total;
     }

    public String getidProduct(){
        return idProduct;
    }
    public void setidProduct(String idProduct){
        this.idProduct=idProduct;
    }

    public int getquantity(){
        return quantity;
    }
    public void setquantity(int quantity){
        this.quantity=quantity;
    }

   public String getnameProduct(){
        return nameProduct;
    }
    public void setnameProduct(String nameProduct){
        this.nameProduct=nameProduct;
    }

    public int getprice(){
        return price;
    }
    public void setprice(int price){
        this.price=price;
    }
    public int gettotal(){
        return total;
    }
    public void settotal(int total){
        this.total=total;
    }
    public void input(){
        idProduct=new Validate().checkStringUser("Nhập mã sản phẩm");
        quantity=new Validate().checkNumberInput("Nhập số lượng sản phẩm","Số lượng sản phẩm > 0, vui lòng nhập lại !");
        readData();
        if(quantity>quantityCheck){
            System.out.println("Sản phẩm trong kho không đủ !");
        }
        total = price*quantity;
    }

    public void print(){
        System.out.println(idProduct+"|"+nameProduct+"|"+price+"|"+quantity+"|"+total);
    }

    public String printToFile() {
        return nameProduct + "|"+ idProduct + "|" + price + "|" + quantity + "|" + total;
    }

    public void readData(){
        try {
            FileReader fileReader = new FileReader("KhoSanPham.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                String[] split =  line.split("\\|");
                String idProductFile = split[0];
                String nameProductFile = split[1];
                int quantityFile = Integer.parseInt(split[3]);
                int priceFile = Integer.parseInt(split[5]);
                if(idProductFile.equals(idProduct)){
                    nameProduct = nameProductFile;
                    price = priceFile;
                    quantityCheck = quantityFile;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
