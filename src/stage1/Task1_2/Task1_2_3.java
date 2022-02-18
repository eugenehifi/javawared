package stage1.Task1_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2_3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println(" Введите свой текст : ");
        String text = scn.nextLine();
        String[] textArray = text.split(" ");
        System.out.println(" Введите номер символа,который хотите заменить :  ");
        int pos = scn.nextInt();
        System.out.println(" Введите новый символ для замены :");
        char newSymbol = scn.next().charAt(0);


        StringBuilder builder = new StringBuilder();
        ArrayList<String> replaceSymbol = new ArrayList<>();
        for (String words : textArray) {
            if (pos < words.length()) {
                builder.append(words);
                builder.setCharAt(pos, newSymbol);
                replaceSymbol.add(builder.toString());
                builder.setLength(0);
            } else {
                replaceSymbol.add(words);
            }
        }
        for (String word : replaceSymbol) {
            System.out.print(word + " ");
        }
    }
}
