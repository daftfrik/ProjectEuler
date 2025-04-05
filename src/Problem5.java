import java.math.BigInteger;

public class Problem5 extends Problem{
    @Override
    public void solve(){
        System.out.print(minEDinRange(1, 20));
    }

    String minEDinRange(int from, int to){
        BigInteger result = BigInteger.ONE;
        for(int i = from; i <= to; i++) {
            result = lcm(BigInteger.valueOf(i), result);
        }
        return result.toString();
    }

    BigInteger lcm(BigInteger i, BigInteger j){
        return i.divide(i.gcd(j)).multiply(j);
    }
}
