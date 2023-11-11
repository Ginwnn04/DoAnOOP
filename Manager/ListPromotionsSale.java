package DoAnOOP.Manager;

import java.util.Arrays;
import DoAnOOP.Entity.PromotionsSale;

public class ListPromotionsSale {
    public PromotionsSale[] listPromotionsSale;
    public int totalPromotionsSale;

    public ListPromotionsSale() {
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
    }

    public ListPromotionsSale(ListPromotionsSale x) {
        this.listPromotionsSale = x.listPromotionsSale;
        this.totalPromotionsSale = x.totalPromotionsSale;
    }

    public void addPromotionsSale() {
        String namePromotions = new Validate().checkStringUser("Nhập tên chương trình khuyến mãi");
        String keyPromotions = new Validate().checkStringUser("Kí tự bắt đầu khuyến mãi");
        String startDate = new Validate().checkStringUser("Nhập ngày bắt đầu chương trình khuyến mãi");
        String endDate = new Validate().checkStringUser("Nhập ngày kết thúc chương trình khuyến mãi");
        int moneyDiscount = new Validate().checkMoneyInput("Nhập số tiền giảm giá");
        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
        listPromotionsSale[totalPromotionsSale++] = new PromotionsSale(namePromotions, keyPromotions, startDate, endDate, moneyDiscount);
        System.out.println("Tạo chương trình khuyến mãi thành công !");
    }

    public void showAllPromotionsSale() {
        int colSpace = 25;
        System.out.println("=======================DANH SÁCH CHƯƠNG TRÌNH KHUYẾN MÃI======================");
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s\n", "Tên chương trình", "Ngày bắt đầu", "Ngày kết thúc", "Mã voucher", "Tiền giảm giá");
        for(PromotionsSale x : listPromotionsSale) {
            x.showPromotionsSale();

        }
    }

}
