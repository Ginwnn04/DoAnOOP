package MyOOP.Entity;

import java.util.Arrays;

import MyOOP.Manager.Validate;

public class PromotionsSale {
    private String namePromotions;
    private String keyPromotions;
    private String startDate;
    private String endDate;
    private int totalVoucher;
    public Voucher[] listVoucher;

    public PromotionsSale() {
        this.listVoucher = new Voucher[totalVoucher];
    }

    public PromotionsSale(String namePromotions, String keyPromotions, String startDate, String endDate) {
        this.listVoucher = new Voucher[totalVoucher];
        this.namePromotions = namePromotions;
        this.keyPromotions = keyPromotions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String creatVoucher() {
        long discount = new Validate().checkMoneyInput("Nhập vào số tiền giảm giá");
        if (discount == -1) {
            return null;
        }
        listVoucher = Arrays.copyOf(listVoucher, totalVoucher + 1);
        listVoucher[totalVoucher++] = new Voucher(keyPromotions, discount);
        new Validate().clearBuffer();
        return listVoucher[totalVoucher - 1].getidVoucher();
    }

    public void showPromotionsSale() {
        int colSpace = 25;
        for(Voucher x : listVoucher) {
            System.out.printf("%-" + colSpace + "s %-"
                    + colSpace + "s %-"
                    + colSpace + "s %-"
                    + colSpace + "s %-"
                    + colSpace + "s\n", namePromotions, startDate, endDate, x.getidVoucher(), x.getmoneyOff());
        }

    }

    public void showVoucher() {
        int colSpace = 25;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s\n", "Mã voucher", "Tiền giảm");

        for(Voucher x: listVoucher) {
            x.printVoucher();
        }
    }
    public String getnamePromotions(){
        return namePromotions;
    }
    public void setnamePromotions(String namePromotions){
        this.namePromotions=namePromotions;
    }
    public String getKeyPromotions() {
        return keyPromotions;
    }
    public void setKeyPromotions(String KeyPromotions){
        this.keyPromotions=keyPromotions;
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
    public int gettotalVoucher(){
        return totalVoucher;
    }
    public void settotalVoucher(int totalVoucher){
        this.totalVoucher=totalVoucher;
    }
    public Voucher[] getlistVoucher(){
        return listVoucher;
    }
    public void setlistVoucher(Voucher[] liVoucher){
        this.listVoucher=listVoucher;
    }
    public float discountrate() {
        return 0;
    }
}
