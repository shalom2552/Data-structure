import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {

    // left-child right-civilian
    final GraphNode root;

//    GraphNode nodes_head;
//    GraphEdge edges_head;

    // O(1)
    public RootedTree(){
        this.root = new GraphNode(0);
    }




    // todo
    public void printByLayer(DataOutputStream out) throws IOException {
        boolean last_child = false;
        GraphNode current_node = this.root;
        while (!last_child){

            out.write(current_node.getKey());
            if (current_node.right_civilian == null) last_child = true;
        }
    }

    public void preorderPrint(DataOutputStream out){

    }




}
