import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Perceptron
{
    List<List<Double>> Xtraining_Set= new ArrayList();
    List<Integer> Ytraining_Set= new ArrayList();
    private final int training_Size=1000;
    private final int Sizefen=10;
    public Random rand= new Random();
    int Dimension=2;
    int ax; // hyperplan en 2D = equation de droite ax+b
    int b;

    public Perceptron(int ax, int b) {
        this.ax = ax;
        this.b = b;
    }

    public void CreateTrainingSet(){
        for(int i=0;i<training_Size;i++){
            List<Double> newPoint= new ArrayList();
            newPoint.add(1.0); // Ajout du biais
            for(int y=0;y<Dimension;y++){
                newPoint.add(rand.nextDouble()*Sizefen);
            }
            addPointTotrain(newPoint);
        }
    }
    public void addPointTotrain(List<Double> p){
        Xtraining_Set.add(p);
        if(pointIn(p)){
            Ytraining_Set.add(1);
        }else{
            Ytraining_Set.add(-1);
        }
    }
    public Boolean pointIn(List<Double> p){
        if(ax*p.get(1)+b<p.get(2)){ // si ax+b<y
            return true;
        }else{
            return false;
        }
    }

    public List<Double> fit(){
        List<Double> W= new ArrayList<>();
        W.add(0.0);//biais
        for(int i=0;i<Dimension;i++){// Initialisation
            W.add(0.0);
        }
        while(true){
            Boolean ErreurFound=false;
            for(int i=0;i<Xtraining_Set.size();i++){
                List<Double> x=Xtraining_Set.get(i);
                int y=Ytraining_Set.get(i);
                int predict=predict(W,x);
                if(predict !=y){
                    W=ajusterW(W,x,y); // ajustement de W
                    ErreurFound=true;
                }
            }
            if(!ErreurFound){
                break;
            }
        }
        return W;
    }
    public int predict(List<Double> W,List<Double> point){
        int predict;
        if(produitScalaire(point,W)>=0){
            predict=1;
        }else{
            predict=-1;
        }
        return predict;
    }
    private double produitScalaire(List<Double> l1,List<Double> l2){
        double somme=0.0;
        for(int i=0;i<l1.size();i++){
            somme+=l1.get(i)*l2.get(i);
        }
        return somme;
    }
    private List<Double> ajusterW(List<Double> W ,List<Double>point,int sign){
        for(int i=0;i<W.size();i++){
            W.set(i,W.get(i)+(point.get(i)*sign));
        }
        return W;
    }

    public List<Double> getEquationFromW(List<Double> W){
        double b= W.get(0)/W.get(2);
        double x= W.get(1)/W.get(2);
        List<Double> result=new ArrayList<>();
        result.add(b*-(1));
        result.add(x*(-1));
        return result;
    }
}
