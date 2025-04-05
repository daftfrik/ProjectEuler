import java.math.BigInteger;

public class Problem25 extends Problem{
    @Override
    public void solve(){
        System.out.print(fibNDigitsIndex(1000));
    }

    private int fibNDigitsIndex(int n) {
        BigInteger sum;
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        int length = 0, index = 1;

        while(length < n){
            sum = fib1.add(fib2);
            fib1 = fib2;
            fib2 = sum;
            length = getDigitCount(sum);
            index++;
        }
        return index;
    }

    int getDigitCount(BigInteger number) {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0) {
            return digitCount - 1;
        }
        return digitCount;
    }
}
