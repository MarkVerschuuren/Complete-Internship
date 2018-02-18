import java.io.*;
import java.util.*;
/**
 * Created by Mark Verschuuren on 21-11-2017.
 *
 * @scientific string object for the scientific name which is connected to every taxID.
 * @inFile bufferedReader object to read a specific file, which is the names.dmp file.
 * @namesNCBITax datastructure for names.dmp. Based on String(taxID) : String(scientific name).
 * @namesNCBIName datastructure for names.dmp. Based on String(scientific name) : String(taxID).
 * @namesNCBISyno datastructure for names.dmp. Based on String(Synoym name) : String(scientific name).
 * @Path path towards the names.dmp file. Change when not using on the same computer/laptop.
 **/

public class formatNames {
    String scientific;
    BufferedReader inFile;
    HashMap<String, String> namesNCBITax = new HashMap<>();
    HashMap<String, String> namesNCBIName = new HashMap<>();
    HashMap<String, String> namesNCBISyno = new HashMap<>();
    String Path = "C:\\Users\\Mark Verschuuren\\PycharmProjects\\CompareDB\\names.dmp";

    public  formatNames() {
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
        }
        catch (IOException e) {
            System.out.println("NOo errors");
        }
    }

    /**
     * @return namesNCBITax, avaliable in mainScript to get the namesNCBITax variable.
     */
    public HashMap<String, String> getNamesNCBITax() {
        return namesNCBITax;
    }
    /**
     * @return namesNCBIName, avaliable in mainScript to get the namesNCBIName variable.
     */
    public HashMap<String, String> getNamesNCBIName() {
        return namesNCBIName;
    }
    /**
     * @return namesNCBISyno, avaliable in mainScript to get the namesNCBISyno variable.
     */
    public HashMap<String, String> getNamesNCBISyno() {
        return namesNCBISyno;
    }

}
