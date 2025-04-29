package com.daft.euler;
import java.util.Arrays;
import java.util.HashSet;

public class Problem32 extends Problem{
    @Override
    public void solve() {
        System.out.print(sumPandigitalProducts());
    }

    int sumPandigitalProducts(){
        HashSet<Integer> products = new HashSet<>();
        int sum = 0;
        for (int a = 1; a <= 99; ++a)
            for (int b = 100; b <= 9999; ++b) {
                int c = a * b;
                if (isPandigital(a, b, c)) products.add(c);
            }
        for(int i:products)sum+=i;
        return sum;
    }

    boolean isPandigital(int a, int b,  int c){
        String s = "" + a + b + c;
        if(s.length() != 9) return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars).equals("123456789");
    }
}
