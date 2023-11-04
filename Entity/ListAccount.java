package DoAnOOP.Entity;

import java.util.Scanner;

public class listAccount {
    public static Scanner sc = new Scanner(System.in);
    private int countStaff;// số lượng tài khoản nhân viên
    private int countCustomer;// số lượng tài khoản khách hàng
    private accountStaff[] arrayAccountStaff;// mảng số lượng tài khoản nhân viên
    private accountCustomer[] arrayAccountCustomer;// mảng số lượng tài khoản khách hàng

    public listAccount() {
        this.countStaff = 0;
        this.countCustomer = 0;
        this.arrayAccountStaff = new accountStaff[countStaff];
        this.arrayAccountCustomer = new accountCustomer[countCustomer];
    }

    public listAccount(int countStaff, int countCustomer, accountStaff[] arrayAccountStaff, accountCustomer[] arrayAccountCustomer) {
        this.countStaff = countStaff;
        this.countCustomer = countCustomer;
        this.arrayAccountStaff = arrayAccountStaff;
        this.arrayAccountCustomer = arrayAccountCustomer;
    }

    public void loginAccount() {
        System.out.println("Nhập tài khoản: ");
        String userName = sc.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String userPassword = sc.nextLine();
        int check = 0;
        accountCustomer currenCustomer = null;
        accountStaff currentStaff = null;
        for (accountCustomer customer : arrayAccountCustomer) {
            if (userName.equals(customer.idAccount) && userPassword.equals(customer.password)) {
                System.out.println("Đăng nhập thành công tài khoản khách hàng");
                check = 1;
                currenCustomer = customer; // đánh dấu tài khoản khách hàng hiện tại
                break;
            }
        }
        for (accountStaff staff : arrayAccountStaff) {
            if (userName.equals(staff.idAccount) && userPassword.equals(staff.password)) {
                System.out.println("Đăng nhập thành công tài khoản nhân viên");
                check = 2;
                currentStaff = staff; // đánh dấu tài khoản nhân viên hiện tại
                break;
            }
        }
        if (check == 0) {
            System.out.println("Tài khoản hoặc mật khẩu bị sai, hoặc bạn chưa có tài khoản vui lòng tạo tài khoản");
        }
        if (check == 1) {
            changeAccountCustomer(currenCustomer);
        }

        if (check == 2) {
            changeAccountStaff(currentStaff);
        }
    }

    public void createAccount() {
        System.out.println("Bạn muốn tạo tài khoản dành cho khách hàng hay nhân viên:");
        System.out.println("1.Khách hàng");
        System.out.println("2.Nhân viên");
        int choice;
        choice = sc.nextInt();
        while (choice < 1 || choice > 2) {
            System.out.println("Vui lòng chọn đúng yêu cầu");
            choice = sc.nextInt();
        }
        sc.nextLine();
        if (choice == 1) {
            System.out.println("NHẬP THÔNG TIN TÀI KHOẢN KHÁCH HÀNG");
            if (countCustomer == arrayAccountCustomer.length) {
                accountCustomer[] newAccountCustomer = new accountCustomer[arrayAccountCustomer.length + 1];
                for (int i = 0; i < countCustomer; i++) {
                    newAccountCustomer[i] = arrayAccountCustomer[i];
                }
                arrayAccountCustomer = newAccountCustomer;
            }
            accountCustomer newCustomer = new accountCustomer();
            boolean check = false;
            do {
                newCustomer.inputAccount();
                check = true;
                if (!checkUserName(newCustomer.idAccount)) {
                    System.out.println("Tên tài khoản của bạn đã trùng với người khác vui lòng nhập lại thông tin!");
                    check = false;
                }
            } while (!check);
            arrayAccountCustomer[countCustomer] = newCustomer;
            countCustomer++;
        }
        if (choice == 2) {
            System.out.println("NHẬP THÔNG TIN TÀI KHOẢN NHÂN VIÊN");
            if (countStaff == arrayAccountStaff.length) {
                accountStaff[] newAccountStaff = new accountStaff[arrayAccountStaff.length + 1];
                for (int i = 0; i < countStaff; i++) {
                    newAccountStaff[i] = arrayAccountStaff[i];
                }
                arrayAccountStaff = newAccountStaff;
            }
            accountStaff newStaff = new accountStaff();
            boolean check = false;
            do {
                newStaff.inputAccount();
                check = true;
                if (!checkUserName(newStaff.idAccount)) {
                    System.out.println("Tên tài khoản của bạn đã trùng với người khác vui lòng nhập lại thông tin!");
                    check = false;
                }
            } while (!check);
            arrayAccountStaff[countStaff] = newStaff;
            countStaff++;
        }
    }

