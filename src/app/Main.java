package app;

import logic.Rod;

/**************************************
 * Created by Andrea on 06.11.2016.
 **************************************/
public class Main {

    public static void main(String[] args) {
        //Plate plate = new Plate(6,6);
        //plate.fillArray();
        //String s = plate.toString();
        //System.out.println(s);
        Rod rod = new Rod(11);
        rod.fillArray();
        System.out.print(rod.toString());
        rod.gaussSeidelAlgorithm(0);
    }
}
