package com.daft.euler;
public class Problem17 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumSumsUnderN(1000));
    }

    String[] units = {
            "",        "One",       "Two",      "Three",
            "Four",    "Five",      "Six",      "Seven",
            "Eight",   "Nine",      "Ten",      "Eleven",
            "Twelve",  "Thirteen",  "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    String[] tens = {
            "",     "",     "Twenty",  "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    String[] multiplier =
            {"", "Thousand", "Million", "Billion"};

    String convertToWords(int n){
        StringBuilder res = new StringBuilder();
        int group = 0;
        if(n == 0)return "Zero";
        while(n > 0){
            if(n % 1000 != 0){
                int value = n % 1000;
                String temp = "";
                if(n >= 100){
                    temp += units[value/100] + " Hundred ";
                    value %= 100;
                    if(value > 0)temp += "and ";
                }
                if(value >= 20){
                    temp += tens[value/10] + " ";
                    value %= 10;
                }
                if(value > 0)temp += units[value] + " ";
                temp += multiplier[group] + " ";
                res.insert(0, temp);
            }
            n /= 1000;
            group++;
        }
        return res.toString().trim();
    }

    int sumLetters(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ')count++;
        }
        return count;
    }

    int sumSumsUnderN(int n){
        int count = 0;
        for(int i = 1; i <= n; i++){
            count += sumLetters(convertToWords(i));
        }
        return count;
    }
}
