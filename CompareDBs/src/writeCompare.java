import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mark Verschuuren on 22-11-2017.
 */
public class writeCompare {
    /**
     *
     * @param taxonArray stringarray containing the full taxonheader such as [k__, c__, o__, f__, g__, s__]
     * @param oldTax The unchanged taxongeader
     * @param oldKey The lowest taxonID found.(not used)
     * @param bw writer for the analyse file.
     */
    public writeCompare(String[] taxonArray, ArrayList<String> oldTax, String oldKey, BufferedWriter bw) {

        try{
            bw.write(oldTax.get(0) + "\t" + taxonArray[0] + "\t" + oldTax.get(1)+ "\t" + taxonArray[1] + "\t" + oldTax.get(2) + "\t" + taxonArray[2] + "\t" +
                    oldTax.get(3) + "\t" + taxonArray[3] + "\t" +oldTax.get(4) + "\t" + taxonArray[4] + "\t" + oldTax.get(5) + "\t" + taxonArray[5] + "\t" +
                    oldTax.get(6) + "\t" + taxonArray[6] + "\t" + "\n");


        }
        catch(IOException e){
            System.out.println("noo wtf");
        }


    }

}
