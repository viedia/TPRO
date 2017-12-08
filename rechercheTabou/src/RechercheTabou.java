import java.util.Map;

public class RechercheTabou {
    private Solution meilleur;
    private int nbTache;
    private int[][] reglages;

    public RechercheTabou(Map<String, int[]> infos) {
        this.Initialisation(infos.get("nombre")[0],infos.get("reglage"),infos.get("temps"),infos.get("debut") );
    }

    private void Initialisation(int nb, int[] reglage, int[] temps, int[] debut){
        nbTache = nb;
        Tache[] t = new Tache[nbTache];
        reglages = new int[nbTache][nbTache];
        for(int i = 0; i<nbTache; i++)
        {
            t[i] = new Tache(temps[i], debut[i]);
            System.out.println(t[i].toString());
            for(int j=0; j<nbTache;j++){
                this.reglages[i][j] = reglage[nbTache*i+j];
                System.out.println( reglage[nbTache*i+j]);
            }
        }
        meilleur = new Solution();

    }
}
