public class Problem21 extends Problem{
    @Override
    public void solve(){
        System.out.print(amicableSumUnder(10000));
    }

    int amicableSumUnder(int n){
        int amicableSum = 0;

        for(int i = 0; i < n; i++){
            if(isAmicable(i)){
                amicableSum += i;
            }
        }
        return amicableSum;
    }

    boolean isAmicable(int n){
        int m = divSum(n);
        return m != n && divSum(m) == n;
    }

    int divSum(int n){
        int total = 1;
        for(int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0){
                total += i + (n/i);
            }
        return total;
    }
}
