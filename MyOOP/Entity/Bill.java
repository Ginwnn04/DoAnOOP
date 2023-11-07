package MyOOP.Entity;
import java.util.Arrays;
import MyOOP.Manager.Validate;
public class Bill {
    String idBill;
    String idEmployee;
    String idCustomer;
    String nameCustomer;
    String printDate;
    String namePromotion;
    String idVoucher;

    int n;
    detailBill dsdb[]= new detailBill[1];
    Voucher dsvc[]= new Voucher[n];
    PromotionsSale dskm[]= new PromotionsSale[n];

    public Bill(){
        this.idBill="";
        this.idEmployee="";
        this.idCustomer="";
        this.nameCustomer="";
        this.printDate="";
        this.namePromotion="";
        this.idVoucher="";
    }

    public Bill (String idBill, String idEmployee, String idCustomer, String nameCustomer, float totalBill, String printDate,String namePromotion, String idVoucher){
        this.idBill=idBill;
        this.idEmployee=idEmployee;
        this.idCustomer=idCustomer;
        this.nameCustomer=nameCustomer;
        this.printDate=printDate;
        this.namePromotion=namePromotion;
        this.idVoucher=idVoucher;

    }

    public String getidBill(){
        return idBill;
    }
    public void setidBill(String idBill){
        this.idBill=idBill;
    }

    public String getidEmployee(){
        return idEmployee;
    }
    public void setidEmployee(String idEmployee){
        this.idEmployee=idEmployee;
    }

    public String getidCustomer(){
        return idCustomer;
    }
    public void setidCustomer(String idCustomer){
        this.idCustomer=idCustomer;
    }

    public String getnameCustomer(){
        return nameCustomer;
    }
    public void setnameCustomer(String nameCustomer){
        this.nameCustomer=nameCustomer;
    }

    public String getprintDate(){
        return idBill;
    }
    public void setprintDate(String printDate){
        this.printDate=printDate;
    }

    public String getnamePromotion(){
        return namePromotion;
    }
    public void setnamePromotion(String namePromotion){
        this.namePromotion=namePromotion;
    }

    public String getidVoucher(){
        return idVoucher;
    }
    public void setidVoucher(String idVoucher){
        this.idVoucher=idVoucher;
    }

    public String taoidBill(){
        String firtID="HD";
        return firtID+"-"+(int)(Math.random()*10000000);
    }

     public void nhap(){
        printDate = new Validate().checkStringUser("\nNhập ngày in hóa đơn");
        idBill = taoidBill();
        idEmployee = new Validate().checkStringUser("Nhập mã nhân viên");
        idCustomer = new Validate().checkStringUser("Nhập mã khách hàng");
        nameCustomer = new Validate().checkStringUser("Nhập tên khách hàng");
        System.out.println("Nhap chi tiet hoa don.");
        n = new Validate().checkIntUser("Số chi tiết hóa đơn");
            dsdb=new detailBill[n];
            for(int i=0;i<n;i++){
                    System.out.println("\nNhập chi tiết sản phẩm thứ "+(i+1));
                    dsdb[i]= new detailBill();
                    dsdb[i].nhap();
                }
    }

    public float total(){
        int total=0;
        for(int i=0;i<n;i++){
            total+=dsdb[i].total();
        }
        return total;
    }

    public void moneyOff(){
        float moneyOff=0;
        float totalBill=0;
        String chon = new Validate().checkStringUser("Khách hàng có sử dụng voucher hay không ? (y/n)");
        if(chon.equals("y")){
            namePromotion=new Validate().checkStringUser("Nhập tên chương trình khuyến mãi");
              for(int i=0;i<dskm.length;i++){
                if((dskm[i].getnamePromotion())==namePromotion){
                    idVoucher=new Validate().checkStringUser("Nhập mã voucher");
                    for(int j=0;j<n;j++){
                        if((dsvc[j].getidVoucher())==idVoucher){
                            moneyOff=(dsvc[j].getdiscountRate()/100)*total();
                        }
                    }
                }
            }
        }
                totalBill=total()-moneyOff;
                System.out.println("Tiền giảm : "+moneyOff);
                System.out.println("Tiền cần thanh toán : "+totalBill);
    }

    public void chitiet(){
        System.out.println("\n------CHI TIẾT HÓA ĐƠN "+idBill+"------");
        for(int i=0;i<n;i++){
            dsdb[i].xuat();
        }
    }


    public void themchitiet(){
        dsdb = Arrays.copyOf(dsdb, n+1);
                dsdb[n]=new detailBill();
                dsdb[n].nhap();
                n++;
    }


    public void xoachitiet(){
        String a= new Validate().checkStringUser("Nhập mã sản phẩm cần xóa của hóa đơn "+idBill+" : ");
        for(int i=0;i<n;i++){
            if((dsdb[i].getidProduct()).equals(a)){
                n--;
               for(int j=i; j<n; j++){
			   dsdb[j] = dsdb[j+1];
               }
            }
        }
    }

    public void xuat(){
        System.out.println("\nNgày in hóa đơn : "+printDate);
        System.out.println("Mã hóa đơn : "+idBill);
        System.out.println("Nhân viên in hóa đơn: "+idEmployee);
        System.out.println("Mã khách hàng : "+idCustomer);
        System.out.println("Tên khách hàng : "+nameCustomer);
        for(int i=0;i<n;i++){
            dsdb[i].xuat();
        }
        System.out.println("Tổng tiền : "+total());
    }
}
