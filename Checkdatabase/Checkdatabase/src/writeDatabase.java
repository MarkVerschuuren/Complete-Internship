import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class writeDatabase {


    /**
     *
     * @param green  greenfile.
     * @param genus genus for BLAST
     * @param species Species for BLAST
     * @param family family for BLAST
     * @param order order for BLAST
     * @param clas class for BLAST
     * @param bw writer for database
     * @param seq sequence based on header.
     */
    public void writerDatabase(String[] green, String genus, String species, String family, String order, String clas, BufferedWriter bw, String seq){
        try{


            bw.write(green[1] + "\t"
             + green[8] + "\t" + species + "\t"
             + green[7] + "\t" + genus + "\t"
             + green[6] + "\t" + family + "\t"
             + green[5] + "\t" + order + "\t"
             + seq + "\n");


        }
        catch (IOException e){
            System.out.println("why there an errorss moooo");
        }



    }

}


/**
 *  bw.write(green[0] + ";" + green[1] + ";"
 + green[2] + ";"
 + green[3] + ";"
 + green[4] + ";"
 + green[5] + ";"
 + green[6] + ";"
 + green[7] + ";"
 + green[8] + ";"
 + "\n"+ seq + "\n");
 */
