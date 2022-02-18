package stage1.Task1_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2_4 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.println(" Введите, пожалуйста, ваш текст : ");
        String text = scr.nextLine();
        Task1_2_4.searchLongAndShortWords(text);
    }


    static void searchLongAndShortWords(String text) {

        String[] words = text.split(" ");
        ArrayList<String> shortWords = new ArrayList<String>();
        ArrayList<String> longWords = new ArrayList<String>();
        int maxLength = words[0].length();
        int minLength = words[0].length();
        for (String word : words) {
            if (maxLength < word.length()) {
                maxLength = word.length();
            }
            if (minLength > word.length()) {
                minLength = word.length();
            }
        }

        for (String word : words) {
            if (maxLength == word.length()) {
                longWords.add(word);

            }
            if (minLength == word.length()) {
                shortWords.add(word);
            }
        }
        System.out.println(" Самые короткие слова в вашем тексте :");
        System.out.println(" " + shortWords);
        System.out.println(" Самые длинные слова вашем тексте :");
        System.out.println(" " + longWords);
    }
}

