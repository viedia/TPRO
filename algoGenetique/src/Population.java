import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Population {

    private ArrayList<Individu> membres;

    private final int TAILLE = 30; //taille de la population de base
    private final int NBSELECT = 11; // nombre d'individus qu'on séléctionne après les op
    private final double PROBAMUTATION = 0.3;


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
        if(parents.size() % 2 == 0) { //si le nombre de parents est pair
            for (int i = 0; i < parents.size(); i += 2) { //gerer cas où nb parent impair
                acte(parents, enfants, i);
            }
        }else{
            for (int i = 0; i < parents.size()-1; i += 2) { //gerer cas où nb parent impair
                acte(parents, enfants, i);
            }
        }
        return enfants;
    }

    private void acte(ArrayList<Individu> parents, ArrayList<Individu> enfants, int index){
        Random rnd = ThreadLocalRandom.current();
        HashMap<String, Tache> gM = parents.get(index).getListeTaches();
        HashMap<String, Tache> gP = parents.get(index + 1).getListeTaches();
        int randM = rnd.nextInt(gM.size());
        int randP = rnd.nextInt(gP.size());
        Tache[] listeEnfant = this.faireEnfant(gM, randM, randP);
        enfants.add(index, new Individu(listeEnfant));
        listeEnfant = this.faireEnfant(gP, randP, randM);
        enfants.add(index + 1, new Individu(listeEnfant));
    }

    private Tache[] faireEnfant(HashMap<String, Tache> parent, int pos, int pos2){
        Tache[] res = parent.values().toArray(new Tache[parent.values().size()]);
        res[pos]  =parent.get(String.valueOf(pos2));
        res[pos2] = parent.get(String.valueOf(pos));
        Random rand = ThreadLocalRandom.current();
        double proba = rand.nextDouble();
        if(proba<PROBAMUTATION){
            mutation(res);
        }
        return res;
    }
    private void trier(){
        Collections.sort(membres);
    }

    private void mutation(Tache[] enfant){
        Random rand = ThreadLocalRandom.current();
        int numGen=rand.nextInt(enfant.length);
        int nouvellePosition = rand.nextInt(enfant.length);
        Tache temp = enfant[numGen];
        enfant[numGen] = enfant[nouvellePosition];
        enfant[nouvellePosition] = temp;
    }

    public void renouvellementPopulation(ArrayList<Individu> nouveau) {
        for(int i=0; i<nouveau.size(); i++){
            membres.set(membres.size()-(nouveau.size()-i)-1, nouveau.get(i));
        }
    }
}

