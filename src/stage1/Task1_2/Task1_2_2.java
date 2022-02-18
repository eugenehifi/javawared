package stage1.Task1_2;

import java.util.Scanner;

public class Task1_2_2 {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Введите произвольный текст, содержащий не только буквы, но цифры и другие символы :");
        String text = scanner.nextLine();
        char[]textArray = text.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < textArray.length; i++) {
            if (Character.isLetter(textArray[i])) {
                builder.append(text.charAt(i));
            } else if (textArray[i] == ' '){
                builder.append(text.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
}

