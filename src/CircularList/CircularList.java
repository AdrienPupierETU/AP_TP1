package CircularList;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CircularList {
    private ArrayList<Point2D> list= new ArrayList<>();
    private int nbElement=0;

    public void add(Point2D p){
        list.add(p);
        nbElement++;
    }
    public Point2D get(int indice){
        return list.get(indice%nbElement);
    }
    public void remove(Point p){
        list.remove(p);
    }
    public int size(){
        return list.size();
    }
}
