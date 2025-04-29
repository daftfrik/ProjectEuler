package com.daft.euler;
public class Problem06 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumSquareDifference(1, 100));
    }

    long sumSquareDifference(int lower, int upper){
        return squareOfSum(lower, upper) - sumOfSquares(lower, upper);
    }

    long sumOfSquares(int lower, int upper){
        long sum = 0;
        for(int i = lower; i <= upper; i++) sum += (long) i * i;
        return sum;
    }

    long squareOfSum(int lower, int upper){
        long sum = 0;
        for(int i = lower; i <= upper; i++) sum += i;
        return sum * sum;
    }
}
