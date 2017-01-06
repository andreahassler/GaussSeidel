package logic;

/**This interface models a one-dimensional rod.
 * The data consists of double values.
 * */
public interface Rod {

    /**
     * Fills a one-dimensional array with random numbers between 1 and 10
     * @return a two dimensional array with filled cells
     */
    double[] fillArray();

    /**
     * Use the Gauss Seidel algorithm to calculate the values ​​in the cells.
     * To calculate the neighbor temperatures at a point, you have to take the right and left neighbors.
     * @param f_i: Heating at point i
     * @return The temperature value at position i after execution of the GaussSeidel calculation
     */
    double gaussSeidelAlgorithm(double f_i);

    /**
     * Translates the memory location of a cell into a string
     * @return The translated string of a cell
     */
    String toString();
}
