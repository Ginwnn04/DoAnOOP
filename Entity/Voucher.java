package DoAnOOP.Entity;
import DoAnOOP.Manager.Validate;


public class Voucher {
    String idVoucher;
    int moneyDiscount;

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidvoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public int getmoneyDiscount(){
        return moneyDiscount;
    }

    public void setmoneyDiscount(int moneyDiscount){
        this.moneyDiscount=moneyDiscount;
    }

    public Voucher(){}

    public Voucher(String idVoucher, int moneyDiscount){
        this.idVoucher=idVoucher;
        this.moneyDiscount=moneyDiscount;
    }

    public String taoidVoucher(){
        String idVoucher="VC"+"-"+ (int)(Math.random()*1000);
        return idVoucher;
    }

    public void input(){
        idVoucher= taoidVoucher();
        moneyDiscount=new Validate().checkNumberInput("Nhập giá tiền giảm", "Số tiền > 0, vui lòng nhập lại");
    }

    public void print(){
        System.out.println(idVoucher+" giảm "+moneyDiscount+" đồng");
    }
}
