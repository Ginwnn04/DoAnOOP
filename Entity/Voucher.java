package DoAnOOP.Entity;
public class Voucher {
    private String idVoucher;
    private String startDate;
    private String endDate;
    private double moneyOff;

    public Voucher(){
        this.idVoucher = "";
        this.startDate = "";
        this.endDate = "";
        this.moneyOff = 0;
    }
    public Voucher(String startDate, String endDate, double moneyOff){
        this.idVoucher = creatKey();
        this.startDate = startDate;
        this.endDate = endDate;
        this.moneyOff = moneyOff;
    }
    public String creatKey() {
        String randomKey =  "-" +  (int)(Math.random() * 100000000);
        return randomKey;
    }


    public String getidVoucher() {
        return idVoucher;
    }
    public void setidVoucher(String idVoucher) {
        this.idVoucher=idVoucher;
    }
    public String getstartDate(){
        return startDate;
    }
    public void setstartDate(String startDate){
        this.startDate=startDate;
    }
    public String getsendDate(){
        return endDate;
    }
    public void setendDate(String endDate){
        this.endDate=endDate;
    }
    public double getmoneyOff(){
        return moneyOff;
    }
    public void setmoneyOff(float moneyOff){
        this.moneyOff=moneyOff;
    }
}
