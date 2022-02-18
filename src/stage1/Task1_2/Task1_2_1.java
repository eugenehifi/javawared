package stage1.Task1_2;

import java.util.Scanner;

public class Task1_2_1 {
    public static int Fib(int n) {
        int previuosNum = 0;
        int nextNumb = 1;
        for (int i = 0; i < n; i++) {
            int oldPreviousNum = previuosNum;
            previuosNum = nextNumb;
            nextNumb = oldPreviousNum + nextNumb;
        }
        return previuosNum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println(" Введите число : ");
        int number = scn.nextInt();
        System.out.println(" Число Фибоначчи :  " + Fib(number));
    }
}
