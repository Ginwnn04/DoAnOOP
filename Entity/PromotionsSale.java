package DoAnOOP.Entity;


import DoAnOOP.Manager.Validate;

import java.util.Arrays;

public class PromotionsSale {
    private String namePromotions;
    private String codeDiscount;
    private String startDate;
    private String endDate;
    private int moneyDiscount;


    public PromotionsSale() {
    }

    public PromotionsSale(String namePromotions, String firstKey, String startDate, String endDate, int moneyDiscount) {
        this.namePromotions = namePromotions;
        this.codeDiscount = creatCodeDiscount(firstKey);
        this.startDate = startDate;
        this.endDate = endDate;
        this.moneyDiscount = moneyDiscount;
    }

//    public String creatVoucher() {
//        long discount = new Validate().checkMoneyInput("Nhập vào số tiền giảm giá");
//        if (discount == -1) {
//            return null;
//        }
//        listVoucher = Arrays.copyOf(listVoucher, totalVoucher + 1);
//        listVoucher[totalVoucher++] = new Voucher(keyPromotions, discount);
//        new Validate().clearBuffer();
//        return listVoucher[totalVoucher - 1].getidVoucher();
//    }

    public String creatCodeDiscount(String firstKey) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz0123456789";
        int size = 12;
        StringBuilder stringBuilder = new StringBuilder(size);
        for(int i = 0; i < size; i++) {
            int x = (int)(Math.random() * 61);
            stringBuilder.append(s.charAt(x));
        }
        return firstKey + "-" + stringBuilder.toString();
    }

    public void showPromotionsSale() {
        int colSpace = 25;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "d\n", namePromotions, startDate, endDate, moneyDiscount);

    }

}
