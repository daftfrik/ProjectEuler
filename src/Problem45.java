public class Problem45 extends Problem{
    @Override
    public void solve() {
        System.out.print(findNextTPH(143));
    }

    long findNextTPH(int n){
        n++; //since n is valid, and we want to find the next one.
        int i = n;
        while (true) {
            long hex = i * (2L * i - 1);
            if(isPentagonal(hex)) return hex;
            i++;
        }
    }

    boolean isPentagonal(long n){
        long x = (long)(1 + Math.sqrt(24*n + 1))/6;
        long pn = x * (3 * x - 1)/2;
        return pn == n;
    }
}
