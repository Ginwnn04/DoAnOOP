//package DoAnOOP.Manager;
//
//import DoAnOOP.Manager.Validate;
//import DoAnOOP.Entity.Bill;
//
//import java.io.DataOutputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Arrays;
//
//public class ListBill {
//    private int totalBill;
//    private Bill bill[]=new Bill[1];
//
//    public ListBill(){
//
//    }
//    public ListBill(int totalBill, ListBill ds2[]){
//        this.totalBill=totalBill;
//
//    }
//
//    public void addBill(){
//        bill = Arrays.copyOf(bill, totalBill+1);
//        bill[totalBill]=new Bill();
//        bill[totalBill].input();
//        totalBill++;
//    }
//
//    public void printBill(ListVoucher listVoucher, ListProduct listProduct){
//        bill[totalBill-1].print(listProduct);
//        System.out.println("Tiền cần thanh toán : " + bill[totalBill-1].totalMoney(listVoucher,listProduct));
//        }
//
//    public void printListBill(ListVoucher listVoucher, ListProduct listProduct){
//        System.out.println("--------DANH SÁCH HÓA ĐƠN--------");
//        for(int i=0;i<totalBill;i++){
//            System.out.println("\nHóa đơn thứ "+(i+1));
//            bill[i].print(listProduct);
//            System.out.println("Tiền cần thanh toán : " + bill[totalBill-1].totalMoney(listVoucher,listProduct));
//        }
//    }
//
//
//    public void searchBill(ListProduct listProduct){
//        System.out.println("1.Tìm kiếm hóa đơn theo mã hóa đơn.");
//        System.out.println("2.Tìm kiếm hóa đơn theo mã nhân viên.");
//        System.out.println("3.Tìm kiếm hóa đơn theo tên khách hàng và ngày in");
//        System.out.println("4.Tìm kiếm hóa đơn của khách hàng tên A hoặc tên B");
//        int select =new Validate().checkIntUser("Mời nhập lựa chọn");
//        switch (select) {
//            case 1:
//                String idBillUser =new Validate().checkStringUser("Nhập mã hóa đơn");
//                for(int i=0;i<totalBill;i++){
//                if((bill[i].getidBill()).equals(idBillUser)){
//                bill[i].print(listProduct);
//                }
//            }break;
//            case 2:
//                String idEmployeeUser =new Validate().checkStringUser("Nhập mã nhân viên");
//                for(int i=0;i<totalBill;i++){
//                if((bill[i].getidEmployee()).equals(idEmployeeUser)){
//                bill[i].print(listProduct);
//                }
//            }break;
//            case 3:
//                String idCustomerUser =new Validate().checkStringUser("Nhập tên khách hàng");
//                String printDateUser =new Validate().checkStringUser("Nhập ngày in hóa đơn");
//                for(int i=0;i<totalBill;i++){
//                if(((bill[i].getidCustomer()).equals(idCustomerUser))&&((bill[i].getprintDate()).equals(printDateUser))){
//                bill[i].print(listProduct);
//                }
//            }break;
//
//            case 4:
//                String nameCustomerUser1 =new Validate().checkStringUser("Nhập tên khách hàng thứ nhất");
//                String nameCustomerUser2 =new Validate().checkStringUser("Nhập tên khách hàng thứ hai");
//                for(int i=0;i<totalBill;i++){
//                if(((bill[i].getidCustomer()).equals(nameCustomerUser2))||((bill[i].getprintDate()).equals(nameCustomerUser1))){
//                bill[i].print(listProduct);
//                }
//            }break;
//
//            default:
//                break;
//        }
//    }
//
//    public void addProduct(){
//        bill[totalBill-1].addDetailBill();
//    }
//
//    public void deleteProduct(){
//        bill[totalBill-1].deleteDetailBill();
//    }
//
//    /*public void statistics(){
//            System.out.println("1.Thống kê hóa đơn theo ngày.");
//            System.out.println("2.Thống kê hóa đơn theo tháng");
//            System.out.println("3.Thống kê hóa đơn theo năm");
//            System.out.println("4.Thống kê hóa đơn theo giá tiền");
//            int chon =new Validate().checkIntUser("Nh");;
//            switch(chon){
//                case 1: {
//                String printDateUser =new  Validate().checkStringUser("\nNhập ngày");
//                System.out.println("\n---------HÓA ĐƠN IN NGÀY "+printDateUser+"--------");
//                for(int i=0;i<n;i++){
//                    if((bill[i].getprintDate()).equals(printDateUser)){
//                        bill[i].print();
//                    }
//                }
//                }break;
//                case 4:{
//                System.out.println("1.Hóa đơn dưới 100.000 đồng.");
//                System.out.println("2.Hóa đơn từ 100.000 đồng đến 500.000 đồng");
//                System.out.println("3.Hóa đơn trên 500.000 đồng");
//                int lc =new Validate().checkIntUser("Nhập lựa chọn");
//                switch(lc){
//                    case 1:{
//                         System.out.println("\n---------HÓA ĐƠN DƯỚI 100.000 ĐÒNG--------");
//                         for(int i=0;i<n;i++){
//                        if(dshd[i].total()<100000){
//                           dshd[i].xuat();
//                            }
//                        }
//                    }break;
//                    case 2:{
//                         System.out.println("\n--------HÓA ĐƠN TỪ 100.000 DẾN 500.000 ĐỒNG--------");
//                         for(int i=0;i<n;i++){
//                        if((dshd[i].total()>100000)&&(dshd[i].total()<500000)){
//                           dshd[i].xuat();
//                            }
//                        }
//                    }break;
//                    case 3:{
//                         System.out.println("\n---------HÓA ĐƠN TRÊN 500.000 ĐỒNG--------");
//                         for(int i=0;i<n;i++){
//                        if(dshd[i].total()>500000){
//                           dshd[i].xuat();
//                            }
//                        }
//                    }break;
//                }
//            }
//        }
//    }
//
//    public void writeFile() throws IOException{
//        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("Bill.txt"));
//        for( int i = 0 ; i < totalBill ; i++){
//            bill[i].writeFile();
//        }
//        outStream.close();
//    }*/
//
//}
