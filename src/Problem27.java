public class Problem27 extends Problem{
    @Override
    public void solve(){
        System.out.print(coefficientProduct(1000));
    }

    int coefficientProduct(int limit){
        int numPrimes = 0;
        int bestA = 0, bestB = 0;

        for(int a = -limit; a <= limit; a++){
            for(int b = -limit; b <= limit; b++){
                int length = 0;
                while(isPrime((length * length) + (a * length) + b)){
                    length++;
                }
                if(numPrimes < length){
                    numPrimes = length;
                    bestA = a;
                    bestB = b;
                }
            }
        }
        return bestA * bestB;
    }

    boolean isPrime(int k){
        if(k <= 1)return false;
        if(k == 2 || k == 3)return true;
        if(k%2 == 0 || k%3 == 0)return false;

        for(int i = 5; i*i <= k; i = i + 6){
            if(k % i == 0 || k % (i + 2) == 0)return false;
        }
        return true;
    }
}
