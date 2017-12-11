import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Population {

    private ArrayList<Individu> membres;
    private int taille = 15;
    private final int NBSELECT = 20;

    public Population(Tache[] taches, int[][] reglages){
        membres= new ArrayList<>(taille);
        for(int i=0; i<taille; i++){
            Tache[] copi = taches.clone();
            shuffleArray(copi);
            membres.add(new Individu(copi, reglages));

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

    public Individu[] getMeilleurs() {
        this.trier();
        Individu[] meilleurs = new Individu[NBSELECT];
        for(int i=0; i<NBSELECT; i++){
            meilleurs[i] = membres.get(i);
        }
        return meilleurs;
    }

    private void trier(){
  /*      ArrayList<Individu> temp = new ArrayList<>();
        for(Individu i : membres){
            temp.add(i);
        }*/
      //  System.out.println(temp.toString());
        Collections.sort(membres);
//        System.out.println(temp.toString());

    }

}

