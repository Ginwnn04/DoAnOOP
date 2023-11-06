package MyOOP.Entity;
public class Employee {
    private String idEmployee;
    private String fullName;

    public Employee() {
        this.idEmployee = "";
        this.fullName = "";
    }

    public Employee(String idEmployee, String fullName) {
        this.idEmployee = idEmployee;
        this.fullName = fullName;
    }
}
