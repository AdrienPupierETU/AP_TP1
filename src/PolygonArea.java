import CircularList.CircularList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PolygonArea {
    private static int FAR=100000000;
    private int L;
    public CircularList list = new CircularList();
    Scanner scan = new Scanner(System.in);
    public void calc(){
        CreatePolygon();

    }
    private void CreatePolygon(){
        System.out.println("Entrez la taille du carré dans lequel est inscrit votre plygon");
        L=scan.nextInt();
        try{
            System.out.println("Vous allez entrez une suite de point, cette suite doit être dans l'ordre des points de votre polygone. ");
            while(true) {
                System.out.println("Pour quitter entrez n'importe quoi sauf un nombre");
                System.out.println("Enter X");
                String str = scan.next();
                int x = Integer.parseInt(str);
                System.out.println("Enter Y");
                int y = scan.nextInt();
                list.add(new Point(x, y));
            }
        }catch(NumberFormatException e){
            System.out.println("Fin de la creation du polygon");
        }
    }


    /* On compte combien de fois on croise un segment */

    private boolean intersection(Point p1,Point p2, Point p3, Point p4 ){
        double A1 = (p1.y-p2.y)/(p1.x-p2.x);
        double A2 = (p3.y-p4.y)/(p3.x-p4.x);
        double b1 = p1.y-A1*p1.x ;
        double b2 = p3.y-A2*p3.x ;
        if (A1 == A2) return false ; //paralelle


        return true;
    }

    private boolean isInside(Point p){
        if(list.size()<3){ // not enough point
            return false;
        }
        Point extreme = new Point(FAR, p.y);
        // on test pour tout les segments 2 a 2
        int nbIntersec=0;
        for(int i=0;i<list.size();i++){

        }



        return false;
    }
}
