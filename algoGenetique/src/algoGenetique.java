import java.util.Map;
class algoGenetique
{
    private Population population;


    public algoGenetique(Map<String, int[]> infos) {
        this.Initialisation(infos.get("nombre")[0],infos.get("reglage"),infos.get("temps"),infos.get("debut") );
    }

    private void Initialisation(int nb, int[] reglage, int[] temps, int[] debut) {
        int[][] reglages = new int[nb][nb];
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
        population = new Population(t, reglages);
        System.out.println(population.toString());
    }

}
//Initialisation des variables
    //Liste d'individus
    //Une population

//Fonction initialisation de la population
    //Boucle i à TaillePop
        //ajouter les nouveaux individus

//Focntion Selection

//Fonction Reproduction

//Fonction Mutations

//Supprimer les anciens parents

//Fonction Itérations (pour répéter le cycle)