package DoAnOOP.Entity;
import DoAnOOP.Manager.Validate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Bill {
    String idBill;
    String idEmployee;
    String idCustomer;
    String nameCustomer;
    String printDate;
    String idVoucher;
    String idPromotions;
    int totalBill;
    int moneyDiscount;
    int totalPay;

    int totalDetailBill = 0;
    DetailBill[] detailBill = new DetailBill[totalDetailBill];

    public Bill(){
        this.idBill="";
        this.idEmployee="";
        this.idCustomer="";
        this.nameCustomer="";
        this.printDate="";
        this.totalBill=0;
        this.moneyDiscount=0;
        this.totalPay=0;

    }

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
        return idBill;
    }
    public void setprintDate(String printDate){
        this.printDate=printDate;
    }

    public String getidPromotions(){
        return idPromotions;
    }
    public void setidPromotions(String idPromotions){
        this.idPromotions=idPromotions;
    }

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidVoucher(String idVoucher){
        this.idVoucher=idVoucher;
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

    public String createIdBill(){
        String firtID="HD";
        return firtID+"-"+(int)(Math.random()*10000000);
    }

    public void input(){
        printDate = new Validate().checkStringUser("\nNhập ngày in hóa đơn");
        idBill = creatIdBill();
        idEmployee = new Validate().checkStringUser("Nhập mã nhân viên");
        idCustomer = new Validate().checkStringUser("Nhập mã khách hàng");
        nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng");
        
        System.out.println("Nhập chi tiết hóa đơn.");
        totalDetailBill = new Validate().checkNumberInput("Số chi tiết hóa đơn", "Số nguyên dương, vui lòng nhập lại");
            detailBill = new DetailBill[totalDetailBill];
            for(int i = 0 ; i < totalDetailBill ; i++ ){
                    System.out.println("\nNhập chi tiết sản phẩm thứ " + (i+1));
                    detailBill[i]= new DetailBill();
                    detailBill[i].input();
                }

        for(int i = 0 ; i <totalDetailBill; i++){
            totalBill += (detailBill[i].total);
        }

        int choice=new Validate().checkNumberInput("Khách hàng có sử dụng voucher không ? (1.Có/2.Không)","Lựa chọn không hợp lệ !");
        switch (choice) {
            case 1:{
                idPromotions=new Validate().checkStringUser("Nhập mã Chương Trình Khuyến Mãi.");
                readData();
            }break;
            default:
                break;
        }
        totalPay=totalBill-moneyDiscount;
    }

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

    public void addDetailBill(){
        int quantityDetailBill = new Validate().checkNumberInput("So chi tiet san pham muon them", "So phia > 0, vui long nhap lai !");
        for(int i = 0 ; i < quantityDetailBill ; i++) {
        System.out.println("Chi tiet thu "+(i+1));
        detailBill = Arrays.copyOf(detailBill, totalDetailBill+1);
            detailBill[totalDetailBill] = new DetailBill();
            detailBill[totalDetailBill].input();
            totalBill += detailBill[totalDetailBill].gettotal();
            totalPay=totalBill-moneyDiscount;
            totalDetailBill++;
        }
        System.out.println("\nThêm sản phẩm vào thành công !");
    }

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

    public void fixDetailBill(){
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

    public void insertDetailBill(String nameProduct, String idProduct, int quantity, int price, int total) {
        detailBill = Arrays.copyOf(detailBill, totalDetailBill + 1);
        detailBill[totalDetailBill] = new DetailBill(nameProduct,idProduct,quantity,price,total);
        totalDetailBill ++;
    }

    public String printToFile(){
        String result = "";
        for( DetailBill x : detailBill){
            result += idBill + "|" + printDate + "|" + idEmployee + "|" + idCustomer + "|" + nameCustomer + "|" + x.printToFile() + "|" + totalBill + "|" + moneyDiscount + "|" + totalPay + "\n";
        }
        return result;
    }

    public void readData(){
        try {
            FileReader fileReader = new FileReader("Voucher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\|");
                String idPromotionsFile = split[1];
                String idVoucherFile = split[4];
                int moneyDiscountFile = Integer.parseInt(split[5]);
                if(idPromotionsFile.equals(idPromotions)){
                    idVoucher = new Validate().checkStringUser("Nhập mã Voucher");
                    if(idVoucherFile.equals(idVoucher)){
                        moneyDiscount = moneyDiscountFile;
                    }
                }
            } 
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
