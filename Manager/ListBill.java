package DoAnOOP.Manager;
import DoAnOOP.Manager.Validate;
import DoAnOOP.Entity.Bill;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ListBill implements ServiceFile {
    private int totalBill;
    private Bill[] bill;

    public ListBill(){
        bill = new Bill[totalBill];
    }
    public ListBill( ListBill ){
        this.bill = x.bill;
        this.totalBill=totalBill;
    }

    public ListBill(String idBill, String printDate, String idEmployee, String idCustomer, String nameCustomer, int totalBill, int moneyDiscount, int totalPay) {
    }

    public void addBill(){
        bill = Arrays.copyOf(bill, totalBill+1);
        bill[totalBill]=new Bill();
        bill[totalBill].input();
        totalBill++;
    }

    public void printBill(){
        if(totalBill==0){
            System.out.println("Chua nhap du lieu vao hoa don !");
        }
        else{
        bill[totalBill-1].print();
        }
    }

    public void printListBill(){
        System.out.println("--------DANH SÁCH HÓA ĐƠN--------");
        for(int i=0;i<totalBill;i++){
            System.out.println("\nHóa đơn thứ "+(i+1));
            bill[i].print();
        }
    }

    public void findBill(){
        int count = 0;
        int choice;
        System.out.println("1.Tìm kiếm hóa đơn theo mã hóa đơn.");
        System.out.println("2.Tìm kiếm hóa đơn theo mã nhân viên.");
        System.out.println("3.Tìm kiếm hóa đơn theo ngày và mã nhân viên.");
        System.out.println("4.Tìm kiếm hóa đơn của khách hàng tên A hoặc tên B.");
        choice = new Validate().checkNumberInput("Moi nhap lua chon", "Lựa chọn không đúng !");
        switch (choice) {
            case 1:{
                String idBillUser = new Validate().checkStringUser("Nhập mã hóa đơn cần tìm");
                for( int i = 0 ; i < totalBill ; i++ ){
                    if((bill[i].idBill).equals(idBillUser)){
                        bill[i].print();
                        count++;
                    }
                }
                if(count == 0 ){
                    System.out.println("Không tìm thấy hóa đơn !");
                }
            }break;
            case 2:{
                String idEmployeeUser = new Validate().checkStringUser("Nhập mã nhân viên");
                for( int i = 0 ; i < totalBill ; i++ ){
                    if((bill[i].idEmployee).equals(idEmployeeUser)){
                        bill[i].print();
                        count++;
                    }
                }
                if(count == 0 ){
                    System.out.println("Không tìm thấy hóa đơn !");
                }
            }break;
            case 3:{
                String idEmployeeUser = new Validate().checkStringUser("Nhập mã nhân viên");
                String printDateUser = new Validate().checkStringUser("Nhập ngày xuất hóa đơn");
                for( int i = 0 ; i < totalBill ; i++ ){
                    if((bill[i].printDate).equals(printDateUser) && (bill[i].idEmployee).equals(idEmployeeUser)){
                        bill[i].print();
                        count++;
                    }
                }
                if(count == 0 ){
                    System.out.println("Không tìm thấy hóa đơn !");
                }
            }break;
            case 4:{
                String nameCustomer1 = new Validate().checkStringUser("Nhập tên khách hàng thứ nhất");
                String nameCustomer2 = new Validate().checkStringUser("Nhập tên khách hàng thứ hai");
                for( int i = 0 ; i < totalBill ; i++ ){
                    if((bill[i].nameCustomer).equals(nameCustomer1) || (bill[i].nameCustomer).equals(nameCustomer2)){
                        bill[i].print();
                        count++;
                    }
                }
                if(count == 0 ){
                    System.out.println("Không tìm thấy hóa đơn !");
                }
            }break;
            default:
                break;
        }
    }
  
    public void addProduct(){
        bill[totalBill-1].addDetailBill();
    }

    public void deleteProduct(){
        bill[totalBill-1].deleteDetailBill();
    }

    public void fixBill(){
        System.out.println("1.Them san pham.");
        System.out.println("2.Xoa bot san pham.");
        System.out.println("3.Thay doi so luong san pham");
        int choice = new Validate().checkNumberInput("Nhap lua chon", "Lua chon khong dung !");
        switch (choice) {
            case 1:{
                bill[totalBill-1].addDetailBill();
            }break;
            case 2:{
                bill[totalBill-1].deleteDetailBill();
            }break;
            case 3:{
                bill[totalBill-1].fixDetailBill();
            }break;
            default:
                break;
        }
    }

    @Override
    public void resetData() {
        totalBill = 0;
        bill = new Bill[totalBill];
    }

    @Override
    public void writeData(boolean flag) {
        try {
            FileWriter fileWriter = new FileWriter("HoaDon.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for( Bill x : bill){
                bufferedWriter.write(x.printToFile());
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
        }
        resetData();
        System.out.println("Luu file thanh cong !");
    }

    @Override
    public void readData() {
        try {
            FileReader fileReader = new FileReader("HoaDon.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean check = true;
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] split = line.split("\\|");
                String idBillFile = split[0];
                String printDateFile = split[1];
                String idEmployeeFile = split[2];
                String idCustomerFile = split[3];
                String nameCustomerFile = split[4]; 
                String nameProductFile = split[5];
                String idProductFile = split[6];
                int quantityFile = Integer.parseInt(split[7]);
                int priceFile = Integer.parseInt(split[8]);
                int totalFile = Integer.parseInt(split[9]);
                int totalBillFile = Integer.parseInt(split[10]);
                int moneyDiscountFile = Integer.parseInt(split[11]);
                int totalPayFile = Integer.parseInt(split[12]);
                if (check) {
                    bill = Arrays.copyOf(bill, totalBill + 1);
                    bill[totalBill] = new Bill(idBillFile,printDateFile,idEmployeeFile,idCustomerFile,nameCustomerFile,totalBillFile,moneyDiscountFile,totalPayFile);
                    bill[totalBill].insertDetailBill(nameProductFile, idProductFile, quantityFile, priceFile, totalFile);
                    totalBill++;
                    check = false;
                }
                else{  
                    if (idBillFile.equals(bill[totalBill-1].getidBill())) {
                        bill[totalBill-1].insertDetailBill(nameProductFile, idProductFile, quantityFile, priceFile, totalFile);
                    }
                    else {
                        bill = Arrays.copyOf(bill, totalBill + 1);
                        bill[totalBill] = new Bill(idBillFile,printDateFile,idEmployeeFile,idCustomerFile,nameCustomerFile,totalBillFile,moneyDiscountFile,totalPayFile);
                        bill[totalBill].insertDetailBill(nameProductFile, idProductFile, quantityFile, priceFile, totalFile);
                        totalBill++;
                    }
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
    
        }
    }

}
