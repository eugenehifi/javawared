package stage1;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        text = text.replaceAll(" ", "").toLowerCase();
        char[] ch = text.toCharArray();
        char frontChar;
        char backChar;
        int backIndex = ch.length - 1;
        boolean same = true;
        for (int i = 0; i < ch.length; i++) {
            if ((ch.length % 2 == 0) | i == backIndex) {
            }
            frontChar = ch[i];
            backChar = ch[backIndex - i];
            if (frontChar != backChar) {
                same = false;
                break;
            }
        }
        if (same) {
            System.out.println("Это палиндром!");
        } else {
            System.out.println("Это не палиндром!");
        }
    }
}
