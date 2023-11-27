package DoAnOOP.Entity;

public class Customer {
    private String idCustomer;
    private String lastName;
    private String firstName;
    private String phone;

    public Customer(String fullName, String phone) {
        this.idCustomer = generateId();
        this.lastName = fullName.substring(0, fullName.lastIndexOf(" "));
        this.firstName = fullName.substring(fullName.lastIndexOf(" ") + 1);
        this.phone = phone;
    }

    public String generateId() {
        return "KH-" + (int)(Math.random() * 1000000);
    }

    public void show() {
        System.out.println(idCustomer + " " + lastName + " " + firstName + " " + phone + "\n");
    }
}
