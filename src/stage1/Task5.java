package stage1;

public class Task5 {
    public static void main(String[] args) {
        String text = " Hello World !";
        char[] s = text.toCharArray();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + "  " + ((int) s[i]));
        }
    }
}