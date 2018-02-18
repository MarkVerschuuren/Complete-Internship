import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Mark Verschuuren on 22-11-2017.
 */
public class Changelayer {
    private String genusName, familyName, orderName, className;
    private String genusKey, familyKey, orderKey, classKey;
    boolean Check = false;



    String taxi;

    /**
     *
     * @param key the taxID based on the taxonname. Gained from nodesNCBI.
     * @param namesNCBITax datastructure for names.dmp. Based on String(taxID) : String(scientific name).
     * @param nodesNCBI datastructure for nodes.dmp. Based on String(taxID) : ArrayList(String(parentID, taxonRank)).
     * @return returns the taxon level created while working on a specific taxon. So when species are done,the next taxon will be genus.
     */
    public String changeSpecies(String key, HashMap<String,String> namesNCBITax, HashMap<String, ArrayList<String>> nodesNCBI){

        while(!nodesNCBI.get(key).get(1).equals("genus") && !Check){
            if(Integer.parseInt(key) != 1){
                key = nodesNCBI.get(key).get(0);

            }
            else if(Integer.parseInt(key) == 1){
                    Check = true;
            }
        }

        if(nodesNCBI.get(key).get(1).equals("genus")){

            genusKey = nodesNCBI.get(key).get(0);
            genusName = "g__" + namesNCBITax.get(genusKey);
            return "genus";
        }
        else{

            return "Stop";
        }

    }
    public String changeGenus(String key, HashMap<String,String> namesNCBITax, HashMap<String, ArrayList<String>> nodesNCBI){
        taxi = nodesNCBI.get(key).get(1);
        while(!nodesNCBI.get(key).get(1).equals("family") && !Check){

            if(Integer.parseInt(key) != 1){
                key = nodesNCBI.get(key).get(0);


            }
            else if(Integer.parseInt(key) == 1){
                Check = true;
            }
        }

        if(nodesNCBI.get(key).get(1).equals("family")){

            familyKey = nodesNCBI.get(key).get(0);
            familyName = "f__" + namesNCBITax.get(familyKey);
            return "family";
        }
        else{

            return "Stop";
        }
    }
    public String changeFamily(String key, HashMap<String,String> namesNCBITax, HashMap<String, ArrayList<String>> nodesNCBI){
        while(!nodesNCBI.get(key).get(1).equals("order") && !Check){
            if(Integer.parseInt(key) != 1){
                key = nodesNCBI.get(key).get(0);

            }
            else if(Integer.parseInt(key) == 1){
                Check = true;
            }
        }

        if(nodesNCBI.get(key).get(1).equals("order")){

            orderKey = nodesNCBI.get(key).get(0);
            orderName = "o__" + namesNCBITax.get(orderKey);
            return "order";
        }
        else{

            return "Stop";
        }




    }
    public String changeOrder(String key, HashMap<String,String> namesNCBITax, HashMap<String, ArrayList<String>> nodesNCBI) {
        while(!nodesNCBI.get(key).get(1).equals("class") && !Check){
            if(Integer.parseInt(key) != 1){
                key = nodesNCBI.get(key).get(0);

            }
            else if(Integer.parseInt(key) == 1){
                Check = true;
            }
        }

        if(nodesNCBI.get(key).get(1).equals("class")){

            classKey = nodesNCBI.get(key).get(0);
            className = "c__" + namesNCBITax.get(classKey);
            return "class";
        }
        else{

            return "Stop";
        }











//        System.out.println("order");
//
//        System.out.println(nodesNCBI.get(key).get(1));
//        System.out.println(namesNCBITax.get(key));

    }


    /**
     * These getters are made to get the name and key of a specific taxonlevel.
     * @return name or key of a taxonlevel.
     */
    public String getGenusName() {
        return genusName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public String getOrderName() {
        return orderName;
    }
    public String getClassName() {
        return className;
    }
    public String getGenusKey() {
        return genusKey;
    }
    public String getFamilyKey() {
        return familyKey;
    }
    public String getOrderKey() {
        return orderKey;
    }
    public String getClassKey() {
        return classKey;
    }
    public String getTaxi() {
        return taxi;
    }
}
