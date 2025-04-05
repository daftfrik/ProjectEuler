public class Problem4 extends Problem{
    @Override
    public void solve(){
        System.out.print(lpProduct(100, 1000));
    }

    public int lpProduct(int min, int max){
        int lpp = 0;
        for(int i = min; i < max; i++){
            for(int j = min; j < max; j++){
                int result = i * j;
                if(result > lpp){
                    String s1 = result + "";
                    String s2 = reverseString(s1);
                    if(s1.equals(s2)) lpp = result;
                }
            }
        }
        return lpp;
    }

    String reverseString(String str){
        StringBuffer sbf = new StringBuffer(str);
        return sbf.reverse().toString();
    }
}
