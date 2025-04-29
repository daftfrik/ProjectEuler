package com.daft.euler;
import java.util.ArrayList;

public class Problem12 extends Problem{
    @Override
    public void solve(){
        System.out.print(highDivTri(500));
    }

    long highDivTri(int n){
        ArrayList<Integer> smallest = new ArrayList<>();
        smallest.add(0);

        int index = 0;
        int triangle = 0;
        while (smallest.size() < n){
            index++;
            triangle += index;

            if(smallest.size() > 300 && triangle % 10 != 0)continue;

            int divisors = divCount(triangle);
            while(smallest.size() <= divisors) smallest.add(triangle);
        }
        return smallest.get(smallest.size()-1);
    }

    static int divCount(long n){
        int total = 0;
        int end = (int) Math.sqrt(n);
        for(int i = 1; i <= end; i++) if (n % i == 0) total += 2;
        return total;
    }
}
