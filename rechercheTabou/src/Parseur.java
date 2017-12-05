import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Parseur {

    public Parseur() {
    }

    public  Map<String, int[]> lire(String path){
        Map<String, int[]> res = new HashMap<String, int[]>();
        res.put("reglage", null);
        try{
            InputStream flux=new FileInputStream(path);
            InputStreamReader lecture=new InputStreamReader(flux);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            int compteur = 1;
            while ((ligne=buff.readLine())!=null){
                System.out.println(ligne);
                switch (compteur){
                    case 1: {
                        int[] tab = {Integer.parseInt(ligne.replaceAll(" ", ""))};
                        res.put("nombre",tab );
                        compteur ++;
                        break;
                    }
                    case 2:{
                        char pred = ' ';
                        String val = "";
                        int marque = 0;
                        int[] listVal = new int[res.get("nombre")[0]];
                        for(int i=0; i<ligne.length(); i++){ //pour tous les caharactères de la ligne
                            if(ligne.charAt(i)!= ' '){ //si on lit un chiffre
                                val = val.concat(ligne.substring(i, i+1));
                            }else{//si un lit un espace
                                if(pred != ' '){ //si on finit de lire une valeur
                                    listVal[marque] = Integer.parseInt(val);
                                    marque ++;
                                    val = "";
                                }
                            }
                            pred = ligne.charAt(i);
                        }
                        res.put("temps", listVal);
                        compteur++;
                        break;
                    }default:{
                        char pred = ' ';
                        String val = "";
                        int marque = 0;
                        int[] nombres =new int[res.get("nombre")[0]];
                        for(int i=0; i<ligne.length(); i++){ //pour tous les caharactères de la ligne
                            if(ligne.charAt(i)!= ' '){ //si on lit un chiffre
                                val = val.concat(ligne.substring(i, i+1));
                            }else{//si un lit un espace
                                if(pred != ' '){ //si on finit de lire une valeur
                                    nombres[marque] = Integer.parseInt(val);
                                    marque ++;
                                    val = "";
                                }
                            }
                            pred = ligne.charAt(i);
                        }
                        if(res.get("reglage") == null)
                            res.put("reglage", nombres);
                        else
                            res.put("reglage",concat(res.get("reglage"), nombres ));
                        break;
                    }
                }
            }
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return res;
    }

    private int[] StrToInt(String[] tab){
        int[] tabInt = new int[tab.length];
        for(int i = 0; i< tab.length; i++){
           tabInt[i]=Integer.parseInt(tab[i]);
        }
        return tabInt;
    }

    private int[] concat(int[] tab1, int[] tab2)
    {
        int[] tab3;
        /* arraycopy(Object src, int srcPos, Object dest, int destPos, int length)  */
        tab3 = new int[tab1.length + tab2.length];
        System.arraycopy(tab1, 0, tab3, 0, tab1.length);
        System.arraycopy(tab2, 0, tab3, tab1.length, tab2.length);
        return tab3;
    }
}
