import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem42 extends Problem{
    @Override
    public void solve() {
        //System.out.print(isTriangle(wordValue("SKY")));
        System.out.print(countWordScoreTriangleNums());
        System.out.print("\nFile reading time: " + fileReadTime + " ms");
    }

    long fileReadTime;
    ArrayList<String> words = new ArrayList<>();

    int countWordScoreTriangleNums(){
        final long startTime = System.nanoTime();
        readFile();
        final long endTime = System.nanoTime();
        fileReadTime = (endTime - startTime)/1000000;

        int count = 0;
        for(String word: words) {
            if(isTriangle(wordValue(word))) {
                count++;
            }
        }
        return count;
    }

    int wordValue(String s){
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            result += c - 'A' + 1;
        }
        return result;
    }

    boolean isTriangle(int x) {
        for (int i = 1; ; i++) {
            int t = i * (i + 1) / 2;
            if (t == x)
                return true;
            if (t > x)
                return false;
        }
    }

    void readFile() {
        Scanner in;
        try {
            in = new Scanner(new File("words.txt")).useDelimiter("[\",]+");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(in.hasNext()) words.add(in.next());
    }
}
