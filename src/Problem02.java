public class Problem02 extends Problem{
    @Override
    public void solve(){
        System.out.print(evenFibSum(4000000));
    }

    public int evenFibSum(int limit){
        int sum = 0;
        int result = 0, fib1 = 0, fib2 = 1;
        while(result < limit){
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
            if(result % 2 == 0) sum += result;
        }
        return sum;
    }
}
