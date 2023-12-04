package DoAnOOP.Manager;

public class Menu {
    private ListProduct list = new ListProduct();
    private ListPromotionsSale listSale = new ListPromotionsSale();
    private ListBillImport listBillImport = new ListBillImport();
    public void printMenuEmployee() {
        int choice;
        do {
            System.out.println("==================QUẢN LÝ CỬA HÀNG=====================");
            System.out.println("1. Thêm sản phẩm.");
            System.out.println("2. Hiển thị danh sách.");
            System.out.println("3. Sửa thông tin sản phẩm");
            System.out.println("4. Tìm kiếm tin sản phẩm");
            System.out.println("5. Xoá sản phẩm");
            System.out.println("6. Thống kê.");
            System.out.println("7. Chương trình khuyến mãi");
            System.out.println("8. Đăng xuất.");
            choice = new Validate().checkChoiceUser(1, 8);
            switch (choice) {
                case 1:
                    addNewProductMenu();
                    break;
                case 2:
                    showSubMenu();
                    break;
                case 3:
                    list.updateProduct();
                    break;
                case 4:
                    SubMenufind();
                    break;
                case 5:
                    list.deleteProduct();
                    break;
                case 6:
                    // Report
                    break;
                case 7:
                    // Chuong trinh khuyen mai
//                    promotionsSaleMenu();
                    break;

            }
        } while(choice != 7);
    }

    public void subMenuAdd() {
        int choice;
        do {
            System.out.println("=====================THÊM MỚI SẢN PHẨM========================");
            System.out.println("1. Thêm sản phẩm từ file.");
            System.out.println("2. Thêm sản phẩm từ bàn phím.");
            System.out.println("3. Quay lại.");
            choice = new Validate().checkChoiceUser(1,3);
            switch (choice) {
                case 1:
                    list.addProduct(1);
                    break;
                case 2:
                    list.addProduct(2);
                    break;
            }

        } while(choice != 3);
    }

    public void subMenuRestock() {
        int choice;
        do {
            System.out.println("=====================THÊM MỚI SẢN PHẨM========================");
            System.out.println("1. Thêm số lượng sản phẩm.");
            System.out.println("2. Thêm số lượng sản phẩm đã hết HOẶC khôi phục sản phẩm đã xóa");
            System.out.println("3. Quay lại.");
            choice = new Validate().checkChoiceUser(1,3);
            switch (choice) {
                case 1:
                    list.restock1();
                    break;
                case 2:
                    list.restock();
                    break;
            }

        } while(choice != 3);
    }

    public void addNewProductMenu() {
        int choice;
        do {
            System.out.println("=====================THÊM SẢN PHẨM========================");
            System.out.println("1. Thêm mới sản phẩm.");
            System.out.println("2. Thêm số lượng sản phẩm.");
            System.out.println("3. Quay lại.");
            choice = new Validate().checkChoiceUser(1,3);
            switch (choice) {
                case 1:
                    subMenuAdd();
                    break;
                case 2:
                    subMenuRestock();
                    break;
            }

        } while(choice != 3);
    }

//    public void promotionsSaleMenu() {
//        int choice;
//        do {
//            System.out.println("=====================TẠO CHƯƠNG TRÌNH KHUYẾN MÃI========================");
//            System.out.println("1. Tạo chương trình khuyến mãi.");
//            System.out.println("2. Hiển thị danh sách mã khuyến mãi của 1 chương trình.");
//            System.out.println("3. Quay lại.");
//            choice = new Validate().checkChoiceUser(1,3);
//            switch (choice) {
//                case 1:
//                    listSale.addPromotionsSale();
//                    break;
//                case 2:
//                    listSale.showAllPromotionsSale();
////                    listSale.addVoucher();
//                    break;
//            }
//
//        } while(choice != 3);
//    }

    public void reportMenu() {
        int choice;
        do {
            System.out.println("=====================THỐNG KÊ========================");
            System.out.println("1. Thống kê số lượng sản phẩm đang tồn.");
            System.out.println("2. Thống kê số lượng sản phẩm đã bán.");
            System.out.println("3. Thống kê số lượng mã khuyến mãi của từng chương trình.");
            System.out.println("4. Thống kê lợi nhuận.");
            System.out.println("5. Quay lại.");
            choice = new Validate().checkChoiceUser(1,5);
            switch (choice) {
                case 1:
                    listSale.addPromotionsSale();
                    break;
                case 2:
//                    list.listBillImport.show();
                    break;
            }

        } while(choice != 5);
    }

    public void SubMenufind(){
        int choice;
        do{
            System.out.println("=====================TÌM SẢN PHẨM========================");
            System.out.println("1.Tìm sản phẩm theo mã sản phẩm");
            System.out.println("2.Tìm sản phẩm theo tên sản phẩm");
            System.out.println("3.Quay lại");
            choice = new Validate().checkChoiceUser(1, 3);
            switch (choice) {
                case 1:
                    list.findIdProduct();
                    break;
                case 2:
                    list.findNameProduct();
                    break;
            }
        }while(choice != 3);
    }

    public void showSubMenu() {
        int choice;
        do {
            System.out.println("=====================HIỂN THỊ DANH SÁCH========================");
            System.out.println("1. Hiển thị danh sách sản phẩm.");
            System.out.println("2. Hiển thị danh sách phiếu nhập.");
            System.out.println("3. Quay lại.");
            choice = new Validate().checkChoiceUser(1, 3);
            switch (choice) {
                case 1:
                    list.showProduct(true);
                    break;
                case 2:
                    listBillImport.show();
                    break;
            }

        } while(choice != 3);
    }
}
