import java.util.Random;

public class eSmallest {

    public static Random rand= new Random();
    public static final int N=1_000_000;

    public static void calc(){
        double Sum=0;
        for(int i=0;i<N;i++){
            Sum+=tirage();
        }
        System.out.println("e smallest : " +Sum/N);
    }

    private static int tirage(){
        double sum=0;
        int nbTire=0;
        while(sum<=1){
            nbTire++;
            sum+=rand.nextDouble()*1;
        }
        return nbTire;
    }
}
