

/**
 * Created by Mark Verschuuren on 21-11-2017.
 * @names Class that is based on modifying the names.dmp data file from NCBI to a Hashmap datastructure.
 * @see formatNames
 * @nodes Class that is based on modifying the nodes.dmp data file from NCBI to a Hashmap datastructure.
 * @see formatNodes
 * @map Class which uses both the datasctructures from @names and @nodes to change the taxon header of the GreenGenes headers.
 * @see makeTaxMap
 */
public class mainScript {

    public static void main(String[] args) {
        formatNames names = new formatNames();
        formatNodes nodes = new formatNodes();
        makeTaxMap map = new makeTaxMap(names.getNamesNCBIName(),names.getNamesNCBITax(), names.getNamesNCBISyno() ,  nodes.getNodesNCBI());
    }
}
