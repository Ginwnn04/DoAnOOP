package DoAnOOP.Entity;

import DoAnOOP.Manager.Validate;


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

    public int price(ListProduct listProduct) {
        int price=0;
        if (idProduct != null && !idProduct.isEmpty()) {
            Product matchedProduct = listProduct.getProductByCode(idProduct);
            if (matchedProduct != null) {
                price = matchedProduct.getPrice();
            }
        }
        return price;
    }

    public String nameProduct(ListProduct listProduct) {
        String nameProduct="";
        if (idProduct != null && !idProduct.isEmpty()) {
            Product matchedProduct = listProduct.getProductByCode(idProduct);
            if (matchedProduct != null) {
                nameProduct = matchedProduct.getNameProduct();
            }
        }
        return nameProduct;
    }

    public void input(ListProduct listProduct){
        int matchedquantity=0;
        idProduct=new Validate().checkStringUser("Nhập mã sản phẩm");
        do{
        quantity=new Validate().checkIntUser("Nhập số lượng sản phẩm");
        if (idProduct != null && !idProduct.isEmpty()) {
            Product matchedProduct = listProduct.getProductByCode(idProduct);
            if (matchedProduct != null) {
                matchedquantity = matchedProduct.getQuantity();
                }
            }
            if(quantity>matchedquantity){
            System.out.println("Số lượng sản phẩm trong kho không đủ!");
            }
        }while(quantity>matchedquantity);
    }

    public void print(ListProduct listProduct){
        System.out.println(idProduct+" | "+nameProduct(listProduct)+" | "+quantity+" | "+total(listProduct));
    }

    public float total(ListProduct listProduct){
        return quantity*price(listProduct);
    }
}
