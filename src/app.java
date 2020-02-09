import javafx.util.Pair;

import java.awt.geom.Point2D;
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
        PolygonArea poly= new PolygonArea();
        poly.calc();
        Perceptron perceptron= new Perceptron(2,2); // l'equation a approximé
        System.out.println("HyperPlan Separateur par perceptron :");
        perceptron.CreateTrainingSet();
        List<Double> W=perceptron.fit();
        System.out.println("Vecteur norme Hyper Plan :" +W.toString());
        List<Double> result= perceptron.getEquationFromW(W);
        System.out.println(result.get(1)+"x +"+result.get(0)+" <y");
        System.out.println("Pac rectangle");
        RectanglePAC rac= new RectanglePAC(2,2,20,20);
        rac.generatePoint();
        Pair<Point2D,Point2D> p=rac.calc();
        System.out.println("Retangle de point d'origine "+ p.getKey().getX()+" x "+p.getKey().getY()+" y "+
                "et de largeur "+(p.getValue().getX()-p.getKey().getX())+" et de hauteur "+(p.getValue().getY()-p.getKey().getY()));
    }
}
