package stage1;

public class Task4 {
    public static void main(String[] args) {
        int[] myArray = new int[30];
        for (int i = 0; i < 30; i++) {
            if (i % 10 == 0 && i != 0)
                System.out.println();
            System.out.print(i + " ");
        }
    }
}


