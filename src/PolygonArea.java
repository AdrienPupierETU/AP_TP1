import CircularList.CircularList;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PolygonArea {
    private int L;
    private int FAR;
    private int N =1000000;
    public CircularList list = new CircularList();
    Scanner scan = new Scanner(System.in);
    public static Random rand= new Random();
    public void calc(){
        CreatePolygon();
        System.out.println("Aire Polygon Par monteCarlo = "+monteCarlo());
        System.out.println("Aire Polygon Par shoelace = "+shoelace());
    }


    private double monteCarlo(){
        double nbIn=0;
        for(int i=0;i<N;i++){
            Point2D p = new Point2D.Double((rand.nextDouble()*L),(rand.nextDouble()*L));
            if(isInside(p)){
                nbIn++;
            }
        }
        return (nbIn/N)*L*L;
    }
    private double shoelace(){
        double Somme1=0;
        double Somme2=0;
        for(int i=0;i<list.size();i++){
            Somme1+=list.get(i).getX()*list.get(i+1).getY();
            Somme2+=list.get(i+1).getX()*list.get(i).getY();
        }
        return Math.abs((1.0/2.0)*(Somme1-Somme2));
    }

    private void CreatePolygon(){
        System.out.println("Entrez la taille du carré dans lequel est inscrit votre plygon");
        L=scan.nextInt();
        FAR=L*2;
        try{
            System.out.println("Vous allez entrez une suite de point, cette suite doit être dans l'ordre des points de votre polygone. ");
            while(true) {
                System.out.println("Pour quitter entrez n'importe quoi sauf un nombre");
                System.out.println("Enter X");
                String str = scan.next();
                double x = Integer.parseInt(str);
                System.out.println("Enter Y");
                double y = scan.nextInt();
                list.add(new Point2D.Double(x, y));
            }
        }catch(NumberFormatException e){
            System.out.println("Fin de la creation du polygon");
        }
    }

    /* On compte combien de fois on croise un segment */

    private boolean intersection(Point2D p1,Point2D p2, Point2D p3, Point2D p4 ){
        if(p1.equals(p3)||p1.equals(p4)||p2.equals(p3)||p2.equals(p4)){ // Point en commun cas particulier
            return true;
        }
        double pv1=produitVectoriel(p1,p2,p3,p4);
        if(pv1==0){ // droite parallele
            return false;
        }
        double pv2=produitVectoriel(p1,p2,p1,p4);
        double pv3=produitVectoriel(p1,p2,p1,p3);
        double pv4=produitVectoriel(p3,p4,p3,p2);
        double pv5=produitVectoriel(p3,p4,p3,p1);
        if(!(pv2*pv3<=0)){
            return false;
        }
        if(!(pv4*pv5<=0)){
            return false;
        }
        return true;
    }

    private double produitVectoriel(Point2D p1,Point2D p2, Point2D p3, Point2D p4) { // on prend que le dernier element du produit vectoriel car en 2D les deux premier =0
        double xv1 = p2.getX() - p1.getX();
        double xv2 = p4.getX() - p3.getX();
        double yv1 = p2.getY() - p1.getY();
        double yv2 = p4.getY() - p3.getY();

        return (xv1 * yv2) - (xv2 * yv1);
    }


    private boolean isInside(Point2D p){
        if(list.size()<3){ // not enough point
            return false;
        }
        Point2D extreme = new Point2D.Double(FAR, p.getY());
        // on test pour tout les segments 2 a 2
        int nbIntersec=0;
        for(int i=0;i<list.size();i++){
            if(intersection(list.get(i),list.get(i+1),p,extreme)){
                nbIntersec++;
            }
        }
        return nbIntersec%2==1;
    }
}
