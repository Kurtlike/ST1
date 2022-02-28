package math;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static java.lang.Double.NaN;

public class MathTg {
    private ArrayList<Double> bernoulliNumbers;
    private static final int amountBernoulliNumbers = 10;
    public MathTg() {
        createBernoulliNumber();
    }

    public double tg(double x){
        x = format(x);
        if(Double.isNaN(x) || x == 0) return x;
        double ans = 0;
        for(int k = 0; k < amountBernoulliNumbers / 2; k++){
            double kPow = Math.pow(2d,2 * k);
            ans+= ((kPow * (kPow - 1))/getFactorial(2 * k)) * Math.abs(bernoulliNumbers.get(2*k)) * Math.pow(x, 2 * k - 1);
        }
        return ans;
    }
    private void createBernoulliNumber(){
        bernoulliNumbers = new ArrayList<>();
        bernoulliNumbers.add(1d);
        bernoulliNumbers.add(-0.5);
        for(int n = 2; n < amountBernoulliNumbers; n++){
            if(n % 2 == 0){
                double sum = 0;
                for(int k = 1; k < n+1; k++){
                    sum+= getFactorial(n+1)/(getFactorial(k+1) * getFactorial(n-k)) * bernoulliNumbers.get(n-k);
                }
                bernoulliNumbers.add(-1 * sum / (n+1));
            }
            else {
                bernoulliNumbers.add(0d);
            }

        }
    }
    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        }
        else {
            int a = IntStream.rangeClosed(2, f).reduce((x, y) -> x * y).getAsInt();
            return a;
        }
    }
    public double format(double x){
        if(x % (Math.PI/2) == 0 && x % (Math.PI) != 0) return NaN;
        int quotient = (int)(x / (Math.PI));
        int quotient2 = (int)(x / (Math.PI/2));
        if(x % Math.PI == 0) return 0d;
        if(quotient2 >= 1 && quotient * 2 < quotient2){
            x = x - (quotient2+1) * Math.PI/2;
        }else if(quotient2 >= 1){
            x = x - quotient2 * Math.PI/2;
        }
        if(quotient2 <= -1 && quotient * 2 == quotient2){
            x = x + -quotient2 * Math.PI/2;
        }else if(quotient2 <= -1){
            x = x - quotient2 * Math.PI/2 + Math.PI/2;
        }
        return x;
    }
}
