public class mainMethod {

    public static void main(String[] args) {

        formatNames names = new formatNames();
        formatNodes nodes = new formatNodes();
        parseDB parser = new parseDB("/home/han-bc-bipc4/IdeaProjects/NCBI16s_DB/DB/NCBI16S.fasta", names.getNamesNCBITax(), names.getNamesNCBIName(),names.getNamesNCBISyno(), nodes.getNodesNCBI());
           }
}
