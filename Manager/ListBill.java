package DoAnOOP.Manager;

import DoAnOOP.Manager.Validate;
import DoAnOOP.Entity.Bill;

import java.util.Arrays;

public class ListBill {
    private int totalBill;
    private Bill bill[]=new Bill[1];

    public ListBill(){

    }
    public ListBill(int totalBill, ListBill ds2[]){
        this.totalBill=totalBill;

    }

    public void addBill(ListProduct listProduct){
        bill = Arrays.copyOf(bill, totalBill+1);
        bill[totalBill]=new Bill();
        bill[totalBill].input(listProduct);
        totalBill++;
        System.out.println("Thêm hóa đơn thành công !");
    }

    public void printBill(ListPromotionsSale listPromotionsSale,ListProduct listProduct){
        bill[totalBill-1].print(listProduct);
        System.out.println("Tiền cần thanh toán : " + bill[totalBill-1].totalMoney(listPromotionsSale,listProduct)+" đồng");
        }

    public void printListBill(ListPromotionsSale listPromotionsSale, ListProduct listProduct){
        System.out.println("--------DANH SÁCH HÓA ĐƠN--------");
        for(int i=0;i<totalBill;i++){
            System.out.println("\nHóa đơn thứ "+(i+1));
            bill[i].print(listProduct);
            System.out.println("Tiền cần thanh toán : " + bill[i].totalMoney(listPromotionsSale,listProduct)+" đồng");
        }
    }


    public void searchBill(ListProduct listProduct){
        System.out.println("1.Tìm kiếm hóa đơn theo mã hóa đơn.");
        System.out.println("2.Tìm kiếm hóa đơn theo mã nhân viên.");
        System.out.println("3.Tìm kiếm hóa đơn theo ma khách hàng và ngày in");
        System.out.println("4.Tìm kiếm hóa đơn của khách hàng tên A hoặc tên B");
        int select =new Validate().checkIntUser("Mời nhập lựa chọn");
        switch (select) {
            case 1:
                String idBillUser =new Validate().checkStringUser("Nhập mã hóa đơn");
                for(int i=0;i<totalBill;i++){
                if((bill[i].getidBill()).equals(idBillUser)){
                bill[i].print(listProduct);
                }
            }break;
            case 2:
                String idEmployeeUser =new Validate().checkStringUser("Nhập mã nhân viên");
                System.out.println("-----------------Hóa đơn in bởi nhân viên có mã "+idEmployeeUser+"--------------");
                for(int i=0;i<totalBill;i++){
                if((bill[i].getidEmployee()).equals(idEmployeeUser)){
                bill[i].print(listProduct);
                }
            }break;
            case 3:
                String nameCustomerUser =new Validate().checkStringUser("Nhập ten khách hàng");
                String printDateUser =new Validate().checkStringUser("Nhập ngày in hóa đơn");
                System.out.println("-----------Hóa đơn xuất vào ngày "+printDateUser+" của khách hang tên "+nameCustomerUser+"-----------");
                for(int i=0;i<totalBill;i++){
                if(((bill[i].getnameCustomer()).equals(nameCustomerUser))&&((bill[i].getprintDate()).equals(printDateUser))){
                bill[i].print(listProduct);
                }
            }break;

            case 4:
                String nameCustomerUser1 =new Validate().checkStringUser("Nhập tên khách hàng thứ nhất");
                String nameCustomerUser2 =new Validate().checkStringUser("Nhập tên khách hàng thứ hai");
                System.out.println("--------------Hoá đơn của những khách hàng tên "+nameCustomerUser1+" và "+nameCustomerUser2+"-----------------");
                for(int i=0;i<totalBill;i++){
                if(((bill[i].getidCustomer()).equals(nameCustomerUser2))||((bill[i].getprintDate()).equals(nameCustomerUser1))){
                bill[i].print(listProduct);
                }
            }break;

            default:
                break;
        }
    }

    public void addProduct(ListProduct listProduct){
        bill[totalBill-1].addDetailBill(listProduct);
    }

    public void deleteProduct(){
        bill[totalBill-1].deleteDetailBill();
    }
}
