import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    private HashMap<String, Tache> liste_sol ;
    private int temps;

    public Solution(){
        liste_sol = new HashMap<>();
    }

    public void majListe(Tache[] list){
        for(int i=0; i<list.length; i++){
            liste_sol.put(String.valueOf(i), list[i]);
        }
        calculTemp();
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
