package logic;

import java.util.Random;

/**************************************
 * Created by Andrea on 06.11.2016.
 **************************************/

public class Plate {
    private double [][] coordinates;
    private int MAX_ITERATIONS = 100;
    private double temperature;

    public Plate(int i, int j)
    {
        coordinates = new double [i][j];
        System.out.println(j);
    }

    public Plate(double coordinates [][]){
        this.coordinates = coordinates;
    }

    void setTemperature(int indexI, int indexJ, double temperature){
        coordinates[indexI][indexJ] = temperature;
            }

    public double[][] fillArray()
    {
        int randomInt = 0;
        for (int i = 0; i <coordinates.length; i++)
        {
            for (int j = 0; j <coordinates.length ; j++)
            {
                Random randomGenerator = new Random();
                for (int idx = 1; idx <= 10; ++idx){
                    randomInt = randomGenerator.nextInt(11);
                }
                coordinates[i][j] = randomInt;

                // coordinates [i][j] = gaussSeidelAlgorith(n,u,f) //wieoft Gauss, Temperaturwert bei i,Erhitzung am Punkt i
            }
        }
        return coordinates;
    }

    public double gaussSeidelAlgorithm(double f) //int n wie oft Algorithmus machen
    {
        int iterations = 4;
        temperature = 0;
            while(iterations>0){
            for (int i = 1; i < coordinates.length - 1; i++) {
                for (int j = 1; j < coordinates.length - 1; j++) {
                    temperature = 0.25 * (coordinates[i - 1][j] + coordinates[i + 1][j] + coordinates[i][j - 1] + coordinates[i][j + 1]);
                    coordinates[i][j] = temperature;
                }
            }
            iterations-=1;
            }
            return temperature;
        }


    public String toString()
    {   StringBuilder aString = new StringBuilder();
        for(int i=0; i<coordinates.length; i++){
            for (int j =0; j<coordinates.length; j++){
                aString.append(" ").append(coordinates[i][j]);
            }
        }
        return aString.toString();
    }


    public double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public double getTemperature() {
        return temperature;
    }
}


