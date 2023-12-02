//package DoAnOOP.Entity;
//import DoAnOOP.Manager.Validate;
//import DoAnOOP.Entity.DetailBill;
//import DoAnOOP.Manager.ListVoucher;
//import DoAnOOP.Manager.ListProduct;

import java.util.Arrays;

public class Bill {
    private ListPromotionsSale listPromotionsSale = new ListPromotionsSale();
    private ListProduct listProduct = new ListProduct();

    private String idBill;
    private String idEmployee;
    private String idCustomer;
    private String nameCustomer;
    private String printDate;
    private int totalBill;
    private int moneyDiscount;
    private int totalPay;
    
    private int totalDetailBill = 0;
    private DetailBill[] detailBill = new DetailBill[totalDetailBill];

    //Constructor
    public Bill(){}

    public Bill (String idBill,String printDate, String idEmployee, String idCustomer, String nameCustomer, int totalBill, int moneyDiscount, int totalPay){
        this.idBill=idBill;
        this.idEmployee=idEmployee;
        this.idCustomer=idCustomer;
        this.nameCustomer=nameCustomer;
        this.printDate=printDate;
        this.totalBill=totalBill;
        this.moneyDiscount=moneyDiscount;
        this.totalPay=totalPay;
    }

    //Getter & Setter
    public String getidBill(){
        return idBill;
    }
    public void setidBill(String idBill){
        this.idBill=idBill;
    }

    public String getidEmployee(){
        return idEmployee;
    }
    public void setidEmployee(String idEmployee){
        this.idEmployee=idEmployee;
    }

    public String getidCustomer(){
        return idCustomer;
    }
    public void setidCustomer(String idCustomer){
        this.idCustomer=idCustomer;
    }

    public String getnameCustomer(){
        return nameCustomer;
    }
    public void setnameCustomer(String nameCustomer){
        this.nameCustomer=nameCustomer;
    }

    public String getprintDate(){
        return printDate;
    }
    public void setprintDate(String printDate){
        this.printDate=printDate;
    }

    public int gettotalBill(){
        return totalBill;
    }
    public void settotalBill(int totalBill){
        this.totalBill=totalBill;
    }

    public int getmoneyDiscount(){
        return moneyDiscount;
    }
    public void setmoneyDiscount(int moneyDiscount){
        this.moneyDiscount=moneyDiscount;
    }

    public int gettotalPay(){
        return totalPay;
    }
    public void settotalPay(int totalPay){
        this.totalPay=totalPay;
    }

    //Ham tao ma hoa don
    public String createIdBill(){
        String firtID="HD";
        return firtID+"-"+(int)(Math.random()*10000000);
    }

    //Hàm nhập
    public void input(){
        String idVoucher;
        String idPromotions;
        int count = 0;
        printDate = new Validate().checkStringUser("Nhập ngay in hoa don");
        idBill = createIdBill();
        idEmployee = new Validate().checkStringUser("Nhập mã nhân viên");
        idCustomer = new Validate().checkStringUser("Nhập mã khách hàng");
        nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng");

        //Nhập chi tiết hóa đơn
        System.out.println("Nhập chi tiết hóa đơn.");
        do{
            addDetailBill();
            //Lựa chọn tiếp tục mua thêm hoặc thanh toán
            do{
            System.out.println("1.Mua them.");
            System.out.println("2.Tiep tuc.");
            count = new Validate().checkNumberInput("Nhap lua chon", "So phai >0, vui long nhap lai !");
            new Validate().clearBuffer();
            if(count != 1 && count != 2){
                System.out.println("Nhap sai lua chon !");
               }
            }while(count != 1 && count != 2);
        }while(count == 1);


        //Lựa chọn sử dụng có sử dụng voucher hay không
        do{
            System.out.println("1.Su dung Voucher.");
            System.out.println("2.Thanh toan."); 
            count = new Validate().checkNumberInput("Nhap lua chon", "So phai >0, vui long nhap lai !");
            new Validate().clearBuffer();
            if(count == 1 ){
                do {
                    listPromotionsSale.readData();
                    listPromotionsSale.print();
                    idPromotions = new Validate().checkStringUser("Nhập vào mã CTKM");
                    idVoucher = new Validate().checkStringUser("Nhap ma voucehr");
			        if(listPromotionsSale.transMoneyDiscount(idPromotions,idVoucher) == 0){
				        System.err.println("\nMã khách hàng mà bạn vừa nhập không hợp lệ hoặc không có trong danh sách!!!");
                    }
		        }while(listPromotionsSale.transMoneyDiscount(idPromotions,idVoucher) == 0);
                //Lấy giá trị tiền giảm của Voucher tương ứng
		        moneyDiscount = listPromotionsSale.transMoneyDiscount(idPromotions,idVoucher);
            }
        }while(count != 1 && count != 2);
        
        //Tính tiền cần phải thanh toán
    }

