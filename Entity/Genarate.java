package DoAnOOP.Entity;

import java.util.Arrays;
import java.util.Random;

public class Genarate {
    class ArrayDiscountCode {
        int moneyDc;
        String codeDc;

        public ArrayDiscountCode() {
            this.moneyDc = 0;
            this.codeDc = "";
        }

        public ArrayDiscountCode(int moneyDc, String codeDc) {
            this.moneyDc = moneyDc;
            this.codeDc = codeDc;
        }
    }

    private ArrayDiscountCode[] arrayDiscountCode = new ArrayDiscountCode[0];
    private int sizeDiscountCode = 0;

    public Genarate() {
    }

    public String genarateIdProduct(String type) {
        return type + (int)(Math.random() * 100000);
    }
    public String genarateDiscountCode(String firstCode, int moneyDiscount) {
        arrayDiscountCode = Arrays.copyOf(arrayDiscountCode, sizeDiscountCode + 1);
        String randomCode = firstCode + "-" +  (int)(Math.random() * 100000000);
        arrayDiscountCode[sizeDiscountCode++] = new ArrayDiscountCode(moneyDiscount, randomCode);

        return randomCode;
    }

}
