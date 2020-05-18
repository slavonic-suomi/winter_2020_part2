package by.gsu.winter20.utils;

import java.util.Scanner;

public class ScannerWrapper {

    private Scanner sc = new Scanner(System.in);

    public String nextLine() {
        return sc.nextLine();
    }

    public int nextInt() {
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }

    public int nextInt(int from, int to) {
        int result = from - 1;
        while (result < from || result > to) {
            result =  nextInt();
        }
        return result;
    }
}
