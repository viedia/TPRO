import java.util.ArrayList;
import java.util.Map;
class algoGenetique
{
    private Population population;
    private final int NBGENERATION = 500;

    public algoGenetique(Map<String, int[]> infos) {
        this.Initialisation(infos.get("nombre")[0],infos.get("reglage"),infos.get("temps"),infos.get("debut") );
        for (int g=0; g<NBGENERATION; g++) {
            System.out.println("#######GENERATION "+g+"########");
            ArrayList<Individu> parent = this.selection();
            System.out.println("Le meilleur parcours est : \n"+parent.get(0).toString()+" en "+parent.get(0).getTemps());
            this.reproduction(parent);
        }
    }

    private void Initialisation(int nb, int[] reglage, int[] temps, int[] debut) {
        int[][] reglages = new int[nb][nb];
        Individu.setReglages(reglages);
        Tache[] t = new Tache[nb];
        for(int i = 0; i<nb; i++) //boucle initialisation Taches et reglage
        {
            t[i] = new Tache(i, temps[i], debut[i]);
            //    System.out.println(t[i].toString());
            for(int j=0; j<nb;j++){ //init matrice reglage
                reglages[i][j] = reglage[nb*i+j];
                //      System.out.println( reglage[nbTache*i+j]);
            }
        }
        population = new Population(t);
        //System.out.println(population.toString());
    }

    private ArrayList<Individu> selection(){
        ArrayList<Individu> meilleurs =  population.getMeilleurs();
        return meilleurs;
    }

    private ArrayList<Individu> reproduction(ArrayList<Individu> parents){
        ArrayList<Individu> nouveau = population.reproduire(parents);
        population.renouvellementPopulation(nouveau);
        //System.out.println(nouveau);
        return nouveau;
    }

}
//Initialisation des variables
    //Liste d'individus OK
//Une population OK

//Fonction initialisation de la population ok
    //Boucle i à TaillePop
        //ajouter les nouveaux individus

//Focntion Selection

//Fonction Reproduction

//Fonction Mutations

//Supprimer les anciens parents

//Fonction Itérations (pour répéter le cycle)