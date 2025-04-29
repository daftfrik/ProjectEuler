package com.daft.euler;
import java.util.HashMap;

public class Problem26 extends Problem{
    @Override
    public void solve(){
        System.out.print(longestCycleIndex(1000));
    }

    int longestCycleIndex(int cap){
        int longesti = 0, longestC = 0;
        for(int i = 2; i < cap; i++){
            int cycle = cycleLength(i);
            if(cycle > longestC){
                longesti = i;
                longestC = cycle;
            }
        }
        return longesti;
    }

    int cycleLength(int denominator){
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = 1, i = 1;
        while(true){
            if(map.containsKey(mod)) return i - map.get(mod);
            else {
                map.put(mod, i);
                mod = mod * 10 % denominator;
            }
            i++;
        }
    }
}
