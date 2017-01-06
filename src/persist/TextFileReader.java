package persist;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Reads amd manages data from a file. The supported format is comma separated value (csv).
 * The path for the file is given and documented.
 * @file C:\temp\myArray.txt
 *
 * Source by:
 * @see <a href="http://stackoverflow.com/questions/8829903/how-to-use-scanner-in-java-to-count-the-number-of-words-seperate-by-from-a-i"></>
 */

public class TextFileReader {

    private int numberOfRows;
    private int numbers;
    private File file;
    private double array[][];
    private int countNumbers;
    private int numberOfColumns;

    public TextFileReader() throws IOException {

        file = new File("C:\\temp\\myArray.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufRdr = new BufferedReader(new FileReader(file));
        String line = null;

        numberOfRows = 0;
        numbers = 0;
        countNumbers = 0;
        try {
            while ((line = bufRdr.readLine()) != null) {
                assert input != null;
                while (input.hasNextLine()) {
                    String tmp = input.nextLine();
                    numberOfRows++;
                }
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreElements()) {
                    numbers = Integer.parseInt(st.nextToken());
                    countNumbers++;
                }

            }
            calculateColumns();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufRdr.close();
    }

    /**
     * Calculates the number of columns in a two-dimensional array
     * @return number of columns
     */
    private int calculateColumns() {
        numberOfColumns = countNumbers / numberOfRows;
        return numberOfColumns;
    }

    /**
     * Creates a new two dimensional array and fills the cells with the read content from the file
     * @return a filled two dimensional array
     */
    public double[][] writeContent() {
        array = new double[numberOfRows][numberOfColumns];

        BufferedReader bufReader = null;
        try {
            bufReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String strLine = null;

        for (int i = 0; i < numberOfRows; i++) {
            try {
                assert bufReader != null;
                if ((strLine = bufReader.readLine()) != null) {
                    StringTokenizer stringToken = null;
                    stringToken = new StringTokenizer(strLine, ",");

                    while (stringToken.hasMoreTokens()) {
                        for (int j = 0; j < numberOfColumns; j++) {
                            array[i][j] = Double.parseDouble(stringToken.nextToken());
                            //System.out.println("["+i+"]"+"["+j+"]:"+array[i][j]);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    /**
     * Get the number of rows
     * @return number of rows
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Get the number of columns
     * @return number of columns
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }
}