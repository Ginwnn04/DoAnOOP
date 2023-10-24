package DoAnOOP.Manager;

import DoAnOOP.Entity.Voucher;

import java.util.Arrays;

public class ListVoucher {
    private Voucher[] listVoucher;
    private int totalVoucher;

    public ListVoucher() {
        this.listVoucher = new Voucher[totalVoucher];
    }

    public ListVoucher(int totalVoucher) {
        this.totalVoucher = totalVoucher;
        this.listVoucher = new Voucher[totalVoucher];
    }

    public String creatVoucher() {
        String startDate = new Validate().checkStringUser("Nhập vào ngày bắt đầu giảm giá");
        String endDate = new Validate().checkStringUser("Nhập vào ngày kết thúc giảm giá");
        double discount = new Validate().checkMoneyInput("Nhập vào số tiền giảm giá");
        if (discount == -1) {
            return null;
        }
        listVoucher = Arrays.copyOf(listVoucher, totalVoucher + 1);
        listVoucher[totalVoucher++] = new Voucher(startDate, endDate, discount);
        return listVoucher[totalVoucher - 1].getidVoucher();
    }
}
