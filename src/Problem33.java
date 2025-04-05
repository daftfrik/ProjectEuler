public class Problem33 extends Problem{
    @Override
    public void solve() {
        System.out.print(dcFractions());
    }

    int dcFractions(){
        int numerator = 1, denominator = 1;
        for(int d = 10; d < 100; d++){
            for(int n = 10; n < d; n++){
                int n0 = n%10, n1 = n/10;
                int d0 = d%10, d1 = d/10;
                if(n1 == d0 && n0 * d == n * d1 || n0 == d1 && n1 * d == n * d0){
                    numerator *= n;
                    denominator *= d;
                }
            }
        }
        return denominator / gcd(numerator, denominator);
    }

    int gcd(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;
        int n;
        for (n = 0; ((i | j) & 1) == 0; n++) {
            i >>= 1;
            j >>= 1;
        }
        while ((i & 1) == 0) i >>= 1;
        do {
            while ((j & 1) == 0) j >>= 1;
            if (i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            j = (j - i);
        } while (j != 0);
        return i << n;
    }
}
