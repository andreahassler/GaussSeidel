package logic;

import java.util.Random;

/**************************************
 * Created by Andrea on 06.11.2016.
 **************************************/
public class Rod {
    private double [] rodArray ;
    public static final int MAX_ITERATIONS = 100;
    int randomInt;

    public Rod(int i)
    {
        rodArray = new double [i];
    }

    void setTemperature(int indexI,  int temperature){
        rodArray[indexI] = temperature;
    }


    public double[] fillArray()
    {   double k=1;
        for (int i = 0; i < rodArray.length; i++)
        {
            Random randomGenerator = new Random();

            for (int idx = 1; idx <= 10; ++idx){
                randomInt = randomGenerator.nextInt(11);
            }
                rodArray[i] = randomInt;
                // rodArray [i][j] = gaussSeidelAlgorith(n,u,f) //wieoft Gauss, Temperaturwert bei i,Erhitzung am Punkt i
        }
        return rodArray;
    }

    public double gaussSeidelAlgorithm(double f) //int n wie oft Algorithmus machen
    {
        double temperature = 0.0;
        for (int i = 1; i < rodArray.length-1; i++){
            {
                temperature =  (0.5) * ((rodArray[i-1] + rodArray[i+1])); //+ f));
                rodArray[i-1]=  temperature;

                System.out.println("");
                System.out.print(temperature+ " ");
                System.out.print(i);

                }
        }
        return temperature;
    }

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
