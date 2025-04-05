public class Problem39 extends Problem{
    @Override
    public void solve() {
        System.out.print(maxTriPerimeter(1000));
    }

    int maxTriPerimeter(int n){
        int maxP = 0;
        int maxT = 0;
        for (int p = 1; p <= n; p++) {
            int triangles = countPs(p);
            if (triangles > maxT) {
                maxT = triangles;
                maxP = p;
            }
        }
        return maxP;
    }

    private static int countPs(int p) {
        int result = 0;
        for (int a = 1; a <= p; a++) {
            for (int b = a; b <= p; b++) {
                int c = p - a - b;
                if (b <= c && a * a + b * b == c * c)
                    result++;
            }
        }
        return result;
    }
}
