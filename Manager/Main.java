package Manager;

import Entity.Genarate;

public class Main {
    public static void main(String[] args) {
        String test = new Genarate().genarateDiscountCode("BHX",1500000);
        System.out.printf(test);


    }
}