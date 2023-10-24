package DoAnOOP.Entity;

public class Foods extends Product{
    private String typeProduct;
    private float amount;

    public Foods() {
        super();
    }

    public Foods(String ID, String nameProduct, String unit, int quantity, String importDate, String productDate, int price, String typeProduct, float amount) {
        super(ID, nameProduct, unit, quantity, importDate, productDate, price);
        this.typeProduct = typeProduct;
        this.amount = amount;
    }

    @Override
    public void print() {
        int colSpace = 15;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "d %-"
                + colSpace + "s %-"
                + colSpace + "d\n", ID, nameProduct, amount + " gram" ,typeProduct , unit, quantity, productDate, price);
    }
}
