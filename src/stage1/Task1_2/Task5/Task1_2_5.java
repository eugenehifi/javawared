package stage1.Task1_2.Task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] textArray = text.split(" ");
        Sentence sentence = new Sentence(textArray);
        System.out.println("Модель создана.");
    }
}
