import java.util.HashMap;
import java.util.Map;

public class main {



    public static void main(String[] args) {
        Parseur p = new Parseur();
        Map<String, int[]> contenu= p.lire("../PROB401.TXT");
        RechercheTabou rt = new RechercheTabou(contenu);
        rt.iteration();
        rt.iteration();
    }


}
