import java.io.*;
import java.util.*;

/**
 * Created by Mark Verschuuren on 21-11-2017.
 * @inFile bufferedReader object to read a specific file, which is the names.dmp file.
 * @nodesNCBI datastructure for nodes.dmp. Based on String(taxID) : ArrayList(String(parentID, taxonRank)).
 * @Path path towards the nodes.dmp file. Change when not using on the same computer/laptop.
 */

public class formatNodes {
    BufferedReader inFile;
    ArrayList<String> nodesList = new ArrayList<>();
    HashMap<String, ArrayList<String>> nodesNCBI = new HashMap<>();
    String Path = "C:\\Users\\Mark Verschuuren\\PycharmProjects\\CompareDB\\nodes.dmp";
    public formatNodes() {
        try {
            inFile = new BufferedReader(new FileReader(Path));
            String line;

            while ((line = inFile.readLine()) != null) {
                String[] lines = line.split("\t");
                nodesList.add(lines[2]);
                nodesList.add(lines[4]);
                nodesNCBI.put(lines[0], nodesList);
                nodesList = new ArrayList<>();
            }
        }
        catch (IOException e) {
            System.out.println("NOo erroar");
        }
    }
    /**
     * @return nodesNCBI, avaliable in mainScript to get the nodesNCBI variable.
     */
    public HashMap<String, ArrayList<String>> getNodesNCBI() {
        return nodesNCBI;
    }

}
