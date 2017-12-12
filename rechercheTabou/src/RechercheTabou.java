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

        int meilleurTps = meilleur.getTemps();
        HashMap<Integer[], Integer[]> tabou = meilleur.getListe_tabou();
        for(int i=0; i<nbTache-1; i++){
            for(int j=0; j<nbTache; j++){
                if(i!= j){
                    int[] cle = {i, meilleur.getListe_sol().get(String.valueOf(i)).getId()};
                    if( tabou.size()==0){
                        test(i,j,couple,meilleurTps);
                    }else if(!tabou.containsKey(cle) ) {
                        test(i,j,couple,meilleurTps);
                    }else if(!(tabou.get(cle)[0]==j && tabou.get(cle)[1]== meilleur.getListe_sol().get(String.valueOf(j)).getId())){
                        test(i,j,couple,meilleurTps);
                    }else
                    {
                        System.out.println("esle 2");
                    }
                }
            }
        }
        return couple;
    }

    private void test(int pos1, int pos2, int[] couple, int meilleurTps){
        Solution temp = new Solution(meilleur.inverser(pos1,pos2));
        int diff =  meilleurTps- temp.getTemps();
        if(diff >0){ //si la nouvelle solution dure moins longtemps
            couple[0] = pos1;
            couple[1] = pos2;
            meilleurTps = temp.getTemps();
        }
    }
}
