import java.util.List;
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
        //PolygonArea poly= new PolygonArea();
        //poly.calc();
        Perceptron perceptron= new Perceptron(2,2); // l'equation a approximé
        System.out.println("HyperPlan Separateur par perceptron :");
        perceptron.CreateTrainingSet();
        List<Double> W=perceptron.fit();
        System.out.println("Vecteur norme Hyper Plan :" +W.toString());
        List<Double> result= perceptron.getEquationFromW(W);
        System.out.println(result.get(1)+"x +"+result.get(0)+" <y");
    }
}
