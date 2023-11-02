package DoAnOOP.Entity;
import java.util.Arrays;
import java.util.Scanner;

public class Bill {
    public static Scanner in= new Scanner(System.in);
    String idBill;
    String idEmployee;
    String idCustomer;
    String nameCustomer;
    String printDate;
    String idVoucher;
    float moneyOff;
    float totalBill;

    int n;
    detailBill dsdb[]= new detailBill[1];
    Promotions dskm[]= new Promotions[1];

    public Bill(){
        this.idBill="";
        this.idEmployee="";
        this.idCustomer="";
        this.nameCustomer="";
        this.printDate="";
        this.idVoucher="";
    }

    public Bill (String idBill, String idEmployee, String idCustomer, String nameCustomer, float totalBill, String printDate, String idVoucher){
        this.idBill=idBill;
        this.idEmployee=idEmployee;
        this.idCustomer=idCustomer;
        this.nameCustomer=nameCustomer;
        this.printDate=printDate;
        this.idVoucher=idVoucher;

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
    public void setidVoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public float getmoneyOff(){
        return moneyOff;
    }
    public void setmoneyOff(float moneyOff){
        this.moneyOff=moneyOff;
    }

    public float gettotalBill(){
        return totalBill;
    }
    public void settotalBill(float totalBill){
        this.totalBill=totalBill;
    }

    public void nhap(){
        System.out.print("\nNhap ngay in hoa don : ");
        printDate=in.nextLine();
        System.out.print("Nhap ma hoa don : ");
        idBill=in.nextLine();
        System.out.print("Nhap ma nhan vien : ");
        idEmployee=in.nextLine();
        System.out.print("Nhap ma khach hang : ");
        idCustomer=in.nextLine();
        System.out.print("Nhap ten khach hang : ");
        nameCustomer=in.nextLine();
        System.out.println("Nhap chi tiet hoa don.");
        System.out.print("So chi tiet hoa don : ");
        n=in.nextInt();in.nextLine();
            dsdb=new detailBill[n];
            for(int i=0;i<n;i++){
                    System.out.println("\nNhap chi tiet san pham thu "+(i+1));
                    dsdb[i]= new detailBill();
                    dsdb[i].nhap();
                }
        System.out.println("Khach hang co su dung voucher khong ?");
            System.out.println("1.Co.");
            System.out.println("2.khong.");
            int chon=in.nextInt();in.nextLine();
            switch (chon) {
            case 1:{
                System.out.println("\nNhap ten chuong trinh khuyen mai : ");
                String a=in.nextLine();
                for(int i=0;i<n;i++){
                if((dskm[i].namePromotion).equals(a)){
                    moneyOff=dskm[i].discountrate()*total();
                    totalBill=total()-moneyOff;
                        }
                    }
                }break;
            }
    }

    public void chitiet(){
        System.out.println("\n------CHI TIET HOA DON "+idBill+"------");
        for(int i=0;i<n;i++){
            dsdb[i].xuat();
        }
    }


    public float total(){
        float totalBill=0;
        for(int i=0;i<n;i++){
            totalBill+=dsdb[i].total();
        }
        return totalBill;
    }

    public void themchitiet(){
        dsdb = Arrays.copyOf(dsdb, n+1);
                dsdb[n]=new detailBill();
                dsdb[n].nhap();
                n++;
    }


    public void xoachitiet(){
        String a;
        System.out.print("Nhap ma san pham can xoa cua hoa don "+idBill+" : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dsdb[i].getidProduct()).equals(a)){
                n--;
               for(int j=i; j<n; j++){
			   dsdb[j] = dsdb[j+1];
               }
            }
        }
    }

    public void xuat(){
        System.out.println("\nNgay in hoa don : "+printDate);
        System.out.println("Ma hoa don : "+idBill);
        System.out.println("Nhan vien in hoa don : "+idEmployee);
        System.out.println("Ma khach hang : "+idCustomer);
        System.out.println("Ten khach hang : "+nameCustomer);
        for(int i=0;i<n;i++){
            dsdb[i].xuat();
        }
    }
}
