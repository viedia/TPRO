import java.util.Map;

public class main {
    public static void main(String[] args) {
        //Objet Parseur
        Parseur p = new Parseur();
        //Lire le fichier
        Map<String, int[]> contenu = p.lire("../PROB401.TXT");
        //Lancer l'algoGenetique objet
        algoGenetique rt = new algoGenetique(contenu);
    }
}