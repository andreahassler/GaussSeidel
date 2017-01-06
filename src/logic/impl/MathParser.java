package logic.impl;
import org.mariuszgromada.math.mxparser.*;

    /**
    * Mathparser is responsible for parsing string expressions to mathematical expressions
    * mXParser library Source: http://mathparser.org/
     */


public class MathParser {

    private String string;
    private Argument x;
    private double result;

    public MathParser(String string){
        this.string = string;
        x = new Argument("x");
    }

    /**
     * @param xValue: The x value of the mathematical expression
     * @return The result from The result of the mathematical expression
     */
    double calculateValue(double xValue) //wert kommt von SimplePlate
    {
        x.setArgumentValue(xValue);
        Expression e = new Expression(string,x);
        mXparser.consolePrint("x ist: " + x.getArgumentValue()+ "  " + "Res: " + e.getExpressionString() + " = " + e.calculate()+"\n");
        return result = Math.round(e.calculate()*1000d)/1000d;
    }

}
