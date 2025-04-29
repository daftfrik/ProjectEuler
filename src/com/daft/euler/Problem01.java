package com.daft.euler;
public class Problem01 extends Problem{
    @Override
    public void solve(){
        System.out.print(multipleSum(3, 5, 1000));
    }

    public int multipleSum(int m1, int m2, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(i % m1 == 0 || i % m2 == 0){
                sum += i;
            }
        }
        return sum;
    }
}
