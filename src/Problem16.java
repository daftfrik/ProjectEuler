import java.math.BigInteger;

public class Problem16 extends Problem{
    @Override
    public void solve(){
        System.out.print(exponentSum(1000));
    }

    int exponentSum(int exponent){
        BigInteger base = BigInteger.valueOf(2);
        BigInteger result = base.pow(exponent);
        String number = result.toString();
        return sumStringDigits(number);
    }

    int sumStringDigits(String s){
        String temp;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            temp = "" +ch;
            sum += Integer.parseInt(temp);
        }
        return sum;
    }
}
