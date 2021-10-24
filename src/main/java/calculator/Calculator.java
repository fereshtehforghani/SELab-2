
package calculator;
import java.lang.Math;

public class Calculator {
    public double rvs(int a) throws Exception{
        if (a == 0){
//            throw new IllegalArgumentException("Argument 'divisor' is 0");
            return 0.0;
        }
        return 1.0/a; }

    public double sqrt(int a) throws Exception{
        if (a < 0){
//            throw new IllegalArgumentException("square root of negative number");
            return -1;
        }
        return Math.sqrt(a); }
}