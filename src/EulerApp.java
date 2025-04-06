import java.util.Scanner;

public class EulerApp {
    int solvedProblems = 42;
    int problemToRun;
    boolean runAll = false;
    long timeForAll = 0L;

    public static void main(String[] args){
        EulerApp app = new EulerApp();
        app.processInput(app, app.getInput());
    }

    Problem getProblem(int n){
        return switch (n) {
            case 1 -> new Problem01();
            case 2 -> new Problem02();
            case 3 -> new Problem03();
            case 4 -> new Problem04();
            case 5 -> new Problem05();
            case 6 -> new Problem06();
            case 7 -> new Problem07();
            case 8 -> new Problem08();
            case 9 -> new Problem09();
            case 10 -> new Problem10();
            case 11 -> new Problem11();
            case 12 -> new Problem12();
            case 13 -> new Problem13();
            case 14 -> new Problem14();
            case 15 -> new Problem15();
            case 16 -> new Problem16();
            case 17 -> new Problem17();
            case 18 -> new Problem18();
            case 19 -> new Problem19();
            case 20 -> new Problem20();
            case 21 -> new Problem21();
            case 22 -> new Problem22();
            case 23 -> new Problem23();
            case 24 -> new Problem24();
            case 25 -> new Problem25();
            case 26 -> new Problem26();
            case 27 -> new Problem27();
            case 28 -> new Problem28();
            case 29 -> new Problem29();
            case 30 -> new Problem30();
            case 31 -> new Problem31();
            case 32 -> new Problem32();
            case 33 -> new Problem33();
            case 34 -> new Problem34();
            case 35 -> new Problem35();
            case 36 -> new Problem36();
            case 37 -> new Problem37();
            case 38 -> new Problem38();
            case 39 -> new Problem39();
            case 40 -> new Problem40();
            case 41 -> new Problem41();
            case 42 -> new Problem42();
            case 43 -> new Problem43();
            case 44 -> new Problem44();
            case 45 -> new Problem45();
            default -> new Problem();
        };
    }

    String getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Project Euler Solver");
        String input;
        while(true){
            System.out.print("\nEnter problem to solve (1 - " + solvedProblems + ") or 'a' to solve all problems: ");
            input = scanner.nextLine();
            if(isNumber(input)) return input;
            if(input.equals("a")) {
                runAll = true;
                return input;
            }
        }
    }

    void processInput(EulerApp ea, String input){
        if(ea.isNumber(input)){
            ea.runProblem(problemToRun);
        }else if(runAll){
            for(int i = 1; i <= solvedProblems; i++) ea.runProblem(i);
        }
    }

    void runProblem(int n){
        Problem p = getProblem(n);
        System.out.print("Problem " + n + " Solution: ");
        final long startTime = System.nanoTime();
        p.solve();
        final long endTime = System.nanoTime();
        long executionTime = (endTime - startTime)/1000000;
        System.out.println("\nTotal execution time: " + executionTime + " ms\n");
        if(runAll){
            timeForAll += executionTime;
            if(n == solvedProblems){
                System.out.println("\nTotal execution time for all problems: " + timeForAll + " ms ");
                System.out.println("Average execution time: " + timeForAll/solvedProblems + " ms");
            }
        }
    }

    boolean isNumber(String s){
        if(s == null)return false;
        try{
            problemToRun = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
