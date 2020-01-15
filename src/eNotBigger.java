import java.util.Random;

public class eNotBigger {
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
        double last=1;
        int nbTire=0;
        while(true){
            nbTire++;
            double nouveau=rand.nextDouble()*1;
            if(last<nouveau) {
                break;
            }
            last=nouveau;
        }
        return nbTire;
    }
}

