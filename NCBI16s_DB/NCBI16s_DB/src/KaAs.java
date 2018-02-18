import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class KaAs {
    String[] taxons = {"species", "genus", "family", "order", "class", "phylum", "superkingdom"};
    String taxonlevel;
    String Pkey;
    static int counter, baddies;
    ArrayList<String> header = new ArrayList<>();
    ArrayList<String> completeheader = new ArrayList<>();


    public KaAs(String organism, String strain, String headerPart, HashMap<String, String> namesTax, HashMap<String, String> namesName, HashMap<String, String> namesSyno , HashMap<String, ArrayList<String>> nodesNCBI, int goodies, String seq, BufferedWriter bw){
        goodies++;
        String key = namesName.get(organism);
        Pkey = nodesNCBI.get(key).get(0); //genus - family - order - class - phylum - kingdom.

        header.add(strain);
        header.add("strain");
        header.add(organism);
        header.add("species");

        for(int count = 1; count < 7; count++){

            taxonlevel = nodesNCBI.get(Pkey).get(1);
            while(!taxonlevel.equals(taxons[count]) && Integer.parseInt(Pkey) != 1){
                taxonlevel = nodesNCBI.get(Pkey).get(1);

                if(!taxonlevel.equals(taxons[count])){
                     Pkey = nodesNCBI.get(Pkey).get(0);
                }

            }
            if(taxonlevel.equals(taxons[count])){

                header.add(namesTax.get(Pkey));
                header.add(nodesNCBI.get(Pkey).get(1));
                Pkey = nodesNCBI.get(Pkey).get(0);
            }
            else{
                counter++;
                if( counter == 1){
                    makeHeader make = new makeHeader(organism, strain, headerPart, namesTax, namesName, namesSyno , nodesNCBI);
                    completeheader = make.getCompleteheader();
                    baddies = make.getAmountBaddies();
                }
                Pkey = nodesNCBI.get(key).get(0);
                header.add("NaN");
                header.add(taxons[count]);

            }
        }
       // System.out.println(completeheader.toString());
        makeDB db = new makeDB(header, completeheader,seq, bw, headerPart);
        counter = 0;




    }
}

