import java.io.*;
import java.util.Arrays;

public class StripDatabase {
    BufferedReader inFile;
    int count;

    public StripDatabase() {
        try {


            String line;
            inFile = new BufferedReader(new FileReader("/home/han-bc-bipc4/compareblaster"));
            inFile.readLine();

            FileWriter fw = new FileWriter("/home/han-bc-bipc4/StripDB", true);
            BufferedWriter writer = new BufferedWriter(fw);
            while((line = inFile.readLine()) != null ){
                String[] lines = line.split("\t");
                System.out.println(Arrays.asList(lines));
                count++;
                writer.write(">" + ";" + count + ";" + lines[0] + ";" + lines[1] + ";" + lines[3] + ";" + lines[5] + ";"
                        + lines[7] + ";" + "\n" + lines[9] + "\n");


            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("wow error");
        }
    }

}
