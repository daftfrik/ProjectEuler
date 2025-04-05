import java.util.Arrays;

public class Problem35 extends Problem{
    @Override
    public void solve(){
        System.out.print(circularPrimeCount(1000000));
    }

    boolean[] isPrime;

    int circularPrimeCount(int n){
        int count = 0;
        sieveOfEratosthenes(n);
        for(int i = 0; i < isPrime.length; i++) {
            if(isCircularPrime(i)) count++;
        }
        return count;
    }

    boolean isCircularPrime(int n){
        String s = Integer.toString(n);
        for(int i = 0; i < s.length(); i++) {
            int index = Integer.parseInt(s.substring(i) + s.substring(0, i));
            if (!isPrime[index]) return false;
        }
        return true;
    }

    void sieveOfEratosthenes(int n){
        isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for(int j = (i*i); j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
