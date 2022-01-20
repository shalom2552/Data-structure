import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {

    final GraphNode root;
    GraphNode[] nodes;
    GraphEdge[] edges;

    // O(1)
    public RootedTree(int key){
        this.root = new GraphNode(key);
    }


    
    public void printByLayer(DataOutputStream out){
        
    }

    public void preorderPrint(DataOutputStream out){

    }



}
