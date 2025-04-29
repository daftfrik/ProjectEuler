package com.daft.euler;
import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 extends Problem{
    @Override
    public void solve(){
        System.out.print(distinctPowers(100));
    }

    int distinctPowers(int n){
        HashSet<BigInteger> results = new HashSet<>();
        for(int a = 2; a <= n; a++){
            for(int b = 2; b <= n; b++){
                results.add(BigInteger.valueOf(a).pow(b));
            }
        }
        return results.size();
    }
}
