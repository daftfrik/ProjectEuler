package com.daft.euler;
import java.util.Arrays;

public class Problem10 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumPrimesBelow(2000000));
    }

    boolean[] isPrime;

    long sumPrimesBelow(int n){
        long sum = 0;
        sieveOfEratosthenes(n);
        for(int i = 2; i < isPrime.length; i++) if (isPrime[i]) sum += i;
        return sum;
    }

    void sieveOfEratosthenes(int n){
        isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for(int j = (i*i); j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
