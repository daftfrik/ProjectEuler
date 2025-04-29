package com.daft.euler;
public class Problem36 extends Problem{
    @Override
    public void solve() {
        System.out.print(doublePalindromeSum(1000000));
    }

    long doublePalindromeSum(int n){
        long sum = 0;
        for(int i = 1; i < n; i++)
            if (isDoublePalindrome(i, 10, 2))
                sum += i;
        return sum;
    }

    boolean isDoublePalindrome(int n, int i, int j){
        return isPalindrome(Integer.toString(n, i)) && isPalindrome(Integer.toString(n, j));
    }

    boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
