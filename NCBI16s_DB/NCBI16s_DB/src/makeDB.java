import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class makeDB {
    String line = "";
    int countert = 6;
    static int counter = 0;
    String[] taxons = {"species", "genus", "family", "order", "class", "phylum", "kingdom"};
    public makeDB(ArrayList<String> header, ArrayList<String> completeheader, String seq, BufferedWriter bw, String NRacces){
        counter++;
        try{

            for(int count = 14 ; count > 0 ; count-=2){

                line += taxons[countert].substring(0, 1) + "__" + header.get(count) + ";";

                countert--;
            }
            System.out.println(line);
            bw.write(">" + NRacces + ";" + line.replace(" ", "-") + "\n" + seq + "\n");

        }

        catch(IOException e){
            System.out.println("adsdasdadadadasdasdsad");
        }




    }
}


