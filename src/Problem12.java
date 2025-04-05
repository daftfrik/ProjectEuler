public class Problem12 extends Problem{
    @Override
    public void solve(){
        System.out.print(highDivTri(500));
    }

    long highDivTri(int n){
        int triN = 0, triangle = 0;
        while(true){
            triN++;
            triangle += triN;
            if(divCount(triangle) > n)return triangle;
        }
    }

    int divCount(long n){
        int total = 0;
        int end = (int) Math.sqrt(n);
        for(int i = 1; i <= end; i++){
            if(n % i == 0){
                total += 2;
            }
        }
        return total;
    }
}
