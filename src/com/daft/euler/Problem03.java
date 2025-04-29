package com.daft.euler;
public class Problem03 extends Problem{
    @Override
    public void solve(){
        System.out.print(lpFactor(600851475143L));
    }

    public long lpFactor(long n){
        long largestPrime = -1;

        while(n % 2 == 0){
            largestPrime = 2;
            n = n / 2;
        }

        while(n % 3 == 0){
            largestPrime = 3;
            n = n / 3;
        }

        for(int i = 5; (long) i *i <= n; i += 6){
            while(n % i == 0){
                largestPrime = i;
                n = n / i;
            }
            while(n % (i + 2) == 0){
                largestPrime = i + 2;
                n = n / (i + 2);
            }
        }

        if(n > 4)largestPrime = n;

        return largestPrime;
    }
}
