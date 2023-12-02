import java.io.IOException;

public class testPromotions {
    public static void main(String[] args) throws IOException {
        int choice;
        ListPromotionsSale voucher = new ListPromotionsSale();
        do {
            System.out.println("\n=====================TẠO CHƯƠNG TRÌNH KHUYẾN MÃI========================");
            System.out.println("1. Tạo chương trình khuyến mãi.");
            System.out.println("2. Hiển thị danh sách chương trình khuyến mãi.");
            System.out.println("3. Thêm chương trình khuyến mãi.");
            System.out.println("4. Xóa chương trình khuyến mãi.");
            System.out.println("5. Thêm voucher.");
            System.out.println("6. Xóa voucher.");
            System.out.println("7. Tìm kiếm chương trình khuyến mãi.");
            System.out.println("8. Tìm kiếm voucher.");
            System.out.println("9. Thây đổi tên chương trình khuyến mãi.");
            System.out.println("10. Đọc File.");
            System.out.println("11. Ghi File");
            System.out.println("0. Quay lại.");
            choice = new Validate().checkChoiceUser(0,11);
            switch (choice) {
                case 1: 
                    voucher.input();
                    break;
                case 2:
                    voucher.print();
                    break;
                case 3:
                    voucher.addPromotionsSale();
                    break;
                case 4:
                    voucher.deletePromotionsSale();
                    break;
                case 5:
                    voucher.addVoucher();
                    break;
                case 6:
                    voucher.deleteVoucher();
                    break;
                case 7:
                    voucher.findPromotions();
                    break;
                case 8:
                    voucher.findVoucher();
                    break;
                case 9:
                    voucher.fixNamePromotions();
                    break;
                case 10:
                    voucher.readData();
                    break;
                case 11:
                    voucher.writeData(true);
                    break;
            }

        } while(choice != 0);
    }
}
