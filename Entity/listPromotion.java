import java.util.Arrays;
import java.util.Scanner;

public class listPromotion {
    public static Scanner in= new Scanner(System.in);
    int n; 
    int chon;
    Voucher dsvc[]= new Voucher[1];
    Promotions dskm[]= new Promotions[1];

    public listPromotion(){}
    public listPromotion(int n,listPromotion ds2[]){
        this.n=n;
    }

    public void nhap(){
        n=1;
        dskm= new Promotions[1];
        for(int i=0;i<n;i++){
            System.out.println("Nhap chuong trinh khuyen mai thu "+(i+1));
            dskm[i]=new Promotions();
            dskm[i].nhap();
        }
    }
    
    public void them(){
        dskm = Arrays.copyOf(dskm, n+1);
        dskm[n]=new Promotions();
        dskm[n].nhap();
        n++;
    }

    public void taovoucher(){
        String a;
        System.out.print("Them vao chuong trinh khuyen mai : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dskm[i].namePromotion).equals(a)){
                dskm[i].themvoucher();
            }
        }
    }

    public void huyvoucher(){
        String a;
        System.out.print("Nhap ten CTKM cua voucher can xoa : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dskm[i].getnamePromotion()).equals(a)){
                dskm[i].xoavoucher();  
               }
            }
    }

    public void xoa(){
        String a;
        System.out.print("Nhap ten CTKM muon xoa : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dskm[i].getnamePromotion()).equals(a)){
                n--;
               for(int j=i; j<n; j++){
			   dskm[j] = dskm[j+1];
               } 
               }
            }
    }


    public void xuat(){
        System.out.println("\n========================CHUONG TRINH KHUYEN MAI=======================");
        for(int i=0;i<n;i++){
            dskm[i].xuat();
        }
    }

    public void timkiem(){
        String a;
        System.out.println("\nNhap ten chuong trinh khuyen mai : ");
        a=in.nextLine();
        for(int i=0;i<n;i++){
            if((dskm[i].namePromotion).equals(a)){
                dskm[i].xuat();
            }
        }
    }
}
