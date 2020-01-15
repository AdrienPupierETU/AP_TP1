import java.util.Random;

import static java.lang.Math.pow;

public class piNeedle {
    public static final int length=1;
    public static final int N=1_000_000;
    public static Random rand= new Random();
    public static int SizeRoom=1_000_000;

    public static void calc(){
        double nbCroise=0;
        for(int i=0;i<N;i++){
            double X1=rand.nextDouble()*SizeRoom;
            double Y1=rand.nextDouble()*SizeRoom;
            double angle=rand.nextDouble()*100_000_000;
            double X2=length*Math.cos(angle) +X1;
            double Y2=length*Math.sin(angle) +Y1;
            double test=Math.sqrt(pow(X1-X2,2)+pow(Y1-Y2,2));

            assert Math.floor(test)==length;

            if(Math.floor(X1/length)!=Math.floor(X2/length)){
                nbCroise++;
            }
        }
        System.out.println("Pi : "+2/(nbCroise/N));
    }
}
