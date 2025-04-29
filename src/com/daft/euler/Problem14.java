package com.daft.euler;
public class Problem14 extends Problem{
    @Override
    public void solve(){
        System.out.print(longestChain(1000000));
    }

    int[] cache;
    int longestChain(int n){
        int cl;
        int lc = 0;
        int lcSeed = 0;
        cache = new int[n];
        for(int i = 0; i < n; i++){
            cl = collatzLength(i);
            if(cl > lc){
                lc = cl;
                lcSeed = i;
            }
        }
        return lcSeed;
    }

    int collatzLength(long n){
        int length = 1;
        int start = (int)n;
        while(n > 1){
            if(n < start){
                length += cache[(int)n];
                break;
            }
            if(n % 2 == 0) n /= 2;
            else n = (3 * n) + 1;
            length++;
        }
        cache[start] = length;
        return length;
    }
}
