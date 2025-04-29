package com.daft.euler;
import java.util.Arrays;

public class Problem50 extends Problem{
    @Override
    public void solve() {
        System.out.print(consecutivePrimeSumBelow(1000000));
    }

    boolean[] isPrime;
    int[] primes;

    long consecutivePrimeSumBelow(int n){
        gatherPrimes(n);

        long maxSum = 0;
        int maxRun = 0;
        for(int i = 0; i < primes.length; i++){
            int sum = 0;
            for(int j = i; j < primes.length; j++){
                sum += primes[j];
                if(sum > n) {
                    break;
                } else if(j-i > maxRun && sum > maxSum && isPrime[sum]){
                    maxSum = sum;
                    maxRun = j-i;
                }
            }
        }
        return maxSum;
    }

    void gatherPrimes(int n){
        sieveOfEratosthenes(n);
        int numPrimes = 0;
        for(boolean b: isPrime)if(b)numPrimes++;
        primes = new int[numPrimes];
        for(int i = 0, j = 0; i < isPrime.length; i++){
            if(isPrime[i]){
                primes[j] = i;
                j++;
            }
        }
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
