package logic;

/**This interface models a two-dimensional plate.
 * The data consists of double values.
 * */
public interface Plate2D {

    /**
     * Fills a two-dimensional array with random numbers between 1 and 10
     * @return a two dimensional array with filled cells
     */
    double[][] fillArray();

    /**
     * Use the Gauss Seidel algorithm to calculate the values ​​in the cells.
     * To calculate the neighbor temperatures at a point, you have to take the right, left, upper and lower neighbors.
     * @param f_ij: Heating at point i j
     * @return The temperature value at position i, j after execution of the GaussSeidel calculation
     */
    double gaussSeidelAlgorithm(double f_ij);

    /**
     * Returns the coordinates for the plate
     * @return coodinates
     */
    double[][] getCoordinates();

    /**
     * Sets the coordinates for the plate
     * @param coordinates two-dimensional array of integer values that represent the data
     */
    void setCoordinates(double[][] coordinates);

    /**
     * Returns the temperature value for the cells of the plate
     * @return temperature
     */
    double getTemperature();
}
