package DoAnOOP.Entity;
import DoAnOOP.Manager.Validate;

public class DetailBill {
    ListProduct lisProduct = new ListProduct();

    private String idProduct;
    private String nameProduct;
    private int price;
    private int quantity;
    private int total;

    //Constructor
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

    //Getter & Setter
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

    //Hàm nhập
    public void input(){
        
        //Nhập mã sản phẩm và kiểm tra với từng mã sản phẩm trong kho
        do{
            lisProduct.readData();
            lisProduct.showProduct(true);
            idProduct = new Validate().checkStringUser("Nhap ma san pham"); 
			if(lisProduct.transPriceProduct(idProduct) == 0)
				System.err.println("\nMã san pham mà bạn vừa nhập không hợp lệ hoặc không có trong danh sách!!!");
        }while(lisProduct.transPriceProduct(idProduct) == 0);
            
            //Lấy giá trị giá tiền,tên sản phẩm,số lượng sản phẩm tương ứng
		    price = lisProduct.transPriceProduct(idProduct);
            nameProduct = lisProduct.transNameProduct(idProduct);
            int quantityCheck = lisProduct.transQuantityProduct(idProduct);

            //Nhập số lượng sản phẩm cần mua
            do{
                quantity=new Validate().checkNumberInput("Nhập số lượng sản phẩm","Số lượng sản phẩm > 0, vui lòng nhập lại !");
                if(quantity > quantityCheck){
                    System.out.println("Sản phẩm trong kho không đủ !");
                }
            }while (quantity > quantityCheck);

            //Tính tiền từng chi tiết hóa đơn
            total = price*quantity;
    }

    //Hàm xuất
    public void print(){
        System.out.println(idProduct+"|"+nameProduct+"|"+price+"|"+quantity+"|"+total);
    }

    //Ghi chi tiết hóa đơn vào File
    public String printToFile() {
        return nameProduct + "|"+ idProduct + "|" + price + "|" + quantity + "|" + total;
    }
}
