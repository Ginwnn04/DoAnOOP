package DoAnOOP.Manager;

import DoAnOOP.Manager.Validate;
import DoAnOOP.Entity.Voucher;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ListVoucher {
    int totalVoucher;
    Voucher voucher[]= new Voucher[1];

    public ListVoucher(){}

    public ListVoucher(int totalVoucher, ListVoucher voucher[]){
        this.totalVoucher=totalVoucher;
    }

    public Voucher[] getvoucher() {
        return voucher;
    }

    public void input(){
        totalVoucher=new Validate().checkNumberInput("Số voucher cần tạo", "Số voucher > 0, vui lòng nhập lại");
        voucher=new Voucher[totalVoucher];
        for(int i=0;i<totalVoucher;i++){
        System.out.println("\n\nNhập voucher thứ "+(i+1));
        voucher[i]= new Voucher();
        voucher[i].input();
        }
    }

    public void addVoucher(){
        voucher = Arrays.copyOf(voucher, totalVoucher+1);
        voucher[totalVoucher]=new Voucher();
        voucher[totalVoucher].input();
        totalVoucher++;
    }

    public void deleteVoucher(){
        String a=new Validate().checkStringUser("Nhập mã voucher cần xóa ");
        for(int i=0;i<totalVoucher;i++){
            if((voucher[i].getidVoucher()).equals(a)){
                totalVoucher--;
               for(int j=i; j<totalVoucher; j++){
			   voucher[j] = voucher[j+1];
               }
            }
        }
    }

    public Voucher findVoucher(String idVoucherUser){
        for (int i = 0; i < totalVoucher; i++) {
            if (voucher[i].getidVoucher().equals(idVoucherUser)) {
                return voucher[i];
                } 
            }
             return null; 
    }

    public void print(){
        System.out.println("\n-----------KHUYẾN MÃI -----------");
        for(int i=0;i<totalVoucher;i++){
            System.out.println("\nVoucher thứ  "+(i+1));
            voucher[i].print();
        }
    }

    public void writeFile() throws IOException{
        DataOutputStream outStream = new DataOutputStream(new FileOutputStream("voucher.txt"));
        for( int i = 0 ; i < totalVoucher ; i++){
            voucher[i].writeFile();
        }
        outStream.close();
    }

    public void readFile(){               
        int i=0;        
        try {                
            DataInputStream inStream= new DataInputStream(new FileInputStream("voucher.txt"));             
                try            {                
                    while (true){//xin cap phat them                    
                        voucher[i]= new Voucher();                    								
                        voucher[i].setidvoucher(inStream.readUTF());                        						
                        voucher[i].setmoneyDiscount(inStream.readFloat());                      						
                        voucher[i].setstartDate(inStream.readUTF());       
                        voucher[i].setendDate(inStream.readUTF());                 						
                        //voucher[i].print();                   
                        i++;                } // while                            	
                    }catch(EOFException  e) {}    // Close the stream            
                    finally{                
                        totalVoucher=i;                	
                        inStream.close();            
                    }        
                }
            catch (IOException e) {}     
    }    

    public Voucher getVoucherByCode(String idVoucher) {
        for (Voucher voucher : voucher) {
            if (voucher != null && voucher.getidVoucher().equals(idVoucher)) {
                return voucher;
            }
        }
        return null;
    }
}
