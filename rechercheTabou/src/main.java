import java.util.HashMap;
import java.util.Map;

public class main {



    public static void main(String[] args) {
        Parseur p = new Parseur();
        Map<String, int[]> contenu= p.lire("../PROB401.TXT");
        RechercheTabou rt = new RechercheTabou(contenu);
       // System.out.println(contenu.get("nombre")[0]);
       // System.out.println(contenu.get("temps")[0]);
        //System.out.println(contenu.get("reglage")[0]);
    }


}
