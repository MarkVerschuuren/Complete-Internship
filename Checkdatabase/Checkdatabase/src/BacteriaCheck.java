import java.util.ArrayList;
import java.util.HashMap;

public class BacteriaCheck {

    public String CheckBacteria(HashMap<String,String>  namesN, HashMap<String,String> namesT, HashMap<String, ArrayList<String>> nodes, String key){
        while(!namesT.get(key).equals("Bacteria") && !namesT.get(key).equals("Eukaryota") && !namesT.get(key).equals("Archaea")
                && !namesT.get(key).equals("root") ){


            key = nodes.get(key).get(0);

        }
        return namesT.get(key);
    }
}




