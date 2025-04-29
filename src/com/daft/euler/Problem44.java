package com.daft.euler;
public class Problem44 extends Problem{
    @Override
    public void solve() {
        System.out.print(findMinD());
    }

    long findMinD(){
        long minD = Long.MAX_VALUE;
        long n = 2;
        while(minD == Long.MAX_VALUE){
            long pn = pentagonalNum(n);
            for(long d = 1; d < n; d++){
                long x = n - d;
                long px = pentagonalNum(x);
                long sum = pn + px;
                long diff = pn - px;
                if(diff > minD)break;
                if(isPentagonal(sum) && isPentagonal(diff))minD = diff;
            }
            n++;
        }
        return minD;
    }

    long pentagonalNum(long n){
        if(n <= 0)return 0;
        return (n * (n * 3 - 1)) /2;
    }

    boolean isPentagonal(long n){
        long x = (long)(1 + Math.sqrt(24*n + 1))/6;
        long pn = x * (3 * x - 1)/2;
        return pn == n;
    }
}
