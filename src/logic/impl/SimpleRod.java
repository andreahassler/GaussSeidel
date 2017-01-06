package logic.impl;

import logic.Rod;
import java.util.Random;

    /**
    * The rod manages a one-dimensional array
    */

public class SimpleRod implements Rod {
    private double [] rodArray ;
    private static final int MAX_ITERATIONS = 100;
    private int randomInt;

    public SimpleRod(int i)
    {
        rodArray = new double [i];
    }

    void setTemperature(int indexI,  int temperature){
        rodArray[indexI] = temperature;
    }

        /**
         *   /**
         * Fills a one-dimensional array with random numbers between 1 and 10
         * @return a one dimensional array with filled cells
         */

    @Override
    public double[] fillArray()
    {
        for (int i = 0; i < rodArray.length; i++)
        {
            Random randomGenerator = new Random();

            for (int idx = 1; idx <= 10; ++idx){
                randomInt = randomGenerator.nextInt(11);
            }
                rodArray[i] = randomInt;
        }
        return rodArray;
    }

        /**
         * Use the Gauss Seidel algorithm to calculate the values ​​in the cells.
         * To calculate the neighbor temperatures at a point, you have to take the right and left neighbors
         * @param f_i: Heating at point i j
         * @return The temperature value at position i, j after execution of the GaussSeidel calculation
         */
    @Override
    public double gaussSeidelAlgorithm(double f_i)
    {
        double temperature = 0.0;
        for (int i = 1; i < rodArray.length-1; i++){
            {
                temperature =  (0.5) * ((rodArray[i-1] + rodArray[i+1]))+ f_i;
                rodArray[i-1]=  temperature;

                System.out.println("");
                System.out.print(temperature+ " ");
                System.out.print(i);

                }
        }
        return temperature;
    }
        /**
         * Translates the memory location of a cell into a string
         * @return The translated string of a cell
         */
    @Override
    public String toString()
    {   StringBuilder aString = new StringBuilder();
        for(int i = 0; i< rodArray.length; i++){
            {
                aString.append(" ").append(rodArray[i]);
            }
        }
        return aString.toString();
    }
}
