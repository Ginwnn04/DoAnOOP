package DoAnOOP.Entity;
import java.util.Arrays;
import java.util.Scanner;

public class Promotions {
    public static Scanner in= new Scanner(System.in);
    String namePromotion;
    String startDate;
    String endDate;

    int n;
    int chon;
    Voucher dsvc[]= new Voucher[n];
    Bill dshd[]= new Bill[n];  
    
    public String getnamePromotion(){
        return namePromotion;
    }
    public void setnamePromotion(String namePromotion){
        this.namePromotion=namePromotion;
    }

    public String getstartDate(){
        return startDate;
    }
    public void setstartDate(String startDate){
        this.startDate=startDate;
    }

    public String getendDate(){
        return endDate;
    }
    public void setendDate(String endDate){
        this.endDate=endDate;
    }

    public Promotions(){}
    public Promotions(int n, Promotions ds2[]){
        this.n=n;
    }

    public void nhap(){
        System.out.print("\nNhap ten chuong trinh khuyen mai : ");
        namePromotion=in.nextLine();
        System.out.print("Nhap ngay bat dau : ");
        startDate=in.nextLine();
        System.out.print("Nhap ngay ket thuc : ");
        endDate=in.nextLine();
        System.out.print("So voucher can tao : ");
        n=in.nextInt();in.nextLine();
        dsvc=new Voucher[n];
        for(int i=0;i<n;i++){
        System.out.println("\n\nNhap voucher thu "+(i+1));
        dsvc[i]= new Voucher();
        dsvc[i].nhap();
        }
    }

    public void themvoucher(){
        dsvc = Arrays.copyOf(dsvc, n+1);
                dsvc[n]=new Voucher();
                dsvc[n].nhap();
                n++;
    }

    public void xoavoucher(){
        String a;
        System.out.print("Nhap ma voucher can xoa cua CTKM "+namePromotion+" : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dsvc[i].getidVoucher()).equals(a)){
                n--;
               for(int j=i; j<n; j++){
			   dsvc[j] = dsvc[j+1];
               }
            }
        }
    }

    public float discountrate(){
        float dsrate=0;
        System.out.print("\nNhap ma voucher : ");
        String a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dsvc[i].getidVoucher()).equals(a)){
                dsrate=dsvc[i].getdiscountRate()/100;
            }
        }
        return dsrate;
    }

    public void xuat(){
        System.out.println("\n-----------KHUYEN MAI "+namePromotion+" tu "+startDate+" den "+endDate+" -----------");
        for(int i=0;i<n;i++){
            System.out.println("\nVoucher thu  "+(i+1));
            dsvc[i].xuat();
        }
    }

}
