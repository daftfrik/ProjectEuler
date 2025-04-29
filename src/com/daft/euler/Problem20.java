package com.daft.euler;
import java.math.BigInteger;

public class Problem20 extends Problem{
    @Override
    public void solve(){
        System.out.print(factorialDigitSum(100));
    }

    int factorialDigitSum(int n){
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return sumStringDigits(factorial.toString());
    }

    int sumStringDigits(String s){
        String temp;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            temp = "" +ch;
            sum += Integer.parseInt(temp);
        }
        return sum;
    }
}
