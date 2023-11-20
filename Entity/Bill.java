//package DoAnOOP.Entity;

//import DoAnOOP.Manager.Validate;
//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.Arrays;

public class Bill {
    String idBill;
    String idEmployee;
    String idCustomer;
    String nameCustomer;
    String printDate;
    String idVoucher;
    String namePromotions;

    int totalDetailBill;
    DetailBill[] listDetailBill;

    public Bill(){
        this.idBill="";
        this.idEmployee="";
        this.idCustomer="";
        this.nameCustomer="";
        this.printDate="";

    }

    public Bill (String idBill, String idEmployee, String idCustomer, String nameCustomer, float totalBill, String printDate){
        this.idBill=idBill;
        this.idEmployee=idEmployee;
        this.idCustomer=idCustomer;
        this.nameCustomer=nameCustomer;
        this.printDate=printDate;
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

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidvoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public String getnamePromotions(){
        return namePromotions;
    }
    public void setnamePromotions(String namePromotions){
        this.namePromotions=namePromotions;
    }

    public String creatidBill(){
        String firtID="HD";
        return firtID+"-"+(int)(Math.random()*10000000);
    }

     public void input(ListProduct listProduct){
        printDate = new Validate().checkStringUser("\nNhập ngày in hóa đơn");
        idBill = creatidBill();
        idEmployee = new Validate().checkStringUser("Nhập mã nhân viên");
        idCustomer = new Validate().checkStringUser("Nhập mã khách hàng");
        nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng");
        System.out.println("Nhập chi tiết hóa đơn.");
        totalDetailBill = new Validate().checkNumberInput("Số chi tiết hóa đơn", "Số nguyên dương, vui lòng nhập lại");
            listDetailBill = new DetailBill[totalDetailBill];
            for(int i=0; i<totalDetailBill; i++){
                    System.out.println("\nNhập chi tiết sản phẩm thứ "+(i+1));
                    listDetailBill[i]= new DetailBill();
                    listDetailBill[i].input(listProduct);
                }
        String select=new Validate().checkStringUser("Khách hàng có sử dụng voucher không ? (y/n)");
        switch (select) {
            case "y":{
                namePromotions=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi");
                idVoucher=new Validate().checkStringUser("Nhập mã voucher");
            }
                break;
            default:
                break;
        }
    }

    public void print(ListProduct listProduct){
        System.out.println("\nNgày in hóa đơn : "+printDate);
        System.out.println("Mã hóa đơn : "+idBill);
        System.out.println("Nhân viên in hóa đơn: "+idEmployee);
        System.out.println("Mã khách hàng : "+idCustomer);
        System.out.println("Tên khách hàng : "+nameCustomer);
          for(int i=0;i<listDetailBill.length;i++){
            listDetailBill[i].print(listProduct);
        }
        System.out.println("Tổng tiền : "+total(listProduct)+" đồng");
    }

    public void addDetailBill(ListProduct listProduct){
        totalDetailBill = listDetailBill.length;
        listDetailBill = Arrays.copyOf(listDetailBill,totalDetailBill+1);
            listDetailBill[totalDetailBill] = new DetailBill();
            listDetailBill[totalDetailBill].input(listProduct);
            totalDetailBill++;
    }

    public void deleteDetailBill(){
        String idProductUser = new Validate().checkStringUser("Nhập mã sản phẩm cần xóa ");
        for(int i = 0 ; i < totalDetailBill; i++){
            if((listDetailBill[i].getidProduct()).equals(idProductUser)){
                totalDetailBill--;
                for(int j = i ; j < totalDetailBill ; j++){
                    listDetailBill[j]=listDetailBill[j+1];
                }
            }
        }
    }

    public int total(ListProduct listProduct){
        int total=0;
        for(int i = 0 ; i < listDetailBill.length ; i++){
            total += (listDetailBill[i].total(listProduct));
        }
        return total;
    }  
    public int totalMoney(ListPromotionsSale listPromotionsSale, ListProduct listProduct) {
        int moneyOff=0;
        int totalBill=0;
        if (namePromotions != null && !namePromotions.isEmpty()) {
            Voucher matchedVoucher = listPromotionsSale.getVoucherByPromotions(namePromotions,idVoucher);
                moneyOff = matchedVoucher.getmoneyDiscount();
            }
                System.out.println("Tiền được giảm : "+moneyOff+" đồng");
                totalBill=total(listProduct)-moneyOff;
        return totalBill;
    }
}
