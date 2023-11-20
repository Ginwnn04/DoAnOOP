package DoAnOOP.Manager;

import java.util.Arrays;
import DoAnOOP.Entity.PromotionsSale;

public class ListPromotionsSale {
    public int totalPromotionsSale;
    public PromotionsSale[] listPromotionsSale;

    public ListPromotionsSale() {
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
    }

    public ListPromotionsSale(ListPromotionsSale x) {
        this.listPromotionsSale = x.listPromotionsSale;
        this.totalPromotionsSale = x.totalPromotionsSale;
    }

    public void input(){
        totalPromotionsSale=new Validate().checkIntUser("Nhập số chương trình khuyến mãi cần tạo");
        listPromotionsSale=new PromotionsSale[totalPromotionsSale];
        for(int i=0;i<totalPromotionsSale;i++){
        System.out.println("\n\nNhập chương trình khuyến mãi thứ "+(i+1));
        listPromotionsSale[i]= new PromotionsSale();
        listPromotionsSale[i].input();
        }
    }

    public void print(){
        System.out.println("-------------------------------DÁNH SÁCH CHƯƠNG TRÌNH KHUYẾN MÃI------------------------------");
        for(int i=0;i<totalPromotionsSale;i++){
            listPromotionsSale[i].print();
        }
    }

    public void addPromotionsSale(){
        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale+1);
        listPromotionsSale[totalPromotionsSale]=new PromotionsSale();
        listPromotionsSale[totalPromotionsSale].input();
        totalPromotionsSale++;
        System.out.println("Thêm chương trình khuyến mãi thành công !");
    }

    public void deletePromotionsSale(){
        String namePromotionsUser=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi cần xóa ");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getnamePromotions()).equals(namePromotionsUser)){
                totalPromotionsSale--;
               for(int j=i; j<totalPromotionsSale; j++){
			   listPromotionsSale[j] = listPromotionsSale[j+1];
               }
            }
        }
        System.out.println("Xóa chương trình khuyến mãi thành công !");
    }

    public void addVoucher(){
        String namePromotionsUser=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi muốn thêm voucher ");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getnamePromotions()).equals(namePromotionsUser)){
                listPromotionsSale[i].addVoucher();
            }
        }
        System.out.println("Thêm voucher thành công !");
    }

    public void deleteVoucher(){
        String namePromotionsUser=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi của voucher cần xóa ");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getnamePromotions()).equals(namePromotionsUser)){
                listPromotionsSale[i].deleteVoucher();
            }
        }
        System.out.println("Xóa voucher thành công !");
    }

    public void searchPromotions(){
        String namePromotionsUser = new Validate().checkStringUser("Nhập tên chương trình khuyến mãi muốn tìm");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getnamePromotions()).equals(namePromotionsUser)){
                listPromotionsSale[i].print();
            }
        }
    }

    public void searchVoucher(){
        String namePromotionsUser = new Validate().checkStringUser("Nhập tên chương trình khuyến mãi của voucher cần tìm");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getnamePromotions()).equals(namePromotionsUser)){
                listPromotionsSale[i].search();
            }
        }
    }

    public Voucher getVoucherByPromotions(String namePromotions, String idVoucher) {
        for (PromotionsSale promotionsSale : listPromotionsSale) {
            if (promotionsSale != null && promotionsSale.getnamePromotions().equals(namePromotions)) {
                return promotionsSale.getVoucherByCode(idVoucher);
                }
            }
        return null;
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
