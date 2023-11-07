package MyOOP.Manager;

import java.util.Arrays;
import MyOOP.Entity.Bill;
import MyOOP.Entity.PromotionsSale;
public class ListBill {
    int n;
    Bill dshd[]= new Bill[1];
    Voucher dsvc[]= new Voucher[1];
    PromotionsSale dskm[]= new PromotionsSale[1];

    public ListBill(){}
    public ListBill(int n, ListBill ds2[]){
        this.n=n;
    }

    public void nhap(){
        n=1;
        dshd=new Bill[1];
        for(int i=0;i<n;i++){
        System.out.println("\n\nNhập hóa đơn thứ "+(i+1));
        dshd[i]= new Bill();
        dshd[i].nhap();
        }
    }

    public void in(){
        dshd[n-1].xuat();
        dshd[n-1].moneyOff();
        }

    public void xuat(){
        System.out.println("--------DANH SÁCH HÓA ĐƠN--------");
        for(int i=0;i<n;i++){
            System.out.println("\nHóa đơn thứ "+(i+1));
            dshd[i].xuat();
        }
    }

    

    public void timkiem(){
        System.out.println("1.Tìm kiếm theo mã hóa đơn.");
        System.out.println("2.Tìm kiếm theo mã nhân viên.");
        System.out.println("3.Tìm kiếm theo mã khách hàng");
        int chon =new Validate().checkIntUser("Mời nhập lựa chọn");
        switch (chon) {
            case 1:
                String b =new Validate().checkStringUser("Nhập mã hóa đơn");
                for(int i=0;i<n;i++){
                if((dshd[i].getidBill()).equals(b)){
                dshd[i].xuat();
                }
            }break;
            case 2:
                String c =new Validate().checkStringUser("Nhập mã nhân viên");
                for(int i=0;i<n;i++){
                if((dshd[i].getidEmployee()).equals(c)){
                dshd[i].xuat();
                }
            }break;
            case 3:
                String d =new Validate().checkStringUser("Nhập mã khách hàng");
                for(int i=0;i<n;i++){
                if((dshd[i].getidCustomer()).equals(d)){
                dshd[i].xuat();
                }
            }break;
        
            default:
                break;
        }
    }

    public void them(){
        dshd = Arrays.copyOf(dshd, n+1);
        dshd[n]=new Bill();
        dshd[n].nhap();
        n++;
    }

    public void muathem(){
        dshd[n-1].themchitiet();
    }

    public void xoabot(){
        dshd[n-1].xoachitiet();
    }

    public void thongke(){
            System.out.println("1.Thống kê hóa đơn theo ngày.");
            System.out.println("2.Thống kê hóa đơn theo tháng");
            System.out.println("3.Thống kê hóa đơn theo năm");
            System.out.println("4.Thống kê hóa đơn theo giá tiền");
            int chon =new Validate().checkIntUser("Nh");;
            switch(chon){
                case 1: {
                String a =new  Validate().checkStringUser("\nNhập ngày");
                System.out.println("\n---------HÓA ĐƠN IN NGÀY "+a+"--------");
                for(int i=0;i<n;i++){
                    if((dshd[i].getprintDate()).equals(a)){
                        dshd[i].xuat();
                    }
                }
                }break;
                case 4:{
                System.out.println("1.Hóa đơn dưới 100.000 đồng.");
                System.out.println("2.Hóa đơn từ 100.000 đồng đến 500.000 đồng");
                System.out.println("3.Hóa đơn trên 500.000 đồng");
                int lc =new Validate().checkIntUser("Nhập lựa chọn");
                switch(lc){
                    case 1:{
                         System.out.println("\n---------HÓA ĐƠN DƯỚI 100.000 ĐÒNG--------");
                         for(int i=0;i<n;i++){
                        if(dshd[i].total()<100000){
                           dshd[i].xuat();
                            }
                        }
                    }break;
                    case 2:{
                         System.out.println("\n--------HÓA ĐƠN TỪ 100.000 DẾN 500.000 ĐỒNG--------");
                         for(int i=0;i<n;i++){
                        if((dshd[i].total()>100000)&&(dshd[i].total()<500000)){
                           dshd[i].xuat();
                            }
                        }
                    }break;
                    case 3:{
                         System.out.println("\n---------HÓA ĐƠN TRÊN 500.000 ĐỒNG--------");
                         for(int i=0;i<n;i++){
                        if(dshd[i].total()>500000){
                           dshd[i].xuat();
                            }
                        }
                    }break;
                }
            }
        }
    }

}
