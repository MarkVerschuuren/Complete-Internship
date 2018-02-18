import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Mark Verschuuren on 23-11-2017.
 */
public class writeDatabase {
    static int index = 0;

    /**
     * @param taxonArray stringarray containing the full taxonheader such as [k__, c__, o__, f__, g__, s__]. This is now fully changed on the old header.
     * @param seq sequence of the header.
     * @param bw2 writer for the database.
     * @param oldKey the key attached to the lowest taxon found.
     */
    public writeDatabase(String[] taxonArray, String seq, BufferedWriter bw2, String oldKey){
        try{
            bw2.write(">" + Integer.toString(index) + ";" + oldKey + ";" + taxonArray[0].substring(1,taxonArray[0].length()) + ";" + taxonArray[1] + ";" + taxonArray[2] + ";" + taxonArray[3] + ";"+ taxonArray[4] + ";"
                    + taxonArray[5] + ";"+ taxonArray[6] + "\n" + seq.replace("-","") + "\n");
            index += 1;
        }
        catch (IOException e){          
            System.out.println("NOO errorr");
        }

    }
}

