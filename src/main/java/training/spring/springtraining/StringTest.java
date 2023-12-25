package training.spring.springtraining;

public class StringTest {

    public static void main(String[] args) {
        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            // String stringLoc = String.format("osman%ddeneme%d", i , i);

            String stringLoc = "osman" + i + "deneme" + i;
        }
        System.out.println("Delta : " + (System.currentTimeMillis() - delta));

    }

}
