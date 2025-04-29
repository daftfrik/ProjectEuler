package com.daft.euler;
import java.math.BigInteger;

public class Problem15 extends Problem{
    @Override
    public void solve(){
        System.out.print(latticePaths(20, 20));
    }

    BigInteger latticePaths(int i, int j){
        return factorial(i + j).divide(factorial(i).multiply(factorial(j)));
    }

    BigInteger factorial(int n){
        BigInteger f = BigInteger.valueOf(1);
        for(int i = 2; i <= n; i++){
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
