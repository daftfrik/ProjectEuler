import java.util.Arrays;

public class Problem38 extends Problem{
    @Override
    public void solve() {
        System.out.print(largestPanConcatProd());
    }

    int largestPanConcatProd(){
        int max = 1;
        for (int n = 2; n <= 9; n++) {
            int exp = 9/n;
            for (int i = 1; i < Math.pow(10, exp); i++) {
                StringBuilder concat = new StringBuilder();
                for (int j = 1; j <= n; j++) concat.append(i * j);
                if (isPandigital(concat.toString()))
                    max = Math.max(Integer.parseInt(concat.toString()), max);
            }
        }
        return max;
    }

    boolean isPandigital(String s){
        if(s.length() != 9) return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars).equals("123456789");
    }
}
