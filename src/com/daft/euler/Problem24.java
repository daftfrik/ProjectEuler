package com.daft.euler;
import java.util.ArrayList;

public class Problem24 extends Problem{
    @Override
    public void solve(){
        System.out.print(lexPerm(1000000));
    }

    String lexPerm(int n){
        ArrayList<Integer> numbers = new ArrayList<>();
        n--; //initial array is the first permutation
        for(int i = 0; i < 10; i++)numbers.add(i);
        StringBuilder result = new StringBuilder();
        for(int i = numbers.size()-1; i >= 0; i--){
            int fact = factorial(i);
            int j = n/fact;
            result.append(numbers.get(j));
            numbers.remove(j);
            numbers.add(i, j);
            n %= fact;
        }
        return result.toString();
    }

    int factorial(int n){
        int result = 1;
        for(int i = 2; i <= n; i++)result *= i;
        return result;
    }
}
