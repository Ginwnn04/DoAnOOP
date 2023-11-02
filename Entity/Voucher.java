package DoAnOOP.Entity;
import java.util.Scanner;

public class Voucher {
    public static Scanner in= new Scanner(System.in);
    String idVoucher;
    int discountRate;

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidvoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public int getdiscountRate(){
        return discountRate;
    }

    public String creaKey(){
        String randomKey= "-"+ (int)(Math.random()*100000000);
        return randomKey;
    }

    public void nhap(){
        System.out.print("Nhập mã voucher : ");
        idVoucher=in.nextLine();
        System.out.print("Nhập phần trăm giảm : ");
        discountRate=in.nextInt();in.nextLine();
    }

    public void xuat(){
        System.out.println(idVoucher+" "+discountRate+"%");
    }
