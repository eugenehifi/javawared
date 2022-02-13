package stage1;

public class Task7 {
    public static void main(String[] args) {
        int n = 100;
        for (int i = 100; i > 0; i--) {
            if ((i % 10) > 1 & (i % 10) < 5) {
                System.out.println(i + " Бутылки стояли на столе, одна из них упала и разбилась.");
            } else if (i == 1 | i % 10 == 1) {
                System.out.println(i + " Бутылка стояла на столе, одна из них упала и разбилась.");
            } else {
                System.out.println(i + " Бутылок стояло на столе, одна из них упала и разбилась.");
            }
        }
    }
}
