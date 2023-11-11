import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetailBill {
    String idProduct;
    int quantity;

    public DetailBill(){
        this.idProduct="";
        this.quantity=0;
    }

    public DetailBill(String idProduct, int quantity){
        this.idProduct=idProduct;
        this.quantity=quantity;
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

    public float price(ListProduct listProduct) {
        float price=0;
        if (idProduct != null && !idProduct.isEmpty()) {
            Product matchedProduct = listProduct.getVoucherByCode(idProduct);
            if (matcheProduct != null) {
                price = matchedProduct.getprice();
            }
        }
        return price;
    }

    public String nameProduct(ListProduct listProduct) {
        String nameProduct="";
        if (idProduct != null && !idProduct.isEmpty()) {
            Product matchedProduct = listProduct.getVoucherByCode(idProduct);
            if (matcheProduct != null) {
                nameProduct = matchedProduct.getnameProduct();
            }
        }
        return nameProduct;
    }

    public void input(){
        idProduct=new Validate().checkStringUser("Nhập mã sản phẩm");
        quantity=new Validate().checkIntUser("Nhập số lượng sản phẩm");
    }

    public void print(ListProduct listProduct){
        System.out.println(idProduct+" | "+nameProduct(listProduct)+" | "+quantity+" | "+total(listProduct));
    }

    public float total(ListProduct listProduct){
        return quantity*price(listProduct);
    }
}