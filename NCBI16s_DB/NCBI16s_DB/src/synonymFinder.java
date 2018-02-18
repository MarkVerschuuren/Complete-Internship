import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark Verschuuren on 29-11-2017.
 */
public class synonymFinder {
    /**
     *
         * @param taxon name of the found taxon, found in the namesNCBI data structures.
     * @param namesNCBISyno datastructure for names.dmp. Based on String(Synoym name) : String(scientific name).
     * @param nodesNCBI datastructure for nodes.dmp. Based on String(taxID) : ArrayList(String(parentID, taxonRank)).
     * @param taxonArray stringarray containing the full taxonheader such as [k__, c__, o__, f__, g__, s__]
     * @param seq the sequence attached to the taxon header.
     * @param namesNCBITax datastructure for names.dmp. Based on String(taxID) : String(scientific name).
     * @param bw writer for the analyse file.
     * @param bw2 writer for the database.
     */
    public synonymFinder(String taxon, HashMap<String, String> namesNCBISyno, HashMap<String, ArrayList<String>> nodesNCBI, String[] taxonArray, String seq,HashMap<String, String> namesNCBITax, BufferedWriter bw, BufferedWriter bw2, BufferedWriter bw3, HashMap<String, String> namesNCBIName, BufferedWriter bw4 ) {

        if (namesNCBISyno.get(taxon) != null) {
            String taxonlevel = nodesNCBI.get(taxon).get(1);

            switch (taxonlevel) {
                case "species":
                    taxonArray[6] = namesNCBISyno.get(taxon);
                    break;
                case "genus":
                    taxonArray[5] = namesNCBISyno.get(taxon);
                    break;
                case "family":
                    taxonArray[4] = namesNCBISyno.get(taxon);
                    break;
                case "order":
                    taxonArray[3] = namesNCBISyno.get(taxon);
                    break;
            }
        }
    }
}


