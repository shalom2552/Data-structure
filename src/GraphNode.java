public class GraphNode {

    private final int key;

    // TODO is this node need to be implemented by the left_child-right_sibling way?
    GraphNode left_child;
    GraphNode right_sibling;
    boolean is_leaf;

    // Linked list method
    LinkedList<GraphNode> children;
    LinkedList<GraphNode> parents;


    public GraphNode(int key, GraphNode left_child, GraphNode right_sibling) {
        this.key = key;
        this.left_child = left_child;
        this.right_sibling = right_sibling;
        this.is_leaf = left_child == null;
    }


    // Linked list use way
    // O(deg_out(v))
    // out degree of node v
    public int getOutDegree() {
        return children.GetLength();
    }

    // O(deg_in(v))
    // in degree of node v
    public int getInDegree(){
        return parents.GetLength();
    }



//      left_child-right_sibling way
//    // O(deg_out(v))
//    // out degree of node v
//    public int getOutDegree(){
//        int count = 0;
//        if (this.left_child == null){
//            return count;
//        }
//        count = 1;
//        GraphNode child = this.left_child;
//        while (child.right_sibling != null){
//            child = right_sibling.right_sibling;
//            count++;
//        }
//        return count;
//    }



    // O(1)
    public int getKey(){
    return this.key;
    }


}