import java.io.IOException;

public class testBill {
    public static void main(String[] args) throws IOException {
        int choice;
        ListBill voucher = new ListBill();
        do {
            System.out.println("\n=====================TẠO CHƯƠNG TRÌNH KHUYẾN MÃI========================");
            System.out.println("1. Tạo hóa đơn mới.");
            System.out.println("2. Xuất hóa đơn.");
            System.out.println("3. Lịch sử hóa đơn.");
            System.out.println("4. Thây đổi số lượng sản phẩm mua.");
            System.out.println("5. Mua thêm sản phẩm.");
            System.out.println("6. Xóa bớt sản phẩm.");
            System.out.println("7. Tìm kiếm hóa đơn bằng mã.");
            System.out.println("8. Tìm kiếm hóa đơn bằng ngày xuất.");
            System.out.println("9. Tìm kiếm hóa đơn bằng mã nhân viên.");
            System.out.println("10. Tìm kiếm hóa đơn bằng tên khách hàng.");
            System.out.println("11. Doc File");
            System.out.println("12. Ghi File");
            System.out.println("0. Quay lại.");
            choice = new Validate().checkChoiceUser(0,11);
            switch (choice) {
                case 1: 
                    voucher.addBill();
                    break;
                case 2:
                    voucher.printBill();
                    break;
                case 3:
                    voucher.printListBill();
                    break;
                case 4:
                    voucher.fixQuantityProduct();
                    break;
                case 5:
                    voucher.addProduct();
                    break;
                case 6:
                    voucher.deleteProduct();
                    break;
                case 7:
                    voucher.findBillByIdBill();
                    break;
                case 8:
                    voucher.findBillByDay();
                    break;
                case 9:
                    voucher.findBillByIdEmployee();
                    break;
                case 10:
                    voucher.findBillByName();
                    break;
                case 11:
                    voucher.readData();
                    break;
                case 12:
                    voucher.writeData(true);
                    break;
            }

        } while(choice != 0);
    }
}
