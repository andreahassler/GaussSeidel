package logic;

/**************************************
 * Created by Andrea on 06.11.2016.
 **************************************/

class Plate {
    private double [][] coordinates;
    public static final int MAX_ITERATIONS = 100;

    Plate(int i, int j)
    {
        coordinates = new double [i][j];
    }

    void setTemperature(int indexI, int indexJ, double temperature){
        coordinates[indexI][indexJ] = temperature;
            }

    double[][] fillArray()
    {
        for (int i = 0; i <coordinates.length; i++)
        {
            for (int j = 0; j <coordinates.length ; j++)
            {
                coordinates[i][j] = Math.random();
                // coordinates [i][j] = gaussSeidelAlgorith(n,u,f) //wieoft Gauss, Temperaturwert bei i,Erhitzung am Punkt i
            }
        }
        return coordinates;
    }

    public double gaussSeidelAlgorithm(double f) //int n wie oft Algorithmus machen
    {  
        double temperature = 0;
        for (int i=1; i<coordinates.length-1;i++){
            for (int j=1; j<coordinates.length-1;j++){

                temperature = (coordinates[i-1][j] + coordinates[i+1][j] + coordinates[i][j-1] + coordinates[i][j+1]);
                coordinates[i][j]=temperature;
                System.out.println(temperature);
            }
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

}


