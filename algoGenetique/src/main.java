//Main

//Dans le main

    //Objet Parseur
    //Lire le fichier
    //Lancer l'algoGenetique
    //lancer la fonction iteration

import java.util.Map;

public class main {
    public static void main(String[] args) {
        Parseur p = new Parseur();
        Map<String, int[]> contenu = p.lire("../PROB401.TXT");
        algoGenetique rt = new algoGenetique(contenu);
    }
}