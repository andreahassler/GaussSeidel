package logic.impl;

import logic.Plate2D;
import persist.TextFileReader;
import java.util.Arrays;
import java.util.Random;

/**
 * The SimplePlate2d manages a two-dimensional plate
 */

public class SimplePlate2D implements Plate2D {

    private final double FORBIDDEN_CELL = -99;
    private double[][] coordinates;
    private double temperature;
    private TextFileReader textFile;
    private MathParser mathParser;
    private double xValue = 0.0;

    public SimplePlate2D(double coordinates[][], TextFileReader textFile, MathParser mathParser) {
        this.coordinates = coordinates;
        this.textFile = textFile;
        this.mathParser = mathParser;
    }

    /**
     * Fills a two-dimensional array with random numbers between 1 and 10
     * @return a two dimensional array with filled cells
     */
    @Override
    public double[][] fillArray() {
        int randomInt = 0;
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates.length; j++) {
                Random randomGenerator = new Random();
                for (int idx = 1; idx <= 10; ++idx) {
                    randomInt = randomGenerator.nextInt(11);
                }
                coordinates[i][j] = randomInt;
            }
        }
        return coordinates;
    }

    /**
     * Use the Gauss Seidel algorithm to calculate the values ​​in the cells.
     * To calculate the neighbor temperatures at a point, you have to take the right, left, upper and lower neighbors.
     *
     * @param f_ij: Heating at point i j
     * @return The temperature value at position i, j after execution of the GaussSeidel calculation
     */
    @Override
    public double gaussSeidelAlgorithm(double f_ij) {
        int iterations = 2;
        temperature = 0.0;

        while (iterations > 0) {

            setFunctionAtRightEdge();

            for (int i = 1; i < textFile.getNumberOfRows() - 1; i++) {
                for (int j = 1; j < textFile.getNumberOfColumns() - 1; j++) {

                    if ((coordinates[i - 1][j] != FORBIDDEN_CELL) && coordinates[i + 1][j] != -FORBIDDEN_CELL
                            && coordinates[i][j - 1] != FORBIDDEN_CELL && coordinates[i][j + 1] != FORBIDDEN_CELL
                            && coordinates[i][j] != FORBIDDEN_CELL) {

                        temperature = 0.25 * (coordinates[i - 1][j] + coordinates[i + 1][j] + coordinates[i][j - 1] + coordinates[i][j + 1]) + f_ij;
                        temperature = (double) Math.round(temperature * 1000d) / 1000d;
                        coordinates[i][j] = temperature;
                        System.out.println(Arrays.deepToString(coordinates));
                    }
                }
            }
            iterations -= 1;
        }
        return temperature;
    }

    /**
     * Sets the functional values ​​on the right edge of the 2D array
     */
    public void setFunctionAtRightEdge() {

        int j = textFile.getNumberOfColumns() - 1;
        for (int i = 0; i < textFile.getNumberOfRows(); i++) {
            coordinates[i][j] = mathParser.calculateValue(xValue);
            xValue++;
        }
    }

    /**
     * Translates the memory location of a cell into a string
     * @return The translated string of a cell
     */
    public String toString() {
        StringBuilder aString = new StringBuilder();
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates.length; j++) {
                aString.append(" ").append(coordinates[i][j]);
            }
        }
        return aString.toString();
    }


    @Override
    public double[][] getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}


