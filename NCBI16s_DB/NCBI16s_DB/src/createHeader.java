import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class createHeader {

    public createHeader(String organism, String strain, String headerPart, HashMap<String, String> namesTax, HashMap<String, String> namesName, HashMap<String, String> namesSyno , HashMap<String, ArrayList<String>> nodesNCBI, int goodies, String seq, BufferedWriter bw){


        if(namesName.get(organism) != null||namesName.get(organism +" "+strain) !=null ){
            KaAs kas = new KaAs(organism, strain, headerPart, namesTax, namesName, namesSyno , nodesNCBI, goodies,seq, bw);
        }
//        else{
//            System.out.println("organism " + organism + " has not be found in the DB as species");
//
//        }



    }
}
/*

 */