package com.daft.euler;

import java.util.Scanner;

import static java.lang.System.*;


public class EulerApp {
    int solvedProblems = 50;
    boolean runAll = false;
    long timeForAll = 0;

    public static void main(String[] args) {
        EulerApp app = new EulerApp();
        out.print("Project Euler Solver");
        app.processInput(app, app.getInput());
    }

    String getInput() {
        Scanner scanner = new Scanner(in);
        String input = null;

        do {
            out.print("\nEnter problem to solve (1 - " +
                    solvedProblems + ") or 'a' to solve all problems: ");
            input = scanner.nextLine();
        } while (!isValidInput(input));

        return input;
    }

    void processInput(EulerApp ea, String input) {
        if(input.equals("a")) {
            runAllProblems();
        }else{
            int problemNum = Integer.parseInt(input);
            runProblem(problemNum);
        }
    }

    void runAllProblems(){
        out.println("Solving all problems...");
        final long startTime = nanoTime();
        for(int i = 1; i <= solvedProblems; i++)runProblem(i);
        final long endTime = nanoTime();
        long executionTime = (endTime - startTime) / 1000000;

        out.println("\nTotal execution time for all problems: " + executionTime + " ms ");
        out.println("Average execution time: " + executionTime / solvedProblems + " ms");
    }

    void runProblem(int n) {
        Problem p = getProblem(n);
        out.print("Problem " + n + " Solution: ");
        final long startTime = nanoTime();
        p.solve();
        final long endTime = nanoTime();
        long executionTime = (endTime - startTime) / 1000000;
        out.println("\nTotal execution time: " + executionTime + " ms\n");
    }

    Problem getProblem(int n) {
        String num = (n < 10) ? "0" + n : "" + n;
        Problem p;
        try {
            p = (Problem) Problem
                    .class.getClassLoader()
                    .loadClass("com.daft.euler.Problem" + num)
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    boolean isValidInput(String s) {
        if (s == null) return false;
        try {
            int temp = Integer.parseInt(s);
            if(temp <= 0 || temp > solvedProblems)return false;
        } catch (NumberFormatException e) {
            return s.equals("a");
        }
        return true;
    }
}
