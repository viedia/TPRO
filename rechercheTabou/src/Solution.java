import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private HashMap<String, Tache> liste_sol ;
    private int temps;

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
    private void calculTemp(){
        temps = liste_sol.get("1").getTpsDepart();
        for(Tache val : liste_sol.values()){
            temps+= val.getTemps();
        }
    }

    @Override
    public String toString(){
        String affichage ;
        return liste_sol.toString()+" "+temps;
    }
}
