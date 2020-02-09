import javafx.util.Pair;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectanglePAC {
    private double px;
    private double py;
    private double width;
    private double height;
    private final int NB_POINT =100000;
    private final int SizeFen=50;
    public Random rand= new Random();
    List<Point2D> listPoint= new ArrayList<>();
    List<Integer> listY= new ArrayList<>();
    public RectanglePAC(double px, double py, double width, double height) { // rectangle a deviner
        this.px = px;
        this.py = py;
        this.width = width;
        this.height = height;
    }
    public void generatePoint(){
        for(int i = 0; i< NB_POINT; i++){
            Point2D newPoint=new Point2D.Double(rand.nextDouble()* SizeFen,rand.nextDouble()* SizeFen);
            listPoint.add(newPoint);
            if(newPoint.getX()<=px+width &&newPoint.getX()>=px){ // In X
                if(newPoint.getY()<=py+height &&newPoint.getY()>=py){ // In Y
                    listY.add(1); // Point is In
                    continue;
                }
            }
            listY.add(-1);
        }
    }

    public Pair<Point2D,Point2D> calc(){
        double minX=listPoint.get(0).getX();
        double minY=listPoint.get(0).getY();
        double maxX=listPoint.get(0).getX();
        double maxY=listPoint.get(0).getY();
        for(int i=1;i<listPoint.size();i++){
            if(listY.get(i)!=1){
                continue;
            }
            Point2D courant = listPoint.get(i);
            if(courant.getX()<minX){
                minX=courant.getX();
            }else if(courant.getX()>maxX){
                maxX=courant.getX();
            }
            if(courant.getY()<minY){
                minY=courant.getY();
            }else if(courant.getY()>maxY){
                maxY=courant.getY();
            }
        }
        return new Pair(new Point2D.Double(minX,minY),new Point2D.Double(maxX,maxY));
    }
}
