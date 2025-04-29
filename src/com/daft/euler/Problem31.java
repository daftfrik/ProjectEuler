package com.daft.euler;
public class Problem31 extends Problem{
    @Override
    public void solve() {
        System.out.print(coinCombosForN(200));
    }

    int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};

    int coinCombosForN(int n){
        int[][] combos = new int[coins.length + 1][n + 1];
        combos[0][0] = 1; //one way to pay 0.00
        for(int i = 0; i < coins.length; i++){
            int coin = coins[i];
            for(int j = 0; j <= n; j++){
                combos[i+1][j] = combos[i][j] + (j >= coin ? combos[i+1][j-coin] : 0);
            }
        }
        return combos[coins.length][n];
    }
}
