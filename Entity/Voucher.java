package DoAnOOP.Entity;

import DoAnOOP.Manager.Validate;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Voucher {
    String idVoucher;
    float moneyDiscount;
    String startDate;
    String endDate;

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidvoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public float getmoneyDiscount(){
        return moneyDiscount;
    }

    public void setmoneyDiscount(float moneyDiscount){
        this.moneyDiscount=moneyDiscount;
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

    public Voucher(){}

    public Voucher(String idVoucher, float moneyDiscount, String startDate, String endDate){
        this.idVoucher=idVoucher;
        this.moneyDiscount=moneyDiscount;
        this.startDate=startDate;
        this.endDate=endDate;
    }

    public String taoidVoucher(){
        String idVoucher="VC"+"-"+ (int)(Math.random()*1000);
        return idVoucher;
    }

    public void input(){
        idVoucher= taoidVoucher();
        moneyDiscount=new Validate().checkNumberInput("Nhập giá tiền giảm", "Số tiền > 0, vui lòng nhập lại");
        startDate=new Validate().checkStringUser("Nhập ngày bắt đàu");
        endDate=new Validate().checkStringUser("Ngày kết thúc");
    }

    public void print(){
        System.out.println(idVoucher+" giảm "+moneyDiscount+" đồng");
    }

    public void writeFile() throws IOException {
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("voucher.txt",Boolean.TRUE));
        outStream.writeUTF(idVoucher);
        outStream.writeFloat(moneyDiscount);
        outStream.writeUTF(startDate);
        outStream.writeUTF(endDate);
        outStream.close();
        System.out.println("Luu thanh cong !");
    }
}
