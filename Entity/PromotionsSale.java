package DoAnOOP.Entity;
import DoAnOOP.Manager.Validate;
import DoAnOOP.Entity.ServiceFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class PromotionsSale {
    private String namePromotions;
    private String idPromotions;
    private String startDate;
    private String endDate;

    int totalVoucher=0;
    Voucher[] voucher= new Voucher[totalVoucher];

    public PromotionsSale() {
    }

    public PromotionsSale(String namePromotions, String idPromotions, String startDate, String endDate) {
        this.namePromotions = namePromotions;
        this.idPromotions = idPromotions;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getnamePromotions(){
        return namePromotions;
    }
    public void setnamePromotions(String namePromotions){
        this.namePromotions=namePromotions;
    }

    public String getidPromotions(){
        return idPromotions;
    }
    public void setidPromotions(String idPromotions){
        this.idPromotions=idPromotions;
    }

    public String getstartDate(){
        return startDate;
    }
    public void setstartDate(String startDate){
        this.startDate=startDate;
    }

    public String getendDate(){
        return endDate;
    }
    public void setendDate(String endDate){
        this.endDate=endDate;
    }

    public String createIdPromotions(){
        String idPromotions="KM"+"-"+ (int)(Math.random()*10000);
        return idPromotions;
    }

    public void input(){
        idPromotions = createIdPromotions();
        System.out.println(idPromotions);
        namePromotions = new Validate().checkStringUser("Nhập tên chương trình khuyến mãi");
        startDate = new Validate().checkStringUser("Nhập ngày bắt đầu");
        endDate = new Validate().checkStringUser("Nhập kết thúc");
        totalVoucher = new Validate().checkNumberInput("Số voucher cần tạo", "Số voucher > 0, ui long nhập lại !");
        voucher = new Voucher[totalVoucher];
        for(int i = 0 ; i < totalVoucher ; i++ ){
            voucher[i]= new Voucher();
            voucher[i].input();
        }
    }

    public void print(){
        System.out.println("\n-------------KHUYẾN MÃI "+namePromotions+" ("+idPromotions+") từ "+startDate+" đến "+endDate+" -----------");
        for(int i=0;i<totalVoucher;i++){
            System.out.println("\nVoucher thứ  "+(i+1));
            voucher[i].print();
        }
    }

    public void checkIdVoucher(String idVoucher){
        //
    }

    public void addVoucher(){
        int quantityVoucher = new Validate().checkNumberInput("So voucher muon them", "So phia >0, vui long nhap lai !");
        for(int i = 0 ; i < quantityVoucher ; i++) {
        voucher = Arrays.copyOf(voucher, totalVoucher+1);
                voucher[totalVoucher]=new Voucher();
                voucher[totalVoucher].input();
                totalVoucher++;
        }
        System.out.println("Thêm voucher thành công !");
    }

    public void deleteVoucher(){
        int count = 0;
        String idVoucherUser=new Validate().checkStringUser("Nhập mã voucher cần xóa của CTKM "+namePromotions);
        for(int i=0;i<totalVoucher;i++){
            if((voucher[i].getidVoucher()).equals(idVoucherUser)){
                totalVoucher--;
               for(int j=i; j<totalVoucher; j++){
			   voucher[j] = voucher[j+1];
               }
               count++;
               System.out.println("Xóa voucher thành công !");
            }
        }
        if(count==0){
            System.out.println("Không tìm thấy voucher !");
        }
    }

    public void findVoucher(){
        int count=0;
        String idVoucherUser=new Validate().checkStringUser("\nNhập mã voucher cần tìm");
        for(int i=0;i<totalVoucher;i++){
            if((voucher[i].getidVoucher()).equals(idVoucherUser)){
                voucher[i].print();
                count++;
            }
        }
        if(count==0){
            System.out.println("Không tìm thấy voucher !");
        }
    }

    public void insertVoucher(String idVoucher, int moneyDiscount) {
        voucher = Arrays.copyOf(voucher, totalVoucher + 1);
        voucher[totalVoucher] = new Voucher(idVoucher,moneyDiscount);
        totalVoucher ++;
    }

    public String printToFile() {
        String result = "";
        for (Voucher x : voucher) {
            result += namePromotions + "|" + idPromotions + "|" + startDate + "|" + endDate + "|" + x.printToFile();
        }
        return result;
    }

    public void readData() {
        try {
            FileReader fileReader = new FileReader("Voucher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while(true){
                line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                voucher = Arrays.copyOf(voucher, totalVoucher++ );
                String[] split = line.split("\\|");
                String idVoucher = split[4];
                int moneyDiscount = Integer.parseInt(split[5]);
                voucher[totalVoucher++] = new Voucher(idVoucher,moneyDiscount);
            }
            bufferedReader.close();
        } catch (Exception e) {
        }
    }
}
