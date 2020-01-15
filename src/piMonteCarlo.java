import java.util.Random;

import static java.lang.Math.pow;

public class piMonteCarlo {

    public static final int N=1_000_000;
    public static final int R=1;
    public static final int L=2*R;
    public static int centerCircle=L/2;
    public static Random rand= new Random();
    public static void calc() {
        double nbInCircle = 0;
        for (int i = 0; i < N; i++) {
            double Randx = rand.nextDouble() * L;
            double Randy = rand.nextDouble() * L;
            if (Math.sqrt(pow(centerCircle - Randx, 2) + pow(centerCircle - Randy, 2)) <= R) {
                nbInCircle++;
            }
        }
        System.out.println("pi : " + (nbInCircle / (N)) * (L * L));
    }

}
