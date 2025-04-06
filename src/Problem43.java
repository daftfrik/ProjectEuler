import java.math.BigInteger;
import java.util.Arrays;

public class Problem43 extends Problem{
    @Override
    public void solve() {
        System.out.print(sumSSDPan());
    }
    int[] tests = {2, 3, 5, 7, 11, 13, 17};

    long sumSSDPan(){
        int[] arr = new int[10];
        Arrays.setAll(arr, i -> i);
        long sum = 0;
        do{
            if(testPerm(arr))sum += arrToLong(arr);
        }while(permute(arr));
        return sum;
    }

    boolean testPerm(int[] arr){
        if(arr[0] == 0)return false;
        for(int i = 0; i < tests.length; i++){
            int d = abcToInt(arr[i+1], arr[i+2], arr[i+3]);
            if(d % tests[i] != 0) return false;
        }
        return true;
    }

    int abcToInt(int a, int b, int c){
        String s = "" + a + b + c;
        return Integer.parseInt(s);
    }

    long arrToLong(int[] is){
        long result = 0;
        for(int x : is)result = result * 10 + x;
        return result;
    }

    //this confuses me tbh but it's fast
    static boolean permute(int[] arr) {
        int i = arr.length - 1;
        while(i > 0 && arr[i - 1] >= arr[i]) i--;
        if(i <= 0)return false;
        {
            int j = arr.length - 1;
            while(arr[j] <= arr[i - 1]) j--;
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
        }
        for(int j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return true;
    }
}
