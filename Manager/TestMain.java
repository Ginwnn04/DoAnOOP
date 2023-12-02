
public class TestMain {

    public static void menu(){
        System.out.println("\n==========MENU==========");
        System.out.println("1.HOA DON.");
        System.out.println("2.KHUYEN MAI.");
    }
    public static void menuVoucher(){
        System.out.println("\n==========MENU VOUCHER==========");
        System.out.println("1.Tao voucher.");
        System.out.println("2.Xuat voucher.");
        System.out.println("3.Tim kiem chuong trinh khuyen mai.");
        System.out.println("4.Tao them voucher.");
        System.out.println("5.Xoa voucher.");
        System.out.println("6.Xoa chuong trinh khuyen mai.");
        System.out.println("7.Quay lai MENU.");
    }
    public static void menuBill(){
        System.out.println("\n==========MENU HOA DON==========");
        System.out.println("1.Tao hoa don.");
        System.out.println("2.In hoa don.");
        System.out.println("3.Xuat danh sach hoa don.");
        System.out.println("4.Tim kiem hoa don.");
        System.out.println("5.Mua them san pham.");
        System.out.println("6.Xoa bot san pham.");
        System.out.println("7.Doc file.");
        System.out.println("8.Ghi file.");
        System.out.println("9.Quay lai MENU.");
    }
    public static void main(String[] args) {
        int chon;
        ListBill dshd = new ListBill();
        ListPromotionsSale dskm = new ListPromotionsSale();
        do{
            menu();
            chon=new Validate().checkNumberInput("\nMoi nhap lua chon","sai");
            new Validate().clearBuffer();
            switch(chon){
                case 1: {
                    do{
                        menuBill();
                        chon=new Validate().checkNumberInput("\nMoi nhap lua chon","sai");
                        new Validate().clearBuffer();
                        switch(chon){
                            case 1: dshd.addBill();break;
                            case 2: dshd.printBill();break;
                            case 3: dshd.printListBill();break;
                            case 4: dshd.findBillByMonth();break;
                            case 5: dshd.addProduct();break;
                            case 6: dshd.deleteProduct();break;
                            case 7: dshd.readData();break;
                            case 8: dshd.writeData(true);
                        }
                    } 
                    while(chon<9);
                }break;
                case 2:{
                    do{
                        menuVoucher();
                        chon=new Validate().checkNumberInput("\nMoi nhap lua chon","Sai");
                        switch(chon){
                            case 1: dskm.input();break;
                            case 2: dskm.print();break;
                           // case 3: dskm.timkiem();break;
                            case 4: dskm.addVoucher();break;
                            case 5: dskm.deleteVoucher();break;
                            //case 6: dskm.xoa();break;
                        }
                    }
                    while(chon<7);
                }break;
            }
        }
        while(chon!=0);
    }
}
