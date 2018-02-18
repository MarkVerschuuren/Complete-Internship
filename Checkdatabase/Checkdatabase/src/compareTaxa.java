import java.io.*;
import java.util.Arrays;

public class compareTaxa {
    BufferedReader inFile;
    BufferedReader inFile2;
    BufferedWriter writer;
    formatNames names = new formatNames();
    formatNodes nodes = new formatNodes();

    /**
     *
     * @param blastPath Path to open blastfile;
     * @param greenPath path to open Database
     */
    public compareTaxa(String blastPath, String greenPath){
        try{
            inFile = new BufferedReader(new FileReader(greenPath));
            inFile2 = new BufferedReader(new FileReader(blastPath));
            FileWriter fw = new FileWriter("/home/han-bc-bipc4/compareblaster", true);
            BufferedWriter bw = new BufferedWriter(fw);

             bw.write( "GreenSpecies" + "\t" + "taxID"
             + "\t" + "BlastSpecies" + "\t" + "taxID"
             + "\t" + "GreenGenus" + "\t" + "taxID"
             +"\t" + "BlastGenus" + "\t" + "taxID"
             + "\t" + "GreenFamily" + "\t" + "taxID"
             + "\t" + "BlastFamily" + "\t" + "taxID"
             + "\t" + "GreenOrder" + "\t" + "taxID"
             + "\t" + "BlastOrder" + "\t" + "taxID"
             + "\t" + "GreenClass"  + "\t" + "taxID"
             + "\t" + "BlastClass" + "\t" + "taxID"
             + "\t" + "sequenceGG" +  "\n");



            String line;
            String line2;

            while((line = inFile.readLine()) != null){

                line2 = inFile2.readLine();

                String[] blast = line2.split("\t");
                String[] green = line.split(";");
                String seq = inFile.readLine();
                System.out.println(green[0]);
                if(green[0].split(">")[1].equals(blast[0].split(";")[0])){
                    System.out.println("hi");

                    Compare comp = new Compare(blast, green, names.getNamesNCBIName(), nodes.getNodesNCBI(), names.getNamesNCBITax(), bw, seq);

                }
                else{

                }




            }


        }
        catch (IOException e){
            System.out.println("Error");
        }

    }
}
