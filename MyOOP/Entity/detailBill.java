package MyOOP.Entity;

import MyOOP.Manager.Validate;

public class detailBill {
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
        idProduct=new Validate().checkStringUser("Nhập mã sản phẩm");
        for(int i=0;i<dssp.length;i++){
            if((dssp[i].getidProduct()).equals(idProduct)){ /*dssp : ListProduct */
                nameProduct=dssp[i].nameProduct;
                price=dssp[i].price;
            }
        }

        quantity=new Validate().checkIntUser("Nhập số lượng sản phẩm");
    }
}
