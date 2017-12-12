import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Population {

    private ArrayList<Individu> membres;

    private final int TAILLE = 15; //taille de la population de base
    private final int NBSELECT = 6; // nombre d'individus qu'on séléctionne après les op


    public Population(Tache[] taches){
        membres= new ArrayList<>(TAILLE);
        for(int i=0; i<TAILLE; i++){
            Tache[] copi = taches.clone();
            shuffleArray(copi);
            membres.add(new Individu(copi));

        }
    }

    // Implementing Fisher–Yates shuffle
    private void shuffleArray(Tache[] ar)
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

    public ArrayList<Individu> getMeilleurs() {
        this.trier();
        ArrayList<Individu> meilleurs = new ArrayList<Individu>(NBSELECT);
        for(int i=0; i<NBSELECT; i++){
            meilleurs.add(i, membres.get(i));
        }
        return meilleurs;
    }

    public ArrayList<Individu> reproduire(ArrayList<Individu> parents){
        ArrayList<Individu> enfants = new ArrayList<>(parents.size());
        Collections.shuffle(parents);
        for(int i=0; i<parents.size();i+=2){ //gerer cas où nb parent impair
            HashMap<String, Tache> gM = parents.get(i).getListeTaches();
            HashMap<String, Tache> gP = parents.get(i+1).getListeTaches();
            int randM = (int)Math.random() * gM.size()+1;
            int randP = (int)Math.random() * gP.size()+1;
            Tache[] listeEnfant = this.faireEnfant(gM, randM,randP);
            enfants.add(i ,new Individu(listeEnfant));
            listeEnfant = this.faireEnfant(gP, randP,randM);
            enfants.add(i+1, new Individu(listeEnfant));
        }
        return enfants;
    }
    private Tache[] faireEnfant(HashMap<String, Tache> parent, int pos, int pos2){
        Tache[] res = parent.values().toArray(new Tache[parent.values().size()]);
        res[pos]  =parent.get(String.valueOf(pos2));
        res[pos2] = parent.get(String.valueOf(pos));
        return res;
    }
    private void trier(){
        Collections.sort(membres);
    }


}

