package DoAnOOP.Manager;
import DoAnOOP.Entity.PromotionsSale;
import DoAnOOP.Entity.ServiceFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ListPromotionsSale implements ServiceFile {
    private int totalPromotionsSale;
    private PromotionsSale[] listPromotionsSale;
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private String path = System.getProperty("user.dir") + "/src/DoAnOOP/GiamGia.txt";

    //Constructor
    public ListPromotionsSale() {
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
    }


    //Hàm xuất
    public void print() {
        int colSpace = 15;
        System.out.println("=======================" + "DANH SACH CHUONG TRINH KHUYEN MAI" + "======================");
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s\n", "Mã CT", "Tên CT", "Ngày bắt đầu", "Ngày kết thúc", "Mã giảm giá", "Tiền giảm");
        for (int i = 0; i < totalPromotionsSale; i++) {
            listPromotionsSale[i].print();
        }
    }

    //Hàm thêm CTKM
    public void addPromotionsSale() {
        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
        listPromotionsSale[totalPromotionsSale] = new PromotionsSale();
        listPromotionsSale[totalPromotionsSale].createPromotionSale();
        totalPromotionsSale++;
        System.out.println("Them CTKM thanh cong !");
    }


    //Hàm xóa CTKM
    public void deletePromotionsSale() {
        int count = 0;
        String idPromotionUser = new Validate().checkStringUser("Nhập ma CTKM cần xóa");
        for (int i = 0; i < totalPromotionsSale; i++) {
            if ((listPromotionsSale[i].getidPromotions()).equals(idPromotionUser)) {
                totalPromotionsSale--;
                for (int j = i; j < totalPromotionsSale; j++) {
                    listPromotionsSale[j] = listPromotionsSale[j + 1];
                }
                System.out.println("Xoa CTKM thanh cong !");
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Khong tim thay CTKM ");
        }
    }

    //Hàm thêm Voucher
    public void addVoucher() {
        int count = 0;
        String idPromotionsUser = new Validate().checkStringUser("Nhap ma Chuong Trinh Khuyen Mai");
        for (int i = 0; i < totalPromotionsSale; i++) {
            if ((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)) {
                listPromotionsSale[i].addVoucher();
                System.out.println("Them voucher thanh cong !");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay Chuong Trinh Khuyen Mai !");
        }
    }

    //Hàm xóa Voucher
    public void deleteVoucher() {
        int count = 0;
        String idPromotionsUser = new Validate().checkStringUser("Nhap ma Chuong Trinh Khuyen Mai");
        for (int i = 0; i < totalPromotionsSale; i++) {
            if ((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)) {
                listPromotionsSale[i].deleteVoucher();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay Chuong Trinh Khuyen Mai !");
        }
    }


    //Hàm lấy giá trị tiền giảm
    public int transMoneyDiscount(String idPromotions, String idVoucher, Date printDate) {

        int count = 0;
        for (int i = 0; i < totalPromotionsSale; i++) {
            if (idPromotions.equals(listPromotionsSale[i].getidPromotions())) {
                if (((listPromotionsSale[i].getstartDate()).after(printDate)) || ((listPromotionsSale[i].getendDate()).before(printDate))) {
                    count++;
                } else {
                    return listPromotionsSale[i].TransVoucher(idVoucher);
                }
            }
        }
        if (count != 0) {
            System.out.println("Mã giảm giá hết hạn sử dụng !");
        }
        return 0;
    }


    @Override
    public void writeData() {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (PromotionsSale x : listPromotionsSale) {
                bufferedWriter.write(x.printToFile());
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
        }
    }


    @Override
    public void readData() {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean check = true;
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("\\|");
                String namePromotions = split[0];
                String idPromotions = split[1];
                Date startDate = df.parse(split[2]);
                Date endDate = df.parse(split[3]);
                String idVoucher = split[4];
                int moneyDiscount = Integer.parseInt(split[5]);
                if (check) {
                    listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
                    listPromotionsSale[totalPromotionsSale] = new PromotionsSale(namePromotions, idPromotions, startDate, endDate);
                    listPromotionsSale[totalPromotionsSale].insertVoucher(idVoucher, moneyDiscount);
                    totalPromotionsSale++;
                    check = false;
                } else {
                    if (idPromotions.equals(listPromotionsSale[totalPromotionsSale - 1].getidPromotions())) {
                        listPromotionsSale[totalPromotionsSale - 1].insertVoucher(idVoucher, moneyDiscount);
                    } else {
                        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
                        listPromotionsSale[totalPromotionsSale] = new PromotionsSale(namePromotions, idPromotions, startDate, endDate);
                        listPromotionsSale[totalPromotionsSale].insertVoucher(idVoucher, moneyDiscount);
                        totalPromotionsSale++;
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
    }

    // Thống kê mã khuyến mãi
    public void reportPromotion() {
        System.out.format("%-25s %-15s %-15s \n", "Tên chương trình", "Số lượng", "Tổng tiền giảm");
        for (int i = 0; i < totalPromotionsSale; i++) {
            System.out.format("%-25s %-15s %-15s \n", listPromotionsSale[i].getnamePromotions(), listPromotionsSale[i].getTotalVoucher(), listPromotionsSale[i].getTotalMoneyOfPromotionSale());
        }
        String choice;
        do {
            System.out.println("=====================================");
            choice = new Validate().checkStringUser("Xem chi tiết mã khuyến mãi (y/n)");
            if (choice.charAt(0) == 'y') {
                print();
                System.out.println("=====================================");
                System.out.println("Thống kê thành công !!!");
                break;
            } else if (choice.charAt(0) == 'n') {
                System.out.println("Từ chối xem chương trình khuyến mãi !!!");
                break;
            } else {
                System.out.println("Nhập sai định dạng !!!");
            }
        } while (true);
    }
}
