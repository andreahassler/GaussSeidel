package persist;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadTextFile {

    private int rows;
    private int numbers;
    private File file;
    private double array[][];
    private int countNumbers;
    private int numberOfColumns;

    public ReadTextFile() throws IOException {

            file = new File("C:\\temp\\myArray.txt");
            Scanner input = null;
            try {
                input = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
            String line = null;

         rows = 0;
         numbers = 0;
        countNumbers =0;
            try {
                while((line = bufRdr.readLine()) != null)
                {
                    assert input != null;
                    while(input.hasNextLine()) {
                        String tmp=input.nextLine();
                        rows++;
                    }
                    StringTokenizer st = new StringTokenizer(line,",");
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

    private int calculateColumns() {
        numberOfColumns = countNumbers / rows;
        return numberOfColumns;
    }


    public double [][] writeContent(){
            array = new double[rows][numberOfColumns];

            BufferedReader bufReader  = null;
            try {
                bufReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String strLine = null;

            for(int i = 0; i< rows; i++){
                try {
                    assert bufReader != null;
                    if((strLine=bufReader.readLine())!=null){
                        StringTokenizer stringToken = null;
                        stringToken = new StringTokenizer(strLine,",");

                        while(stringToken.hasMoreTokens()){
                            for(int j = 0; j< numberOfColumns; j++){
                                array[i][j]= Double.parseDouble(stringToken.nextToken());
                                System.out.println("["+i+"]"+"["+j+"]:"+array[i][j]);
            }}}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return  array;
    }
}