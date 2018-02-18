import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class findTaxons {
    String orderK;
    writeDatabase DB = new writeDatabase();

    /**
     *
     * @param genus genus for BLAST
     * @param names namesNCBI file( String(name), String(TaxID) .
     * @param nodes  nodesNCBi file String(taxID), arraylist(ParentID,rank).
     * @param green greenfile.
     * @param namesT NamesNCBI file ( String(taxID), String(Name)) .
     * @param species Species for BLAST
     * @param bw Writer for the database.
     * @param seq sequence based on header
     */
    public findTaxons(String genus, HashMap<String,String> names, HashMap<String, ArrayList<String>> nodes, String[] green, HashMap<String,String> namesT, String species, BufferedWriter bw, String seq){



        String genusK = names.get(genus);


        if(genusK != null) {
            String familyK = nodes.get(names.get(genus)).get(0);
            orderK = nodes.get(familyK).get(0);

            DB.writerDatabase(green, genus, species, namesT.get(familyK),
                    namesT.get(nodes.get(familyK).get(0)), namesT.get(nodes.get(orderK).get(0)), bw, seq);

            }

        }






    }


