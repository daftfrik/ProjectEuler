package com.daft.euler;
import java.util.Arrays;

public class Problem49 extends Problem{
    @Override
    public void solve() {
        lim = 10000;
        System.out.print(otherPrimePermuteConcat());
    }

    boolean[] isPrime;
    int lim;

    String otherPrimePermuteConcat(){

        sieveOfEratosthenes(lim);
        for(int i = 1000; i < lim; i++){
            if(isPrime[i]){
                for(int gap = 1; gap < lim; gap++){
                    int i1 = i + gap;
                    int i2 = i1 + gap;
                    if(validateTriplet(i, i1, i2))return "" + i + i1 + i2;
                }
            }
        }
        return ":(";
    }

    boolean validateTriplet(int a, int b, int c){
        return  b < lim && isPrime[b] && sameDigits(b, a) &&
                c < lim && isPrime[c] && sameDigits(c, a) &&
                a != 1487 && a != 4817 && a != 8147;
    }

    boolean sameDigits(int n, int m){
        char[] nd = Integer.toString(n).toCharArray();
        Arrays.sort(nd);
        char[] md = Integer.toString(m).toCharArray();
        Arrays.sort(md);
        return Arrays.equals(nd, md);
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
