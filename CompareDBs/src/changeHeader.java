import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Mark Verschuuren on 22-11-2017.
 */
public class changeHeader {
    public boolean skipS = true;
    public boolean skipG = true;
    public boolean skipF = true;
    Changelayer layer = new Changelayer();

    /**
     * @param key          the taxID based on the taxonname. Gained from nodesNCBI.
     * @param seq          the sequence attached to the taxon header.
     * @param taxonarray   stringarray containing the full taxonheader such as [k__, c__, o__, f__, g__, s__]
     * @param taxon        name of the found taxon, found in the namesNCBI data structures.
     * @param namesNCBITax datastructure for names.dmp. Based on String(taxID) : String(scientific name).
     * @param nodesNCBI    datastructure for nodes.dmp. Based on String(taxID) : ArrayList(String(parentID, taxonRank)).
     * @param bw           writer for the analyse file.
     * @param bw2          writer for the database.
     */

    public changeHeader(String key, String seq, String[] taxonarray, String taxon, HashMap<String, String> namesNCBITax, HashMap<String, ArrayList<String>> nodesNCBI, BufferedWriter bw, BufferedWriter bw2, BufferedWriter bw3, HashMap<String, String> namesNCBIName, BufferedWriter bw4) {
        if (!taxonarray[0].startsWith(">")) {
            taxonarray[0] = ">k__Bacteria";
        }

        ArrayList<String> oldTax = new ArrayList<>(Arrays.asList(taxonarray));
        String oldKey = key;
        if (nodesNCBI.containsKey(key)) {
            String taxonlevel = nodesNCBI.get(key).get(1);


            if (taxonlevel.equals("species")) {
                skipS = false;
                taxonarray[6] = "s__" + taxonarray[5].split("_")[2] + " " + taxonarray[6].split("_")[2];
                taxonlevel = layer.changeSpecies(key, namesNCBITax, nodesNCBI);


                if(taxonlevel.equals("Stop")){

                    //wrongHeads wrong = new wrongHeads(bw3, taxonarray, layer.getTaxi(), nodesNCBI, namesNCBIName );
                }
                else{
                    taxonarray[5] = layer.getGenusName();
                    key = layer.getGenusKey();
                }
            }
            //------------------------------------------
            if (taxonlevel.equals("genus")) {

                skipG = false;
                if (skipS) {
                    taxonarray[6] = "s__";
                }
                taxonlevel = layer.changeGenus(key, namesNCBITax, nodesNCBI);

                if(taxonlevel.equals("Stop")){

                    wrongHeads wrong = new wrongHeads(bw3, taxonarray, layer.getTaxi(), nodesNCBI, namesNCBIName, bw4 );
                }
                else{
                    taxonarray[4] = layer.getFamilyName();
                    key = layer.getFamilyKey();
                }
            }
            //------------------------------------------
            if (taxonlevel.equals("family")) {
                skipF = false;
                if (skipG) {
                    taxonarray[6] = "s__";
                    taxonarray[5] = "g__";
                }
                taxonlevel = layer.changeFamily(key, namesNCBITax, nodesNCBI);
                taxonarray[3] = layer.getOrderName();
                key = layer.getOrderKey();
            }
            if (taxonlevel.equals("order")) {
                if (skipF) {
                    taxonarray[6] = "s__";
                    taxonarray[5] = "g__";
                    taxonarray[4] = "f__";
                }
                layer.changeOrder(key, namesNCBITax, nodesNCBI);
                taxonarray[2] = layer.getClassName();

                writeCompare compare = new writeCompare(taxonarray, oldTax, oldKey, bw);
                writeDatabase database = new writeDatabase(taxonarray, seq, bw2, oldKey);
            }

        }
    }

}