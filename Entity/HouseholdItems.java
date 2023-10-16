package Entity;

public class HouseholdItems extends Product{
    private String materialProduct;

    public HouseholdItems() {
        super();
    }

    public HouseholdItems(String ID, String nameProduct, String materialProduct, String unit, int quantity, String importDate, String productDate, int price) {
        super(ID, nameProduct, unit, quantity, importDate, productDate, price);
        this.materialProduct = materialProduct;
    }

    @Override
    public void print() {
        int colSpace = 15;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "d %-"
                + colSpace + "s %-"
                + colSpace + "d\n", ID, nameProduct, materialProduct , unit, quantity, productDate, price);
    }


}
