package DoAnOOP.Entity;


import DoAnOOP.Manager.Validate;

import java.util.Arrays;

public class PromotionsSale {
    private String namePromotions;
    private String startDate;
    private String endDate;

    int totalVoucher;
    Voucher listVoucher[];

    public PromotionsSale() {
    }

    public PromotionsSale(String namePromotions, String firstKey, String startDate, String endDate, int moneyDiscount) {
        this.namePromotions = namePromotions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getnamePromotions(){
        return namePromotions;
    }
    public void setnamePromotions(String namePromotions){
        this.namePromotions=namePromotions;
    }

    public String getstartDate(){
        return startDate;
    }
    public void setstartDate(String startDate){
        this.startDate=startDate;
    }

    public String getendDate(){
        return namePromotions;
    }
    public void setendDate(String endDate){
        this.endDate=endDate;
    }

    public void input(){
        namePromotions=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi");
        startDate=new Validate().checkStringUser("Nhập ngày bắt đầu");
        endDate=new Validate().checkStringUser("Nhập ngày kết thúc");
        totalVoucher=new Validate().checkIntUser("Số voucher cần tạo");
        listVoucher=new Voucher[totalVoucher];
        for(int i=0;i<totalVoucher;i++){
        System.out.println("\n\nNhập voucher thứ "+(i+1));
        listVoucher[i]= new Voucher();
        listVoucher[i].input();
        }
    }

    public void addVoucher(){
        listVoucher = Arrays.copyOf(listVoucher, totalVoucher+1);
        listVoucher[totalVoucher]=new Voucher();
        listVoucher[totalVoucher].input();
        totalVoucher++;
    }

    public void deleteVoucher(){
        String a=new Validate().checkStringUser("Nhập mã voucher cần xóa ");
        for(int i=0;i<totalVoucher;i++){
            if((listVoucher[i].getidVoucher()).equals(a)){
                totalVoucher--;
               for(int j=i; j<totalVoucher; j++){
			   listVoucher[j] = listVoucher[j+1];
               }
            }
        }
    }

    public Voucher findVoucher(String idVoucherUser){
        for (int i = 0; i < totalVoucher; i++) {
            if (listVoucher[i].getidVoucher().equals(idVoucherUser)) {
                return listVoucher[i];
                } 
            }
             return null; 
    }

    public void search(){
        String idVoucherUser = new Validate().checkStringUser("Nhập mã voucher cần tìm");
        for(int i=0;i<totalVoucher;i++){
            if((listVoucher[i].getidVoucher()).equals(idVoucherUser)){
                listVoucher[i].print();
            }
        }
    }

    public void print(){
        System.out.println("\n-----------KHUYẾN MÃI "+namePromotions+" -----------");
        for(int i=0;i<totalVoucher;i++){
            System.out.println("\nVoucher thứ  "+(i+1));
            listVoucher[i].print();
        }
    }

    public Voucher getVoucherByCode(String idVoucher) {
        for (Voucher voucher : listVoucher) {
            if (voucher != null && voucher.getidVoucher().equals(idVoucher)) {
                return voucher;
            }
        }
        return null;
    }

    public void showPromotionsSale() {
        int colSpace = 25;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "d\n", namePromotions, startDate, endDate);

    }

//        public String creatVoucher() {
//        long discount = new Validate().checkMoneyInput("Nhập vào số tiền giảm giá");
//        if (discount == -1) {
//            return null;
//        }
//        listVoucher = Arrays.copyOf(listVoucher, totalVoucher + 1);
//        listVoucher[totalVoucher++] = new Voucher(keyPromotions, discount);
//        new Validate().clearBuffer();
//        return listVoucher[totalVoucher - 1].getidVoucher();
//    }

//    public String creatCodeDiscount(String firstKey) {
//      String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
//        int size = 12;
//        StringBuilder stringBuilder = new StringBuilder(size);
//        for(int i = 0; i < size; i++) {
//            int x = (int)(Math.random() * 61);
//            stringBuilder.append(s.charAt(x));
//        }
//        return firstKey + "-" + stringBuilder.toString();
//    }

}
