package DoAnOOP.Entity;

public class Drinks extends Product{
    private int volume;

    public Drinks() {
        super();
    }

    public Drinks(String ID, String nameProduct, int volume, String unit, int quantity, String importDate, String productDate, int price) {
        super(ID, nameProduct, unit, quantity, importDate, productDate, price);
        this.volume = volume;
    }

    @Override
    public void print() {
        int colSpace = 15;
        System.out.printf("%-" + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "s %-"
                + colSpace + "d\n", ID, nameProduct, volume + " ml" , unit, quantity, productDate, price);
    }


}
