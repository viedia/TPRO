public class Tache {
    private int temps;
    private int tpsDepart;
    private int id;

    public Tache(int numero, int tps, int depart){
        temps = tps;
        tpsDepart = depart;
        id = numero;
    }

    public int getTemps() {

        return temps;
    }

    public int getTpsDepart() {

        return tpsDepart;
    }

    public int getId() {

        return id;
    }

    @Override
    public String toString(){
        return  String.valueOf(this.id); //"temps = "+this.temps+" Debut : "+this.tpsDepart;
    }
}