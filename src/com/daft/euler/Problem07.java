package com.daft.euler;
public class Problem07 extends Problem{
    @Override
    public void solve(){
        System.out.print(nthPrime(10001));
    }

    int nthPrime(int n){
        int i = 2;

        while(n > 0){
            if(isPrime(i))n--;
            i++;
        }

        return i-1;
    }

    boolean isPrime(int k){
        if(k <= 1)return false;
        if(k == 2 || k == 3)return true;
        if(k%2 == 0 || k%3 == 0)return false;

        for(int i = 5; i*i <= k; i = i + 6){
            if(k % i == 0 || k % (i + 2) == 0)return false;
        }
        return true;
    }
}
