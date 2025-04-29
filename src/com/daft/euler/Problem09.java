package com.daft.euler;
public class Problem09 extends Problem{
    @Override
    public void solve(){
        System.out.print(pyTripletProduct(1000));
    }

    int pyTripletProduct(int n){
        for(int i = 1; i <= n; i++){
            for(int j = i+1; j <= n; j++){
                int k = n - i - j;
                if(isTriplet(i, j, k)) return i * j * k;
            }
        }
        return 0;
    }

    boolean isTriplet(int i, int j, int k){
        return (i*i + j*j) == k*k;
    }
}
