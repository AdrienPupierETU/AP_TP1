import java.util.Random;
import static java.lang.Math.pow;
public class app {

    public static void main(String[] argv){
        System.out.println("Pi par MonteCarlo :");
        piMonteCarlo.calc();
        System.out.println("Pi par Needle :");
        piNeedle.calc();
        System.out.println("e par Smallest :");
        eSmallest.calc();
        System.out.println("e not Bigger :");
        eNotBigger.calc();
        PolygonArea poly= new PolygonArea();
        poly.calc();
    }
}
