import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;



/**
 * Created by Mark Verschuuren on 21-11-2017.
 * @infile bufferedReader object to read a specific file, which is the names.dmp file.
 * @index used to identify when the column names have to be added to the file.
 * @Path path towards the database that has to be changed(fasta : >taxonheader \n seq \n). Change when not using on the same computer/laptop.
 *
 */
public class makeTaxMap{
    BufferedReader inFile;
    static int index;
    String Path = "C:\\Users\\Mark Verschuuren\\PycharmProjects\\CompareDB\\GreengenesSilvaSeq2.fasta";

    /**
     * @param namesNCBIName datastructure for names.dmp. Based on String(scientific name) : String(taxID).
     * @param namesNCBITax datastructure for names.dmp. Based on String(taxID) : String(scientific name).
     * @param namesNCBISyno datastructure for names.dmp. Based on String(Synoym name) : String(scientific name).
     * @param nodesNCBI datastructure for nodes.dmp. Based on String(taxID) : ArrayList(String(parentID, taxonRank)).
     */
    public makeTaxMap(HashMap<String, String> namesNCBIName, HashMap<String,String> namesNCBITax, HashMap<String,String> namesNCBISyno , HashMap<String, ArrayList<String>> nodesNCBI){
        Boolean Check = true;
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Public\\CompareFile", true);
            BufferedWriter bw = new BufferedWriter(fw);
            FileWriter fw2 = new FileWriter("C:\\Users\\Public\\Greengenes2.0", true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            FileWriter fw3 = new FileWriter("C:\\Users\\Public\\wrongHeadersGenus", true);
            BufferedWriter bw3 = new BufferedWriter(fw3 );
            FileWriter fw4 = new FileWriter("C:\\Users\\Public\\wrongHeadersSpecies", true);
            BufferedWriter bw4 = new BufferedWriter(fw4 );
            index = 0;
            if(index == 0){
                bw.write("OldK" + "\t" + "NewK" + "\t" + "OldP" + "\t" + "NewP" + "\t" + "OldC" + "\t" + "NewC" +"\t" +
                        "OldO" + "\t" + "NewO" + "\t" + "OldF" + "\t" + "NewF" +"\t" + "OldG" + "\t" + "NewG" +"\t" + "OldS" + "\t" + "NewS" + "\n");

            }
            inFile = new BufferedReader(new FileReader(Path));
            String line;

            while ((line = inFile.readLine()) != null) {

                String headerString = new ArrayList<String>(Arrays.asList(line.split("/"))).get(index);
                ArrayList taxons = new ArrayList<String>(Arrays.asList(headerString.split("#")));
                String seq = inFile.readLine();

                for(int c = 0; c < taxons.size();c++){

                    Check = true;
                    String header = taxons.get(c).toString();
                    String[] taxonArray = header.split(";");

                    for( int count = 6 ; count > 2 ;count--){

                        if(Check){
                            if(namesNCBIName.get(taxonArray[count].substring(4, taxonArray[count].length())) != null) {
                                String key = namesNCBIName.get(taxonArray[count].substring(4, taxonArray[count].length()));
                                changeHeader changer = new changeHeader(key, seq, taxonArray, taxonArray[count], namesNCBITax, nodesNCBI, bw, bw2, bw3, namesNCBIName, bw4);
                                Check = false;
                            }

                            else if(count == 6) {
                                if (!taxonArray[count].equals(" s__")) {
                                    String namoe = taxonArray[count-1].split("_")[2] + " " + taxonArray[count].split("_")[2];
                                    Pattern pattern = Pattern.compile(" " + namoe +" ");

                                    for (String keys : namesNCBITax.keySet()) {
                                        if(Check){

                                            if(namesNCBITax.get(keys).equals(namoe)){
                                                System.out.println("h4llo");
                                                changeHeader changer = new changeHeader(keys, seq, taxonArray, taxonArray[count], namesNCBITax, nodesNCBI, bw, bw2, bw3, namesNCBIName, bw4);
                                                Check = false;
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                synonymFinder finder  = new synonymFinder(namesNCBIName.get(taxonArray[count].substring(4, taxonArray[count].length())), namesNCBISyno, nodesNCBI, taxonArray, seq, namesNCBITax, bw, bw2, bw3, namesNCBIName, bw4 );
                            }
                        }
                    }
                }
            }
            bw.close();
            bw2.close();
            bw3.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Is this it?");
        }
        catch (IOException e) {
            System.out.println("NOo errorasd");
        }
    }
}
