package persist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Manages and reads the input String from the console
 */
public class ConsoleInputReader
{
    private String string;

    public ConsoleInputReader()  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your function:  ");

        try {
            string = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    /**
     * Set the String for ConsoleInputReader
     * @param string: a simple string
     */
    public void setString(String string) {
        this.string = string;
    }

    /**
     * Gets the String fr ConsoleInputReader
     * @return a string
     */
    public String getString() {
        return string;
    }
}
