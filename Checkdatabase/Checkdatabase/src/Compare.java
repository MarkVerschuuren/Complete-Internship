import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Compare {

    writeDatabase DB = new writeDatabase();
    String species, genus, familyK, orderK;
    BacteriaCheck check = new BacteriaCheck();
    int taxonlevel = 5;
    String taxon = "";
    String superkingdom = "";
    ArrayList<String> header = new ArrayList<>();
    String[] taxas = {"superkingdom", "phylum", "class", "order", "family", "genus", "species"};

    /**
     * @param blast  blastfile.
     * @param green  greenfile.
     * @param names  namesNCBI file( String(name), String(TaxID) .
     * @param nodes  nodesNCBi file String(taxID), arraylist(ParentID,rank).
     * @param namesT NamesNCBI file ( String(taxID), String(Name)) .
     * @param bw     writer for the database.
     * @param seq    seqeunce based on the header.
     */
    public Compare(String[] blast, String[] green, HashMap<String, String> names, HashMap<String, ArrayList<String>> nodes, HashMap<String, String> namesT, BufferedWriter bw, String seq) {
        System.out.println("hi");
        if (namesT.get(blast[4]) != null) {
            String[] Genus_Species = namesT.get(blast[4]).split(" ");
            String genus = Genus_Species[0];
            String StartK = names.get(genus);
            String genusK = names.get(genus);


            while (!superkingdom.equals("Bacteria") && !superkingdom.equals("Archaea") && !superkingdom.equals("root")) {
                if (genusK != null) {
                    superkingdom = check.CheckBacteria(names, namesT, nodes, genusK);
                }
                else {
                    superkingdom = "root";
                }
                if(superkingdom.equals("Eukaryota")
                        && !nodes.get(genusK).get(1).equals("root")) {
                    taxonlevel--;

                    genusK = nodes.get(genusK).get(0);
                    taxon = namesT.get(genusK);
                }
            }



            if (superkingdom.equals("Bacteria") || superkingdom.equals("Archaea")) {
                header.add(genus + " " + Genus_Species[1]);


                for (int count = taxonlevel; count > 0; count--) {
                    String taxa = nodes.get(genusK).get(1);
                    while (!taxa.equals(taxas[count]) && Integer.parseInt(genusK) != 1) {
                        taxa = nodes.get(genusK).get(1); // get the taxonlevel of the taxa. Repeats to next level if it isnt found.
                        if (!taxa.equals(taxas[count])) { // taxon not equal to taxon which should be found : "genus, family" for instance.
                            genusK = nodes.get(genusK).get(0); // go one level higher if this happens.
                        }

                    }
                    if (taxa.equals(taxas[count])) { // found a good one, nice!
                        header.add(namesT.get(genusK));
                        // header.add(taxas[count].substring(0,1) + "__" + namesNCBITax.get(Pkey));
                        //header.add(taxa);
                        genusK = nodes.get(genusK).get(0);
                    } else { // nothing found? Baddd.
                        header.add("NaN");

                        genusK = nodes.get(StartK).get(0);

                    }

                }
                try{
                    bw.write(green[7] + "\t" + names.get(green[7]) +  "\t" +
                                header.get(0) + "\t" + names.get(header.get(0)) +  "\t" +
                                green[6] + "\t" + names.get(green[6]) +  "\t" +
                                header.get(1) + "\t" + names.get(header.get(1)) +  "\t" +
                                green[5] + "\t" + names.get(green[5]) +  "\t" +
                                header.get(2) + "\t" + names.get(header.get(2)) +  "\t" +
                                green[4] + "\t" + names.get(green[4]) +  "\t" +
                                header.get(3) + "\t" + names.get(header.get(3)) +  "\t" +
                                green[3] + "\t" + names.get(green[3]) +  "\t" +
                                header.get(4) + "\t" + names.get(header.get(4)) +  "\t" +
                                green[2] + "\t" + names.get(green[2]) +  "\t" +
                                header.get(5) + "\t" + names.get(header.get(5)) +  "\t" + seq + "\n"
                    );
                }
                catch (IOException e){
                    System.out.println("error somewhere");
                }


            }
        }
    }
}



//                if (genusK == null) {
//                    if (genus.equals("Bacillus")) {
//                        String bacilFam = nodes.get(nodes.get(names.get(genus)).get(0)).get(0);
//                        species = Genus_Species[1];
//                        familyK = nodes.get(bacilFam).get(0);
//                        orderK = nodes.get(familyK).get(0);
//
//
//                    } else {
//
//                        species = Genus_Species[1];
//                        familyK = nodes.get(names.get(Genus_Species[0])).get(0);
//                        orderK = nodes.get(familyK).get(0);
//                    }
//
//
//                    if (!green[8].equals("s__")) {
//                        DB.writerDatabase(green, genus, species, namesT.get(familyK),
//                                namesT.get(nodes.get(familyK).get(0)), namesT.get(nodes.get(orderK).get(0)), bw, seq);
//
//                    } else if (!green[7].equals("g__")) {
//                        DB.writerDatabase(green, genus, species, namesT.get(familyK),
//                                namesT.get(nodes.get(familyK).get(0)), namesT.get(nodes.get(orderK).get(0)), bw, seq);
//
//
//                    } else {
//
//                        findTaxons finder = new findTaxons(Genus_Species[0], names, nodes, green, namesT, Genus_Species[1], bw, seq);
//
//                    }
//                }





