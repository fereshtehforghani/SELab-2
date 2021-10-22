package calculator;

public class Calculator {
    public double rvs(int a) throws Exception{
        if (a == 0){
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return 1.0/a; }
}