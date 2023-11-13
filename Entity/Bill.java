//package DoAnOOP.Entity;
//
//import DoAnOOP.Manager.Validate;
//
//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Arrays;
//
//public class Bill {
//    String idBill;
//    String idEmployee;
//    String idCustomer;
//    String nameCustomer;
//    String printDate;
//    String idVoucher;
//
//    int totalDetailBill;
//    DetailBill[] detailBill;
//
//    public Bill(){
//        this.idBill="";
//        this.idEmployee="";
//        this.idCustomer="";
//        this.nameCustomer="";
//        this.printDate="";
//
//    }
//
//    public Bill (String idBill, String idEmployee, String idCustomer, String nameCustomer, float totalBill, String printDate){
//        this.idBill=idBill;
//        this.idEmployee=idEmployee;
//        this.idCustomer=idCustomer;
//        this.nameCustomer=nameCustomer;
//        this.printDate=printDate;
//
//    }
//
//    public String getidBill(){
//        return idBill;
//    }
//    public void setidBill(String idBill){
//        this.idBill=idBill;
//    }
//
//    public String getidEmployee(){
//        return idEmployee;
//    }
//    public void setidEmployee(String idEmployee){
//        this.idEmployee=idEmployee;
//    }
//
//    public String getidCustomer(){
//        return idCustomer;
//    }
//    public void setidCustomer(String idCustomer){
//        this.idCustomer=idCustomer;
//    }
//
//    public String getnameCustomer(){
//        return nameCustomer;
//    }
//    public void setnameCustomer(String nameCustomer){
//        this.nameCustomer=nameCustomer;
//    }
//
//    public String getprintDate(){
//        return idBill;
//    }
//    public void setprintDate(String printDate){
//        this.printDate=printDate;
//    }
//
//
//    public String taoidBill(){
//        String firtID="HD";
//        return firtID+"-"+(int)(Math.random()*10000000);
//    }
//
//     public void input(){
//        printDate = new Validate().checkStringUser("\nNhập ngày in hóa đơn");
//        idBill = taoidBill();
//        idEmployee = new Validate().checkStringUser("Nhập mã nhân viên");
//        idCustomer = new Validate().checkStringUser("Nhập mã khách hàng");
//        nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng");
//        System.out.println("Nhap chi tiet hoa don.");
//        totalDetailBill = new Validate().checkNumberInput("Số chi tiết hóa đơn", "Số nguyên dương, vui lòng nhập lại");
//            detailBill = new DetailBill[totalDetailBill];
//            for(int i=0; i<totalDetailBill; i++){
//                    System.out.println("\nNhập chi tiết sản phẩm thứ "+(i+1));
//                    detailBill[i]= new DetailBill();
//                    detailBill[i].input();
//                }
//        String select=new Validate().checkStringUser("Khách hàng có sử dụng voucher không ? (y/n)");
//        switch (select) {
//            case "y":{
//                idVoucher=new Validate().checkStringUser("Nhập mã voucher");
//            }
//                break;
//            default:
//                break;
//        }
//    }
//
//    public void print(ListProduct listProduct){
//        System.out.println("\nNgày in hóa đơn : "+printDate);
//        System.out.println("Mã hóa đơn : "+idBill);
//        System.out.println("Nhân viên in hóa đơn: "+idEmployee);
//        System.out.println("Mã khách hàng : "+idCustomer);
//        System.out.println("Tên khách hàng : "+nameCustomer);
//        for(int i=0;i<detailBill.length;i++){
//            detailBill[i].print(listProduct);
//        }
//        System.out.println("Tổng tiền : "+total(listProduct));
//    }
//
//    public void addDetailBill(){
//        totalDetailBill = detailBill.length;
//        detailBill = Arrays.copyOf(detailBill,totalDetailBill+1);
//            detailBill[totalDetailBill] = new DetailBill();
//            detailBill[totalDetailBill].input();
//            totalDetailBill++;
//    }
//
//    public void deleteDetailBill(){
//        String idProductUser = new Validate().checkStringUser("Nhập mã sản phẩm cần xóa ");
//        for(int i = 0 ; i < totalDetailBill; i++){
//            if((detailBill[i].getidProduct()).equals(idProductUser)){
//                totalDetailBill--;
//                for(int j = i ; j < totalDetailBill ; j++){
//                    detailBill[j]=detailBill[j+1];
//                }
//            }
//        }
//    }
//
//    public float total(ListProduct listProduct){
//        float total=0;
//        for(int i = 0 ; i < detailBill.length ; i++){
//            total += (detailBill[i].total(listProduct));
//        }
//        return total;
//    }
//
//    public float totalMoney(ListVoucher listVoucher, ListProduct listProduct) {
//        float moneyOff=0;
//        float totalBill=0;
//        if (idVoucher != null && !idVoucher.isEmpty()) {
//            Voucher matchedVoucher = listVoucher.getVoucherByCode(idVoucher);
//            if (matchedVoucher != null) {
//                moneyOff = matchedVoucher.getmoneyDiscount();
//                totalBill=total(listProduct)-moneyOff;
//            }
//        }
//        System.out.println("Tien giam : "+moneyOff);
//        return totalBill;
//    }
//}
