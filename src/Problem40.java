public class Problem40 extends Problem{
    @Override
    public void solve() {
        System.out.print(digitProduct(6));
    }

    long digitProduct(int n){
        StringBuilder champerdowne = new StringBuilder();
        for (int i = 1; i < Math.pow(10, n); i++)champerdowne.append(i);

        int prod = 1;
        for (int i = 0; i <= n; i++)
            prod *= champerdowne.charAt((int)Math.pow(10, i) - 1) - '0';
        return prod;
    }
}
