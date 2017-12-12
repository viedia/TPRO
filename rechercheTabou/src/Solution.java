import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private HashMap<String, Tache> liste_sol ;
    private int temps;

    public static void setReglages(int[][] reglages) {
        Solution.reglages = reglages;
    }

    private static int[][] reglages;

    public Solution(int[][] reglages) {
    }

    public Solution(){

        liste_sol = new HashMap<>();

    }
    public Solution(HashMap<String, Tache> copie)
    {
        liste_sol = copie;
        calculTemp();
    }
    public HashMap<String, Tache> getListe_sol() {
        return liste_sol;
    }

    public int getTemps() {
        return temps;
    }

    public void majListe(Tache[] list){
        for(int i=0; i<list.length; i++){
            liste_sol.put(String.valueOf(i), list[i]);
        }
        calculTemp();
    }

    public HashMap<String, Tache> inverser(int num1, int num2){
        HashMap<String, Tache> nouvel = liste_sol;
        Tache temp = nouvel.get(String.valueOf(num1));
        nouvel.put(String.valueOf(num1), nouvel.get(String.valueOf(num2)));
        nouvel.put(String.valueOf(num2), temp);
        return  nouvel;
    }

    //refaire en ajoutant les temps de reglages
    private void calculTemp(){
        temps = liste_sol.get("1").getTpsDepart();
        for(int i=0; i< liste_sol.values().size()-1; i++){
            Tache t1 = liste_sol.get(String.valueOf(i));
            Tache t2 = liste_sol.get(String.valueOf(i+1));
            temps+= t1.getTemps() + reglages[t1.getId()][t2.getId()];
        }
    }

    @Override
    public String toString(){
        String affichage ;
        return liste_sol.toString()+" "+temps;
    }
}
