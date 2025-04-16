import java.util.stream.IntStream;

public class Problem23 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumOfNonAbunantBelow(28123));
    }

    boolean[] isAbundant;

    int sumOfNonAbunantBelow(int n){
        fillAbundantArray(n);

        int sum = 0;
        for(int i = 0; i <= n; i++)
            if (!isSumOfAbundants(i)) sum += i;

        return sum;
    }

    void fillAbundantArray(int n){
        isAbundant = new boolean[n + 1];
        IntStream.range(1, isAbundant.length).
                forEach(i -> isAbundant[i] = isAbundant(i));
    }

    boolean isSumOfAbundants(int n){
        for(int i = 0; i <= n; i++)
            if (isAbundant[i] && isAbundant[n - i]) return true;
        return false;
    }

    boolean isAbundant(int n){
        int divSum = 1;
        int end = (int)Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if(n % i == 0) divSum += i + n/i;
        }
        if(end*end == n)divSum -= end;
        return (divSum > n);
    }
}
