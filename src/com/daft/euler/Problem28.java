package com.daft.euler;
public class Problem28 extends Problem{
    @Override
    public void solve(){
        System.out.print(spiralSum(1001));
    }

    int spiralSum(int size){
        int n = 1;
        int step = 2;
        int total = 0;
        int ringStep = 0;
        while(n <= size*size){
            total += n;
            n += step;
            ringStep++;
            if(ringStep == 4){
                step += 2;
                ringStep = 0;
            }
        }
        return total;
    }
}
