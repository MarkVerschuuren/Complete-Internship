import java.util.ArrayList;
import java.util.HashMap;

public class makeHeader {
    String taxonlevel;
    String Pkey;



    int amountBaddies;


    ArrayList<String> completeheader = new ArrayList<>();
    public makeHeader(String organism, String strain, String headerPart, HashMap<String, String> namesTax, HashMap<String, String> namesName, HashMap<String, String> namesSyno , HashMap<String, ArrayList<String>> nodesNCBI){
        amountBaddies++;
        completeheader.add(strain);
        completeheader.add("strain");

        completeheader.add(organism);
        completeheader.add("species");

        String key = namesName.get(organism);
        Pkey = nodesNCBI.get(key).get(0);
        completeheader.add(namesTax.get(Pkey));
        completeheader.add(nodesNCBI.get(Pkey).get(1));

        while(Integer.parseInt(Pkey) != 1){
            Pkey = nodesNCBI.get(Pkey).get(0);
            completeheader.add(namesTax.get(Pkey));
            completeheader.add(nodesNCBI.get(Pkey).get(1));

        }

    }

    public ArrayList<String> getCompleteheader() {
        return completeheader;
    }
    public int getAmountBaddies() {
        return amountBaddies;
    }
}