    //Hàm xuất
    public void print(){
        System.out.println("\nNgày in hóa đơn : " + printDate);
        System.out.println("Mã hóa đơn : " + idBill);
        System.out.println("Nhân viên in hóa đơn: " + idEmployee);
        System.out.println("Mã khách hàng : " + idCustomer);
        System.out.println("Tên khách hàng : " + nameCustomer);
        for( int i = 0 ; i < totalDetailBill ; i++ ){
            detailBill[i].print();
        }
        System.out.println("Tổng tiền : " + totalBill);
        System.out.println("Tiền được giảm : " + moneyDiscount);
        System.out.println("Tiền cần thanh toán : " + totalPay);
    }

    //Hàm mua thêm sản phẩm vào hóa đơn
    public void addDetailBill(){
        String idProduct;
        int quantity;
        detailBill = Arrays.copyOf(detailBill, totalDetailBill+1);

        //Nhập mã sản phẩm và kiểm tra với từng mã sản phẩm trong kho
        do{
            listProduct.readData();
            listProduct.showProduct(true);
            System.out.println("Chi tiet thu "+(totalDetailBill+1));
            idProduct = new Validate().checkStringUser("Nhap ma san pham");
			if(listProduct.transPriceProduct(idProduct) == 0)
				System.err.println("\nMã san pham mà bạn vừa nhập không hợp lệ hoặc không có trong danh sách!!!");
        }while(listProduct.transPriceProduct(idProduct) == 0);
            
            //Lấy giá trị giá tiền,tên sản phẩm,số lượng sản phẩm tương ứng
		    int price = listProduct.transPriceProduct(idProduct);
            String nameProduct = listProduct.transNameProduct(idProduct);
            int quantityCheck = listProduct.transQuantityProduct(idProduct);

            //Nhập số lượng sản phẩm cần mua
            do{
                quantity = new Validate().checkNumberInput("Nhập số lượng sản phẩm","Số lượng sản phẩm > 0, vui lòng nhập lại !");
                if(quantity > quantityCheck){
                    System.out.println("Sản phẩm trong kho không đủ !");
                }
            }while (quantity > quantityCheck);

            //Tính tiền từng chi tiết hóa đơn
            int total = price*quantity;
            totalBill+=total;
            totalPay=totalBill-moneyDiscount;
            
            detailBill[totalDetailBill]= new DetailBill(nameProduct,idProduct,price,quantity,total);
            totalDetailBill++;
    }

    //Hàm xóa bớt sản phẩm khỏi hóa đơn
    public void deleteDetailBill(){
        int count=0;
        String idProductUser = new Validate().checkStringUser("Nhập mã sản phẩm cần xóa ");
        for( int i = 0 ; i < totalDetailBill ; i++ ){
            if(idProductUser.equals((detailBill[i]).getidProduct())){
                totalBill -= detailBill[i].gettotal();
                totalPay=totalBill-moneyDiscount;
                totalDetailBill--;
                for(int j = i ; j < totalDetailBill ; j++){
                    detailBill[j] = detailBill[j+1];
                }
                count++;
                System.out.println("Đã xóa sản phẩm ra khỏi hóa đơn !");
            }
        }
         if(count==0){
            System.out.println("Không tìm thấy sản phẩm !");
        }
    }

    //Thây đổi số lượng sản phẩm trong hóa đơn
    public void fixQuantityDetailBill(){
        int count=0;
        String idProductUser = new Validate().checkStringUser("Nhap ma san pham can thay doi so luong");
        int quantityUser = new Validate().checkNumberInput("Nhap so luong muon thay doi", "So phai > 0, moi nhap lai !");
        for( int i = 0 ; i < totalDetailBill ; i++ ){
            if(idProductUser.equals((detailBill[i]).getidProduct())){
                totalBill -= detailBill[i].gettotal();
                detailBill[i].setquantity(quantityUser);
                detailBill[i].settotal(quantityUser*(detailBill[i].getprice()));
                totalBill += detailBill[i].gettotal();
                totalPay = totalBill - moneyDiscount;
                System.out.println("Thay doi so luong san pham thanh cong !");
                count++;
            }
        }
        if(count==0){
            System.out.println("Khong tim thay sản phẩm !");
        }
    }

    //Lưu sản phẩm từ File
    public void insertDetailBill(String nameProduct, String idProduct, int quantity, int price, int total) {
        detailBill = Arrays.copyOf(detailBill, totalDetailBill + 1);
        detailBill[totalDetailBill] = new DetailBill(nameProduct,idProduct,quantity,price,total);
        totalDetailBill ++;
    }

    //Ghi hóa đơn vào File
    public String printToFile(){
        String result = "";
        for( DetailBill x : detailBill){
            result += idBill + "|" + printDate + "|" + idEmployee + "|" + idCustomer + "|" + nameCustomer + "|" + x.printToFile() + "|" + totalBill + "|" + moneyDiscount + "|" + totalPay + "\n";
        }
        return result;
    }
}
