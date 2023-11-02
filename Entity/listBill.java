import java.util.Arrays;
import java.util.Scanner;

public class listBill {
    public static Scanner in= new Scanner(System.in);
    int n;
    int chon;
    Bill dshd[]= new Bill[1];
    Promotions dskm[]= new Promotions[1];

    public listBill(){}
    public listBill(int n, listBill ds2[]){
        this.n=n;
    }

    public void nhap(){
        n=1;
        dshd=new Bill[1];
        for(int i=0;i<n;i++){
        System.out.println("\n\nNhap hoa don thu "+(i+1));
        dshd[i]= new Bill();
        dshd[i].nhap();
        }
    }

    public void in(){
        dshd[n-1].xuat();
        System.out.println("Tong tien : "+dshd[n-1].total());
        System.out.println("Tien duoc giam : "+dshd[n-1].getmoneyOff());
        System.out.println("Tien can thanh toan : "+dshd[n-1].gettotalBill());
        }

    public void xuat(){
        System.out.println("--------DANH SACH HOA DON--------");
        for(int i=0;i<n;i++){
            System.out.println("\nHoa don thu "+(i+1));
            dshd[i].xuat();
            System.out.println("Tong tien : "+dshd[i].total());
            System.out.println("Tien duoc giam : "+dshd[i].getmoneyOff());
            System.out.println("Tien can thanh toan : "+dshd[i].gettotalBill());
        }
    }

    

    public void timkiem(){
        String a;
        System.out.println("1.Tim kiem theo ma hoa don.");
        System.out.println("2.Tim kiem theo ma nhan vien.");
        System.out.println("3.Tim kiem theo ma khach hang.");
        System.out.println("4.Tim kiem theo ten khach hang.");
        System.out.print("Moi nhap lua chon : ");
        chon=in.nextInt();in.nextLine();
        switch (chon) {
            case 1:
                System.out.print("Moi nhap ma hoa don : ");
                a=in.nextLine();
                for(int i=0;i<n;i++){
                if((dshd[i].getidBill()).equals(a)){
                dshd[i].xuat();
                }
            }break;
            case 2:
                System.out.print("Moi nhap ma nhan vien : ");
                a=in.nextLine();
                for(int i=0;i<n;i++){
                if((dshd[i].getidEmployee()).equals(a)){
                dshd[i].xuat();
                }
            }break;
            case 3:
                System.out.print("Moi nhap ma khach hang : ");
                a=in.nextLine();
                for(int i=0;i<n;i++){
                if((dshd[i].getidCustomer()).equals(a)){
                dshd[i].xuat();
                }
            }break;
            case 4:
                System.out.print("Moi nhap ten khach hang : ");
                a=in.nextLine();
                for(int i=0;i<n;i++){
                if((dshd[i].getnameCustomer()).equals(a)){
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
            System.out.println("1.Thong ke hoa don theo ngay.");
            System.out.println("2.Thong ke hoa don theo thang");
            System.out.println("3.Thong ke hoa don theo nam");
            System.out.println("4.Thong ke hoa don theo gia tien");
            System.out.println("Nhap lua chon");
            chon=in.nextInt();in.nextLine();
            switch(chon){
                case 1: {
                System.out.print("\nNhap ngay :");
                String a=in.nextLine();
                System.out.println("\n---------HOA DON IN NGAY "+a+"--------");
                for(int i=0;i<n;i++){
                    if((dshd[i].getprintDate()).equals(a)){
                        dshd[i].xuat();
                    }
                }
                }break;
                case 4:{
                System.out.println("1.Thong ke hoa don duoi 100.000dong.");
                System.out.println("2.Thong ke hoa don tu 100.000dong den 500.000dong");
                System.out.println("3.Thong ke hoa don tren 500.000dong");
                System.out.println("Nhap lua chon");
                chon=in.nextInt();in.nextLine();
                switch(chon){
                    case 1:{
                         System.out.println("\n---------HOA DON DUOI 100.000dong--------");
                         for(int i=0;i<n;i++){
                        if(dshd[i].total()<100000){
                           dshd[i].xuat();
                            }
                        }
                    }break;
                    case 2:{
                         System.out.println("\n---------HOA DON tu 100.000dong den 500.000dong--------");
                         for(int i=0;i<n;i++){
                        if((dshd[i].total()>100000)&&(dshd[i].total()<500000)){
                           dshd[i].xuat();
                            }
                        }
                    }break;
                    case 3:{
                         System.out.println("\n---------HOA DON TREN 500.000dong--------");
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
