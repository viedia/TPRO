import java.util.HashMap;
import java.util.Map;

public class Individu implements Comparable {
    private HashMap<String, Tache> listeTaches = new HashMap<>();
    private int temps;
    private static int[][] reglages;

    public static void setReglages(int[][] reglages) {
        Individu.reglages = reglages;
    }

    public Individu(Tache[] liste){
        for(int i=0; i<liste.length; i++){
            listeTaches.put(String.valueOf(i), liste[i]);
        }
        calculTemp();
    }

    //refaire en ajoutant les temps de reglages
    private void calculTemp(){
        temps = listeTaches.get("1").getTpsDepart();
        for(int i=0; i< listeTaches.values().size()-1; i++){
            Tache t1 = listeTaches.get(String.valueOf(i));
            Tache t2 = listeTaches.get(String.valueOf(i+1));
            temps+= t1.getTemps() + reglages[t1.getId()][t2.getId()];
        }
    }

    @Override
    public String toString(){
        String affichage ="";
        for (Map.Entry<String, Tache> entry : listeTaches.entrySet()){
            affichage += entry.getValue().toString()+"-";
        }
        return affichage;
    }
    public int getTemps() {
        return temps;
    }

    public HashMap<String, Tache> getListeTaches() {
        return listeTaches;
    }

    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(Individu.class)){
            Individu ind = (Individu) o;
            return Integer.compare(this.temps, ind.getTemps());
        }
        return -1;
    }
}