/**
 * Created by Mark Verschuuren on 21-11-2017.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class formatNames {
    BufferedReader inFile;
    String scientific;
    HashMap<String, String> namesNCBITax = new HashMap<>();
    HashMap<String, String> namesNCBIName = new HashMap<>();
    HashMap<String, String> namesNCBISyno = new HashMap<>();
    String Path = "/home/han-bc-bipc4/PycharmProjects/CompareDB/names.dmp";

    public formatNames() {
        try {
            inFile = new BufferedReader(new FileReader(Path));
            String line;



            while ((line = inFile.readLine()) != null) {
                String[] lines = line.split("\t");
                if(lines[6].equals("scientific name")){

                    scientific = lines[2];

                    namesNCBITax.put(lines[0], lines[2]);
                    namesNCBIName.put(lines[2], lines[0]);
                }
                else{
                    namesNCBISyno.put(lines[2], scientific);
                }
            }


        } catch (IOException e) {
            System.out.println("NOo errors");
        }
    }

    /**
     *
     * @return NamesNCBI file ( String(taxID), String(Name))
     */
    public HashMap<String, String> getNamesNCBITax() {
        return namesNCBITax;
    }

    /**
     *
     * @return namesNCBI file( String(name), String(TaxID)
     */
    public HashMap<String, String> getNamesNCBIName() {
        return namesNCBIName;
    }
    public HashMap<String, String> getNamesNCBISyno() {
        return namesNCBISyno;
    }

}
