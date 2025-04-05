public class Problem37 extends Problem{
    @Override
    public void solve() {
        System.out.print(sumTruncPrimes());
    }

    long sumTruncPrimes(){
        long sum = 0;
        for (int count = 0, n = 10; count < 11; n++) {
            if (isTruncPrime(n)) {
                sum += n;
                count++;
            }
        }
        return sum;
    }

    boolean isTruncPrime(int n){
        for(long i = 10; i <= n; i*=10)
            if(notPrime(n % (int) i))return false;
        while(n != 0){
            if(notPrime(n))return false;
            n /= 10;
        }
        return true;
    }

    boolean notPrime(int k){
        if(k <= 1)return true;
        if(k == 2 || k == 3)return false;
        if(k%2 == 0 || k%3 == 0)return true;

        for(int i = 5; i*i <= k; i = i + 6){
            if(k % i == 0 || k % (i + 2) == 0)return true;
        }
        return false;
    }
}