    public boolean checkUserName(String idAccount) {
        for (int i = 0; i < countStaff; i++)
            if (idAccount.equals(arrayAccountStaff[i].idAccount))
                return false;
        for (int i = 0; i < countCustomer; i++)
            if (idAccount.equals(arrayAccountCustomer[i].idAccount))
                return false;
        return true;
    }

    public void changeAccountCustomer(accountCustomer currentCustomer) {
        int option;
        do {
            System.out.println("----------TÀI KHOẢN KHÁCH HÀNG----------");
            System.out.println("1.Thay đổi thông tin cá nhân");
            System.out.println("2.Nạp thêm tiền vào tài khoản");
            System.out.println("3.Xem thông tin tài khoản");
            System.out.println("0.Đăng xuất");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    changeInfoCustomer(currentCustomer);
                    break;
                case 2:
                    addMoney(currentCustomer);
                    break;
                case 3:
                    viewCustomer(currentCustomer);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("----------VUI LÒNG CHỌN ĐÚNG YÊU CẦU----------");
                    System.out.println();
            }
        } while (option != 0);
        System.out.println("----------ĐĂNG XUẤT TÀI KHOẢN KHÁCH HÀNG THÀNH CÔNG----------");
        System.out.println();
    }

    public void addMoney(accountCustomer currentCustomer) {
        System.out.println("Nhập số tiền bạn muốn thêm:");
        double newMoney = sc.nextDouble();
        currentCustomer.surplusAccount += newMoney;
        System.out.println("----------ĐÃ NẠP THÊM TIỀN VÀO TÀI KHOẢN THÀNH CÔNG----------");
    }

    public void changeInfoCustomer(accountCustomer currentCustomer) {
        int option;
        do {
            System.out.println("----------THAY ĐỔI THÔNG TIN KHÁCH HÀNG----------");
            System.out.println("1.Thay đổi tên đăng nhập");
            System.out.println("2.Thay đổi mật khẩu");
            System.out.println("3.Thay đổi mã định danh");
            System.out.println("4.Thay đổi họ và tên");
            System.out.println("5.Thay đổi giới tính");
            System.out.println("6.Thay đổi địa chỉ");
            System.out.println("7.Thay đổi số điện thoại");
            System.out.println("0.Quay lại");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    boolean check = false;
                    String newUserName;
                    do {
                        System.out.println("Nhập tên đăng nhập mới:");
                        newUserName = sc.nextLine();
                        check = checkUserName(newUserName);
                        if (!check) {
                            System.out.println("Tên tài khoản của bạn đã trùng với người khác vui lòng nhập lại tên!");
                            check = false;
                        }
                    } while (!check);
                    currentCustomer.idAccount = newUserName;
                    System.out.println("----------THAY ĐỔI TÊN KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 2:
                    System.out.println("Nhập mật khẩu mới:");
                    String newPassword = sc.nextLine();
                    currentCustomer.password = newPassword;
                    System.out.println("----------THAY ĐỔI MẬT KHẨU KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 3:
                    System.out.println("Nhập mã định danh mới:");
                    String newIdentifier = sc.nextLine();
                    currentCustomer.identifier = newIdentifier;
                    System.out.println("----------THAY ĐỔI MÃ ĐỊNH DANH KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 4:
                    System.out.println("Nhập họ và tên mới:");
                    String newName = sc.nextLine();
                    currentCustomer.name = newName;
                    System.out.println("----------THAY ĐỔI HỌ VÀ TÊN KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 5:
                    System.out.println("Nhập giới tính mới:");
                    String newGender = sc.nextLine();
                    currentCustomer.gender = newGender;
                    System.out.println("----------THAY ĐỔI GIỚI TÍNH KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 6:
                    System.out.println("Nhập địa chỉ mới:");
                    String newAddress = sc.nextLine();
                    currentCustomer.address = newAddress;
                    System.out.println("----------THAY ĐỔI ĐỊA CHỈ KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 7:
                    System.out.println("Nhập số điện thoại mới:");
                    Long newPhoneNumber = sc.nextLong();
                    currentCustomer.phoneNumber = newPhoneNumber;
                    System.out.println("----------THAY ĐỔI SỐ ĐIỆN THOẠI KHÁCH HÀNG THÀNH CÔNG----------");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("----------VUI LÒNG CHỌN ĐÚNG YÊU CẦU----------");
                    System.out.println();
            }
        } while (option != 0);
    }

    public void changeAccountStaff(accountStaff currentStaff) {
        int option;
        do {
            System.out.println("----------TÀI KHOẢN NHÂN VIÊN----------");
            System.out.println("1.Xem danh sách khách hàng");
            System.out.println("2.Thay đổi thông tin cá nhân");
            System.out.println("3.Xem thông tin cá nhân");
            System.out.println("4.Thay đổi lương cá nhân");
            System.out.println("0.Đăng xuất");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    viewListCustomer();
                    break;
                case 2:
                    changeInforStaff(currentStaff);
                    break;
                case 3:
                    viewStaff(currentStaff);
                    break;
                case 4:
                    calcPay(currentStaff);
                case 0:
                    break;
                default:
                    System.out.println("----------VUI LÒNG CHỌN ĐÚNG YÊU CẦU----------");
                    System.out.println();
            }
        } while (option != 0);
        System.out.println("----------ĐĂNG XUẤT TÀI KHOẢN NHÂN VIÊN THÀNH CÔNG----------");
        System.out.println();
    }

    public void calcPay(accountStaff currentStaff) {
        System.out.println("Vui lòng nhập lại thời gian bạn đã làm việc trung bình 1 ngày trong 1 tháng");
        currentStaff.setWorktime(sc.nextDouble());
        currentStaff.wage = currentStaff.worktime * 25 * 30;
        System.out.println("----------LƯƠNG CỦA NHÂN VIÊN ĐÃ THAY ĐỔI THÀNH CÔNG----------");
    }

    public void viewCustomer(accountCustomer currentCustomer) {
        System.out.println("----------THÔNG TIN KHÁCH HÀNG----------");
        System.out.format("%-15s %-12s %-12s %-15s %-6s %-15s %-15s %-15s", "USERNAME", "PASSWORD", "IDENTIFIER",
                "FULLNAME", "GENDER", "ADDRESS", "PHONENUMBER", "SURPLUS");
        System.out.println();
        System.out.format("%-15s %-12s %-12s %-15s %-6s %-15s %-15s %-15s", currentCustomer.idAccount, currentCustomer.password,
                currentCustomer.identifier, currentCustomer.name, currentCustomer.gender, currentCustomer.address,
                currentCustomer.phoneNumber, currentCustomer.surplusAccount + "VNĐ");
        System.out.println();
    }

    public void viewStaff(accountStaff currentStaff) {
        System.out.println("----------THÔNG TIN NHÂN VIÊN----------");
        System.out.format("%-15s %-12s %-12s %-15s %-6s %-15s %-11s %-15s %-15s", "USERNAME", "PASSWORD", "IDENTIFIER",
                "FULLNAME", "GENDER", "ADDRESS", "PHONENUMBER", "WORKTIME", "WAGE");
        System.out.println();
        System.out.format("%-15s %-12s %-12s %-15s %-6s %-15s %-11s %-15s %-15s", currentStaff.idAccount, currentStaff.password,
                currentStaff.identifier, currentStaff.name, currentStaff.gender, currentStaff.address,
                currentStaff.phoneNumber, currentStaff.worktime + "/24h", currentStaff.wage + "VNĐ");
        System.out.println();
    }

    public void viewListCustomer() {
        System.out.println("----------DANH SÁCH THÔNG TIN KH" +
                "ÁCH HÀNG----------");
        System.out.format("%-15s %-12s %-15s %-15s %-15s %-15s %-20s", "USERNAME", "IDENTIFIER",
                "FULLNAME", "GENDER", "ADDRESS", "PHONENUMBER", "SURPLUS");
        System.out.println();
        for (accountCustomer customer : arrayAccountCustomer) {
            System.out.format("%-15s %-12s %-15s %-15s %-15s %-15s %-20s", customer.idAccount, customer.identifier,
                    customer.name, customer.gender, customer.address, customer.phoneNumber, customer.surplusAccount + "VNĐ");
            System.out.println();
        }
    }

    public void changeInforStaff(accountStaff currentStaff) {
        int option;
        do {
            System.out.println("----------THAY ĐỔI THÔNG TIN NHÂN VIÊN----------");
            System.out.println("1.Thay đổi tên đăng nhập");
            System.out.println("2.Thay đổi mật khẩu");
            System.out.println("3.Thay đổi mã định danh");
            System.out.println("4.Thay đổi họ và tên");
            System.out.println("5.Thay đổi giới tính");
            System.out.println("6.Thay đổi địa chỉ");
            System.out.println("7.Thay đổi số điện thoại");
            System.out.println("0.Quay lại");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    boolean check = false;
                    String newUserName;
                    do {
                        System.out.println("Nhập tên đăng nhập mới:");
                        newUserName = sc.nextLine();
                        check = checkUserName(newUserName);
                        if (!check) {
                            System.out.println("Tên tài khoản của bạn đã trùng với người khác vui lòng nhập lại tên!");
                            check = false;
                        }
                    } while (!check);
                    currentStaff.idAccount = newUserName;
                    System.out.println("----------THAY ĐỔI TÊN NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 2:
                    System.out.println("Nhập mật khẩu mới:");
                    String newPassword = sc.nextLine();
                    currentStaff.password = newPassword;
                    System.out.println("----------THAY ĐỔI MẬT KHẨU NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 3:
                    System.out.println("Nhập mã định danh mới:");
                    String newIdentifier = sc.nextLine();
                    currentStaff.identifier = newIdentifier;
                    System.out.println("----------THAY ĐỔI MÃ ĐỊNH DANH NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 4:
                    System.out.println("Nhập họ và tên mới:");
                    String newName = sc.nextLine();
                    currentStaff.name = newName;
                    System.out.println("----------THAY ĐỔI HỌ VÀ TÊN NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 5:
                    System.out.println("Nhập giới tính mới:");
                    String newGender = sc.nextLine();
                    currentStaff.gender = newGender;
                    System.out.println("----------THAY ĐỔI GIỚI TÍNH NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 6:
                    System.out.println("Nhập địa chỉ mới:");
                    String newAddress = sc.nextLine();
                    currentStaff.address = newAddress;
                    System.out.println("----------THAY ĐỔI ĐỊA CHỈ NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 7:
                    System.out.println("Nhập số điện thoại mới:");
                    Long newPhoneNumber = sc.nextLong();
                    currentStaff.phoneNumber = newPhoneNumber;
                    System.out.println("----------THAY ĐỔI SỐ ĐIỆN THOẠI NHÂN VIÊN THÀNH CÔNG----------");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("----------VUI LÒNG CHỌN ĐÚNG YÊU CẦU----------");
                    System.out.println();
            }
        } while (option != 0);
    }

    public void menu() {
        int option;
        do {
            System.out.println("----------HỆ THỐNG QUẢN LÝ TÀI KHOẢN----------");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Tạo tài khoản");
            System.out.println("0.Quay lại");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 0:
                    break;
                case 1:
                    loginAccount();
                    break;
                case 2:
                    createAccount();
                    break;
                default:
                    System.out.println("----------VUI LÒNG CHỌN ĐÚNG YÊU CẦU----------");
                    System.out.println();
            }
        } while (option != 0);
        System.out.println("----------CẢM ƠN ĐÃ SỬ DỤNG HỆ THỐNG----------");
    }

    public static void main(String[] args) {
        listAccount listAccounts = new listAccount();
        listAccounts.menu();
        sc.close();
    }
}
