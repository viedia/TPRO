public class Tache {
    private int temps;
    private int tpsDepart;

    public Tache(int tps, int depart){
        temps = tps;
        tpsDepart = depart;
    }

    @Override
    public String toString(){
        return "temps = "+this.temps+" Debut : "+this.tpsDepart;
    }
}
