public class Problem41 extends Problem{
    @Override
    public void solve() {
        System.out.print(findPanPrime());
    }

    int findPanPrime(){
        for (int n = 9; n >= 1; n--) {
            int[] digits = new int[n];
            for (int i = 1; i <= digits.length; i++)digits[i-1] = i;

            int result = 0;
            do {
                int num = arrToInt(digits);
                if (isPrime(num))result = num;
            } while (permute(digits));
            if (result != 0)return result;
        }
        return 0;
    }

    int arrToInt(int[] is){
        int result = 0;
        for (int x : is)result = result * 10 + x;
        return result;
    }

    boolean isPrime(int k){
        if(k <= 1)return false;
        if(k == 2 || k == 3)return true;
        if(k%2 == 0 || k%3 == 0)return false;

        for(int i = 5; i*i <= k; i = i + 6){
            if(k % i == 0 || k % (i + 2) == 0)return false;
        }
        return true;
    }

    //this confuses me tbh but it's fast
    static boolean permute(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i <= 0)
            return false;
        {
            int j = arr.length - 1;
            while (arr[j] <= arr[i - 1]) j--;
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
        }
        for (int j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return true;
    }
}
