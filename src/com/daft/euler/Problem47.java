package com.daft.euler;
public class Problem47 extends Problem{
    @Override
    public void solve() {
        System.out.print(firstInFourPrimeRun());
    }

    int firstInFourPrimeRun(){
        int i = 2;
        while (true) {
            if(fourConsecutiveFourPrimes(i))return i;
            i++;
        }
    }

    boolean fourConsecutiveFourPrimes(int n){
        return  countPrimes(n) == 4 &&
                countPrimes(n + 1) == 4 &&
                countPrimes(n + 2) == 4 &&
                countPrimes(n + 3) == 4;
    }

    int countPrimes(int n){
        int count = 0;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                do n /= i;
                while (n % i == 0);
                count++;
                limit = (int) Math.sqrt(n);
            }
        }
        if (n > 1)count++;
        return count;
    }
}
