package DoAnOOP.Manager;
import DoAnOOP.Entity.PromotionsSale;
import DoAnOOP.Entity.ServiceFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ListPromotionsSale implements ServiceFile{
    public PromotionsSale[] listPromotionsSale;
    public int totalPromotionsSale;

    public ListPromotionsSale() {
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
    }

    public ListPromotionsSale(ListPromotionsSale x) {
        this.listPromotionsSale = x.listPromotionsSale;
        this.totalPromotionsSale = x.totalPromotionsSale;
    }
    public ListPromotionsSale(String namePromotions, String idPromotions, String startDate, String endDate) {}

    public void input(){
        totalPromotionsSale = new Validate().checkNumberInput("So CTKM can tao\n", "Sai");
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
        for(int i=0;i<totalPromotionsSale;i++){
            listPromotionsSale[i]=new PromotionsSale();
            listPromotionsSale[i].input();
        }
    }

    public void print(){
        for(int i=0;i<totalPromotionsSale;i++){
            listPromotionsSale[i].print();
        }
    }

    public void addPromotionsSale(){
        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale+1);
        listPromotionsSale[totalPromotionsSale]=new PromotionsSale();
        listPromotionsSale[totalPromotionsSale].input();
        totalPromotionsSale++;
        System.out.println("Them CTKM thanh cong !");
    }

    public void deletePromotionsSale(){
        String idPromotionUser=new Validate().checkStringUser("Nhập ma CTKM cần xóa");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getidPromotions()).equals(idPromotionUser)){
                totalPromotionsSale--;
               for(int j=i; j<totalPromotionsSale; j++){
			   listPromotionsSale[j] = listPromotionsSale[j+1];
               } 
               System.out.println("Xoa CTKM thanh cong !");
            }
            else{
                System.out.println("Khong tim thay CTKM ");
            }
        }
    }

    public void findVoucher(){
        int count=0;
        String idPromotionsUser=new Validate().checkStringUser("\nNhập ma CTKM cần tìm");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)){
                listPromotionsSale[i].findVoucher();
                count++;
            }
        }
        if(count==0){
            System.out.println("Khong tim thay CTKM !");
        }
    }

    public void findPromotions(){
        int count=0;
        String idPromotionsUser=new Validate().checkStringUser("\nNhập ma CTKM cua voucher cần tìm");
        for(int i=0;i<totalPromotionsSale;i++){
            if((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)){
                listPromotionsSale[i].print();
                count++;
            }
        }
        if(count==0){
            System.out.println("Khong tim thay CTKM !");
        }
    }

    public void fixPromotions(){
        int count = 0;
        System.out.println("1.Thay doi ten Chuong Trinh Khuyen Mai.");
        System.out.println("2.Them voucher vao Chuong Trinh Khuyen Mai.");
        System.out.println("3.Xoa bot voucher khoi Chuong Trinh Khuyen Mai.");
        int chon = new Validate().checkNumberInput("Nhap lua chon","So phai > 0, Vui long nhap lai !");
        String idPromotionsUser = new Validate().checkStringUser("Nhap ma Chuong Trinh Khuyen Mai muon thay doi");
        switch (chon) {
            case 1:{
                String namePromotions = new Validate().checkStringUser("Nhap ten thay doi");
                for( int i = 0 ; i < totalPromotionsSale ; i++ ){
                    if(idPromotionsUser.equals((listPromotionsSale[i]).getidPromotions())){
                        listPromotionsSale[i].setidPromotions(namePromotions);
                        System.out.println("Thay doi ten thanh cong !");
                        count++;
                    }
                }
                if(count == 0){
                    System.out.println("Khong tim thay Chuong Trinh Khuyen Mai !");
                }
            }break;
            case 2:{
                for( int i = 0 ; i < totalPromotionsSale ; i++ ){
                    if((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)){
                        listPromotionsSale[i].addVoucher();
                        count++;
                        System.out.println("Thay doi thanh cong !");
                    }
                }
                if(count==0){
                    System.out.println("Khong tim thay Chuong Trinh Khuyen Mai !");
                }
            }break;
            case 3:{
                for(int i = 0 ; i < totalPromotionsSale ; i++ ){
                    if((listPromotionsSale[i].getidPromotions()).equals(idPromotionsUser)){
                    listPromotionsSale[i].deleteVoucher();  
                    }
                }
            }break;
            default:
                break;
        }
    }

    @Override
    public void resetData() {
        totalPromotionsSale = 0;
        listPromotionsSale = new PromotionsSale[totalPromotionsSale];
    }

    @Override
    public void writeData(boolean flag) {
        try {
            FileWriter fileWriter = new FileWriter("Voucher.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
            for(PromotionsSale x : listPromotionsSale){
                bufferedWriter.write(x.printToFile());
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
        }
        resetData();
        System.out.println("Luu file thanh cong !");
    }

    @Override
    public void readData() {
        try {
            FileReader fileReader = new FileReader("Voucher.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean check = true;
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                String[] split = line.split("\\|");
                String namePromotions = split[0];
                String idPromotions = split[1];
                String startDate = split[2];
                String endDate = split[3];
                String idVoucher = split[4]; 
                int moneyDiscount = Integer.parseInt(split[5]);
                if (check) {
                    listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
                    listPromotionsSale[totalPromotionsSale] = new PromotionsSale(namePromotions,idPromotions,startDate,endDate);
                    listPromotionsSale[totalPromotionsSale].insertVoucher(idVoucher,moneyDiscount);
                    totalPromotionsSale++;
                    check = false;
                }
                else{
                    if (idPromotions.equals(listPromotionsSale[totalPromotionsSale-1].getidPromotions())) {
                        listPromotionsSale[totalPromotionsSale-1].insertVoucher(idVoucher,moneyDiscount);
                    }
                    else {
                        listPromotionsSale = Arrays.copyOf(listPromotionsSale, totalPromotionsSale + 1);
                        listPromotionsSale[totalPromotionsSale] = new PromotionsSale(namePromotions,idPromotions,startDate,endDate);
                        listPromotionsSale[totalPromotionsSale].insertVoucher(idVoucher,moneyDiscount);
                        totalPromotionsSale++;
                    }
                }
            }
            bufferedReader.close();
        }
        catch (Exception e) {
        }
        }

}
