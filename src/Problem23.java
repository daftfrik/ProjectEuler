import java.util.ArrayList;
import java.util.HashSet;

public class Problem23 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumOfNonAbunantBelow(28123));
    }

    int sumOfNonAbunantBelow(int n){
        ArrayList<Integer> abundants = new ArrayList<>();

        for (int i = 1; i < n; i++) if (isAbundant(i)) abundants.add(i);

        HashSet<Integer> abundantSums = new HashSet<>();
        for (int i = 0; i < abundants.size(); i++) {
            for (int j = i; j < abundants.size(); j++) {
                int testSum = abundants.get(i) + abundants.get(j);
                if(testSum <= n)abundantSums.add(testSum);
            }
        }

        int sum = 0;
        for (int i = 1; i < n; i++) if (!abundantSums.contains(i)) sum += i;
        return sum;
    }

    boolean isAbundant(int n){
        int divSum = 1;
        int end = (int)Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if(n % i == 0) {
                divSum += i;
                if((n/i) != i) divSum += n/i;
            }
        }
        return (divSum > n);
    }
}
