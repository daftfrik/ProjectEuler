package com.daft.euler;
public class Problem30 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumAllFifthPowerSums());
    }

    int sumAllFifthPowerSums(){
        int sum = 0;
        for(int i = 2; i < 200000; i++){
            if(i == fifthPowDigitSum(i)) sum += i;
        }
        return sum;
    }

    int fifthPowDigitSum(int n){
        int sum = 0;
        while(n != 0){
            int digit = n % 10;
            sum += (int) Math.pow(digit, 5);
            n /= 10;
        }
        return sum;
    }
}
