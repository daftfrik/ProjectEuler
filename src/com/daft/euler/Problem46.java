package com.daft.euler;
public class Problem46 extends Problem{
    @Override
    public void solve() {
        System.out.print(disproveGoldbach());
    }

    int disproveGoldbach(){
        int i = 9;
        while (true) {
            if(!satisfiesGoldbach(i))return i;
            i += 2;
        }
    }

    boolean satisfiesGoldbach(int n){
        if (n % 2 == 0 || isPrime(n))return true;
        for(int i = 1; i * i * 2 <= n; i++){
            if(isPrime(n - i * i * 2))return true;
        }
        return false;
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
