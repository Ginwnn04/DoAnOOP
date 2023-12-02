//package DoAnOOP.Manager;
//import DoAnOOP.Manager.Validate;
//import DoAnOOP.Entity.Bill;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ListBill implements ServiceFile {
    private int totalBill;
    private Bill[] bill;

    //Constructor
    public ListBill(){
        bill = new Bill[totalBill];
    }

    public ListBill( ListBill x){
        this.bill = x.bill;
        this.totalBill=x.totalBill;
    }
    
    //Hàm tạo hóa đơn mới
    public void addBill(){
        bill = Arrays.copyOf(bill, totalBill+1);
        bill[totalBill]=new Bill();
        bill[totalBill].input();
        totalBill++;
    }

    //Hàm xuất hóa đơn hiện tại
    public void printBill(){
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
        bill[totalBill-1].print();
        }
    }

    //Hàm xuất lịch sử hóa đơn
    public void printListBill(){
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            System.out.println("--------DANH SÁCH HÓA ĐƠN--------");
            for(int i=0;i<totalBill;i++){
                System.out.println("\nHóa đơn thứ "+(i+1));
                bill[i].print();
            }
        }
    }

    //Hàm tìm kiếm hóa đơn bằng mã hóa đơn
    public void findBillByIdBill(){
        int count = 0 ;
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            String idBillUser = new Validate().checkStringUser("Nhập mã hóa đơn cần tìm");
            for( int i = 0 ; i < totalBill ; i++ ){
                if((bill[i].getidBill()).equals(idBillUser)){
                    bill[i].print();
                    count++;
                }
            }
            if(count == 0 ){
                System.out.println("Không tìm thấy hóa đơn !");
            }
        }
    }

    //Hàm tìm kiếm hóa đơn bằng mã nhân viên 
    public void findBillByIdEmployee(){
        int count = 0;
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            String idEmployeeUser = new Validate().checkStringUser("Nhập mã nhân viên");
            for( int i = 0 ; i < totalBill ; i++ ){
                if((bill[i].getidEmployee()).equals(idEmployeeUser)){
                    bill[i].print();
                    count++;
                }
            }
            if(count == 0 ){
                System.out.println("Không tìm thấy hóa đơn !");
            }
        }
    }

    //Hàm tìm kiếm hóa đơn bằng ngày xuất
    public void findBillByDay(){
        int count = 0;
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            String printDateUser;
            do {
			    printDateUser = new Validate().checkStringUser("Nhập ngày xuất hóa đơn (dd-MM-yyyy)");
			
    			if(!new Validate().CheckDate(printDateUser)) {
	    			System.err.println("Ngày tháng năm không hợp lê. Xin mời nhập lại!!!");
		    		System.err.println();
			    }		
    		}while(!new Validate().CheckDate(printDateUser));
    
            for( int i = 0 ; i < totalBill ; i++ ){
                if((bill[i].getprintDate()).equals(printDateUser)){
                    bill[i].print();
                    count++;
                }
            }
            if(count == 0 ){
                System.out.println("Không tìm thấy hóa đơn !");
            }
        }
    }

    public void findBillByMonth(){
        int count = 0;
        String printDateUser;
        do {
			printDateUser = new Validate().checkStringUser("Nhập thang xuất hóa đơn (MM-yyyy)");
			
			if(!new Validate().CheckDateMonth(printDateUser)) {
				System.err.println("Ngày tháng năm không hợp lê. Xin mời nhập lại!!!");
				System.err.println();
			}		
		}while(!new Validate().CheckDateMonth(printDateUser));
        
        for( int i = 0 ; i < totalBill ; i++ ){
            //if((bill[i].Month()).equals(printDateUser)){
                bill[i].print();
                count++;
            }
        
        if(count == 0 ){
            System.out.println("Không tìm thấy hóa đơn !");
        }
    }

    //Hàm tìm kiếm hóa đơn bằng tên khách hàng
    public void findBillByName(){
        int count = 0;
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            String nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng ");
            for( int i = 0 ; i < totalBill ; i++ ){
                if((bill[i].getnameCustomer()).equals(nameCustomer)){
                    bill[i].print();
                    count++;
                }
            }
            if(count == 0 ){
                System.out.println("Không tìm thấy hóa đơn !");
            }
        }
    }
  
    //Hàm thêm sản phẩm vào hóa đơn
    public void addProduct(){
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            bill[totalBill-1].addDetailBill();
        }
    }

    //Hàm xóa bớt sản phảm khỏi hóa đơn
    public void deleteProduct(){
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            bill[totalBill-1].deleteDetailBill();
        }
    }

    //Hàm thây đỏi số lượng sản phẩm 
    public void fixQuantityProduct(){
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
            bill[totalBill-1].fixQuantityDetailBill();
        }
    }

    @Override
    public void resetData() {
        totalBill = 0;
        bill = new Bill[totalBill];
    }

    @Override
    public void writeData(boolean flag) {
        if(totalBill==0){
            System.out.println("Chưa có dữ liệu !");
        }
        else{
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
