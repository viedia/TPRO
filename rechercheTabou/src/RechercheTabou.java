import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RechercheTabou {
    private Solution meilleur;
    private int nbTache;
    private int[][] reglages;
    private ArrayList<int[]> tabou;

    public RechercheTabou(Map<String, int[]> infos) {
        this.Initialisation(infos.get("nombre")[0],infos.get("reglage"),infos.get("temps"),infos.get("debut") );
    }

    private void Initialisation(int nb, int[] reglage, int[] temps, int[] debut){
        tabou = new ArrayList<>();
        nbTache = nb;
        Tache[] t = new Tache[nbTache];
        reglages = new int[nbTache][nbTache];
        for(int i = 0; i<nbTache; i++) //boucle initialisation Taches et reglage
        {
            t[i] = new Tache(i, temps[i], debut[i]);
        //    System.out.println(t[i].toString());
            for(int j=0; j<nbTache;j++){ //init matrice reglage
                this.reglages[i][j] = reglage[nbTache*i+j];
          //      System.out.println( reglage[nbTache*i+j]);
            }
        }
        meilleur = new Solution();
        Solution.setReglages(reglages);
        meilleur.majListe(t);
        System.out.println(meilleur.toString());
    }

    public void iteration(){
        int[] echange = selectionEchange();
        meilleur = new Solution(meilleur.inverser(echange[0], echange[1]));
        System.out.println(meilleur);
    }
    ///
    /// tabous non implémenter
    ///
    private int[] selectionEchange(){
        int[] couple = new int[2];
        Solution temp = null;
        int meilleurTps = meilleur.getTemps();
        for(int i=0; i<nbTache-1; i++){
            for(int j=0; j<nbTache; j++){
                if(i!= j){
                  //  if(meilleur.)
                    temp = new Solution(meilleur.inverser(i,j));
                    int diff =  meilleurTps- temp.getTemps();
                    if(diff >0){ //si la nouvelle solution dure moins longtemps
                        couple[0] = i;
                        couple[1] = j;
                        meilleurTps = temp.getTemps();
                    }
                }
            }
        }
        return couple;
    }
}
