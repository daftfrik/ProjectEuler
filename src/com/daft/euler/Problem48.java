package com.daft.euler;
import java.math.BigInteger;

public class Problem48 extends Problem{
    @Override
    public void solve() {
        System.out.print(selfPowSumLastTen());
    }

    BigInteger selfPowSumLastTen(){
        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.TEN.pow(10);
        for(int i = 1; i <= 1000; i++)
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), mod));
        return sum.mod(mod);
    }
}
