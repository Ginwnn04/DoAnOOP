package DoAnOOP.Manager;


import DoAnOOP.Entity.Customer;

public class Main {
    public static void main(String[] args) {
//        new Menu().printMenuEmployee();
        ListCustomer l = new ListCustomer();
        l.createCustomer();
        l.createCustomer();
        l.createCustomer();
        l.printCustomer();
        l.writeData(true);

        ListCustomer s = new ListCustomer();
        s.readData();
        s.printCustomer();


    }

}