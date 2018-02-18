import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark Verschuuren on 12-12-2017.
 */
public class wrongHeads {
    public wrongHeads(BufferedWriter bw3, String[] taxonarray, String Taxi, HashMap<String, ArrayList<String>> nodesNCBI, HashMap<String, String> namesNCBIName, BufferedWriter bw4){
        try{
            System.out.println(Taxi);
            if (Taxi.equals("genus")) {
                System.out.println(taxonarray[5].split("__")[1]);
                String genuskey = namesNCBIName.get(taxonarray[5].split("__")[1]);
                System.out.println(genuskey);

                if(genuskey != null){
                    bw3.write(taxonarray[0] + "\t"
                            + namesNCBIName.get(taxonarray[0].split("__")[1])+ "\t"
                            + taxonarray[1] + "\t"
                            + namesNCBIName.get(taxonarray[1].split("__")[1]) + "\t"
                            + taxonarray[2] + "\t"
                            + namesNCBIName.get(taxonarray[2].split("__")[1]) + "\t"
                            + taxonarray[3] + "\t"
                            + namesNCBIName.get(taxonarray[3].split("__")[1]) + "\t"
                            + taxonarray[4] + "\t"
                            + namesNCBIName.get(taxonarray[4].split("__")[1]) + "\t"
                            + taxonarray[5] + "\t"
                            + genuskey + "\t"
                            + taxonarray[6]  + "\t"
                            + Taxi +   "\n");
                    }   
                }
                else if(Taxi.equals("species")){
                    String specieskey = namesNCBIName.get(taxonarray[6]);
                    if(specieskey != null){
                        bw4.write(taxonarray[0] + "\t"
                                + nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(specieskey).get(0)).get(0)).get(0)).get(0)).get(0)).get(0)) + "\t"
                                + taxonarray[1] + "\t"
                                + nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(specieskey).get(0)).get(0)).get(0)).get(0)).get(0)) + "\t"
                                + taxonarray[2] + "\t"
                                + nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(specieskey).get(0)).get(0)).get(0)).get(0))+ "\t"
                                + taxonarray[3] + "\t"
                                + nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(nodesNCBI.get(specieskey).get(0)).get(0)).get(0)) + "\t"
                                + taxonarray[4] + "\t"
                                + nodesNCBI.get(nodesNCBI.get(specieskey).get(0)).get(0) + "\t"
                                + taxonarray[5] + "\t"
                                + nodesNCBI.get(specieskey).get(0) + "\t"
                                + taxonarray[6]  + "\t"
                                + specieskey + "\t"
                                + Taxi +   "\n");
                    }
                }





        }

        catch (IOException e){
            System.out.println("error? HERE???");
        }

    }
}

