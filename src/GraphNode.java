public class GraphNode {

    private final int key;

    // TODO implement some data structure for the edgens of the node
    // TODO is this node need to be implemented by the left_child-right_sibling way?
//    GraphNode left_child;
//    GraphNode right_sibling;
//    boolean is_leaf;
    protected GraphNode prev;
    protected  GraphNode next;

    GraphNode parent;
    GraphNode left_child;
    GraphNode right_civilian;


    public GraphNode(int key) {
        this.key = key;
//        this.left_child = left_child;
//        this.right_sibling = right_sibling;
//        this.is_leaf = left_child == null;
        this.prev = null;
        this.next = null;
        this.parent = null;
        this.left_child = null;
        this.right_civilian = null;
    }


    // O(deg_out(v))
    // out degree of node v
    public int getOutDegree() {
        if (this.left_child == null) return 0;
        GraphNode focus_node = this.left_child;
        int counter = 1;
        while (focus_node.right_civilian != null){
            counter++;
            focus_node = focus_node.right_civilian;
        }
        return counter;
    }


    // O(deg_in(v))
    // in degree of node v
    // TODO isn't that only 0 ot 1?
    public int getInDegree(){
        return ((this.parent == null) ? 0 : 1);
    }


    // O(1)
    public int getKey(){
    return this.key;
    }


}