import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population {

    private Individu[] membres;
    private int taille = 15;

    public Population(Tache[] taches, int[][] reglages){
        membres= new Individu[taille];
        for(int i=0; i<taille; i++){
            Tache[] copi = taches.clone();
            shuffleArray(copi);
            membres[i] = new Individu(copi, reglages);

        }
    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(Tache[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Tache a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    @Override
    public String toString(){
        String affichahge="";
        for(Individu i : membres){
            affichahge +=i.toString()+"\n";
        }
        return affichahge;
    }
}

