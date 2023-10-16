package Entity;

public class Food extends Product{
    private String typeProduct;

    public Food() {
        super();
    }

    public Food(String ID, String nameProduct,  String typeProduct, String unit, int quantity, String importDate, String productDate, int price) {
        super(ID, nameProduct, unit, quantity, importDate, productDate, price);
        this.typeProduct = typeProduct;
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
                + colSpace + "d\n", ID, nameProduct, typeProduct , unit, quantity, productDate, price);
    }
}
