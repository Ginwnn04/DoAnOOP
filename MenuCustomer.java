package Entiny;

import java.util.Scanner;

public class MenuCustomer {
    private static MenuCustomer listCustomer;

    public static void main(String[] args){
        ListCustomer listcustomer=new ListCustomer();
        Scanner scanner=new Scanner(System.in);
        int luachon;
        do{
            System.out.println("----------MENU----------");
            System.out.println("1.Thêm khách hàng");
            System.out.println("2.Sửa khách hàng");
            System.out.println("3.Xóa khách hàng");
            System.out.println("4.Tìm kiếm khách hàng theo mã khách hàng");
            System.out.println("0.Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            luachon=scanner.nextInt();
            scanner.nextLine();
            switch (luachon) {
                case 1:
                    listcustomer.AddCustomer();
                    break;
                case 2:
                    listcustomer.FixCustomer();
                    break;
                case 3:
                    listcustomer.DeleteCustomer();
                    break;
                case 4:
                    listcustomer.FindIdCustomer();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;                        
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                    break;
            }
        }while(luachon!=5);
    }
    private static void addCustomer() {
        scanner.nextLine(); 
        System.out.println("Nhập thông tin khách hàng:");
        listCustomer.AddCustomer();
        System.out.println("Thêm khách hàng thành công.");
    }

    private static void FixCustomer() {
        scanner.nextLine(); 
        System.out.print("Nhập id khách hàng cần sửa:");
        int result = listCustomer.FixCustomer();
        if (result == 1) {
            System.out.println("Sửa thông tin khách hàng thành công.");
        }
    }

    private static void DeleteCustomer() {
        scanner.nextLine(); 
        System.out.print("Nhập id khách hàng cần xóa:");
        listCustomer.DeleteCustomer();
        System.out.println("Xóa thông tin khách hàng thành công.");
    }

    private static void FindidCustomer() {
        scanner.nextLine(); 
        System.out.print("Nhập id khách hàng cần tìm:");
        Customer customer = listCustomer.FindidCustomer();
        if (!customer.getidCustomer().isEmpty()) {
            System.out.println("Khách hàng được tìm thấy: " + customer.toString());
        }
    }
}
