import java.util.HashMap;
import java.util.Map;

public class main {

    private static final int NBITERATION = 25;
    public static void main(String[] args) {
        Parseur p = new Parseur();
        Map<String, int[]> contenu= p.lire("../PROB701.TXT");
        RechercheTabou rt = new RechercheTabou(contenu);
        for(int i = 0; i< NBITERATION; i++){
            System.out.println("#####ITERATION "+i+"#####");
            rt.iteration();

        }
    }


}
