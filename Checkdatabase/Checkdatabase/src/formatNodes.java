import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark Verschuuren on 21-11-2017.
 */

public class formatNodes {
    BufferedReader inFile;
    ArrayList<String> nodesList = new ArrayList<>();
    HashMap<String, ArrayList<String>> nodesNCBI = new HashMap<>();
    String Path = "/home/han-bc-bipc4/PycharmProjects/CompareDB/nodes.dmp";
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
        } catch (IOException e) {
            System.out.println("NOo erroar");
        }
    }

    /**
     *
     * @return nodesNCBi file String(taxID), arraylist(ParentID,rank)
     */
    public HashMap<String, ArrayList<String>> getNodesNCBI() {
        return nodesNCBI;
    }

}
