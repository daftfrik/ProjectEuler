package com.daft.euler;
public class Problem34 extends Problem{
    @Override
    public void solve() {
        System.out.print(sumCurious());
    }

    int[] factorials = new int[10];

    int sumCurious(){
        fillFactorials();
        int sum = 0;
        for(int i = 3; i < 7*factorials[9]; i++)
            if(i == factorialDigitsSum(i)) sum += i;
        return sum;
    }

    int factorialDigitsSum(int n){
        int sum = 0;
        while(n != 0){
            sum += factorials[n%10];
            n /= 10;
        }
        return sum;
    }

    void fillFactorials(){
        for(int i = 0; i < factorials.length; i++) factorials[i] = factorial(i);
    }

    int factorial(int n){
        int result = 1;
        for(int i = 2; i <= n; i++)result *= i;
        return result;
    }
}
