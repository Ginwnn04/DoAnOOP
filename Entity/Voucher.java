public class Voucher {
    String idVoucher;
    String startDate;
    String endDate;
    float moneyOff;

    public Voucher(){
        this.idVoucher="";
        this.startDate="";
        this.endDate="";
        this.moneyOff=0;
    }
    public Voucher(String idVoucher, String startDate, String endDate, float moneyOff){
        this.idVoucher=idVoucher;
        this.startDate=startDate;
        this.endDate=endDate;
        this.moneyOff=moneyOff;
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
    public float getmoneyOff(){
        return moneyOff;
    }
    public void setmoneyOff(float moneyOff){
        this.moneyOff=moneyOff;
    }
}
