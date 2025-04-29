package com.daft.euler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem22 extends Problem{
    @Override
    public void solve(){
        System.out.print(sumNameScores());
        System.out.print("\nFile reading time: " + fileReadTime + " ms");
    }

    ArrayList<String> names = new ArrayList<String>();
    long fileReadTime;

    long sumNameScores(){
        final long startTime = System.nanoTime();
        readFile();
        final long endTime = System.nanoTime();
        fileReadTime = (endTime - startTime)/1000000;

        Collections.sort(names);
        long sum = 0;
        for (int i = 0; i < names.size(); i++) {
            sum += nameScore(names.get(i), i);
        }
        return sum;
    }

    int nameScore(String s, int pos){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sum += ch - 'A' + 1;
        }
        return (pos + 1) * sum;
    }

    void readFile() {
        Scanner in;
        try {
            in = new Scanner(new File("names.txt")).useDelimiter("[\",]+");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (in.hasNext()) {
            names.add(in.next());
        }
    }
}
