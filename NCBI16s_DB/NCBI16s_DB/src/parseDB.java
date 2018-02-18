import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class parseDB {
    String organism;
    String strain;
    BufferedReader inFile;
    String seqe;
    static int goodies, countDB;
    public parseDB(String path, HashMap<String, String> namesTax, HashMap<String, String> namesName, HashMap<String, String> namesSyno,  HashMap<String, ArrayList<String>> nodesNCBI){
        try{
            inFile = new BufferedReader(new FileReader(path));
            FileWriter fw = new FileWriter("/home/han-bc-bipc4/NCBIdatabass", true);
            BufferedWriter bw = new BufferedWriter(fw);


            String line;
            while ((line = inFile.readLine()) != null) {
                if(line.contains(">")){
                    seqe = inFile.readLine();
                    countDB++;
                    String[] headers = line.split(">"); // Split the header in parts if multiple ">" are present.
                    for(String headerPart : headers){
                        if(!headerPart.equals("")){

                            String[] header = headerPart.split("\\|")[4].split(" "); // Split one header into small parts " [Virgibacillus, pantothenticus, strain, NCDO, 1765, 16S, ribosomal, RNA, gene, partial sequence]"

                            organism = header[1]+ " " + header[2];

                            if(header.length > 2){
                                for(String s : header){
                                    if(s.equals("strain")){
                                        strain = header[3]+ " " + header[4] + " "+ header[5];
                                    }
                                }

                            }


                            createHeader creater= new createHeader(organism, strain, headerPart.split("\\|")[3], namesTax, namesName, namesSyno, nodesNCBI, goodies, seqe, bw) ;

                        }




                    }
                }


            }
            System.out.println(countDB);
        }
        catch (FileNotFoundException e){
            System.out.println("DB 16SMicrobial not found");
        }
        catch (IOException e){
            System.out.println("DB 16SMicrobial IOerror");
        }


    }
}
