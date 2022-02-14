public class GraphNode {

    int key;
    int d;
    int f;
    char color;
    List inEdges;
    List outEdges;
    Element pointer;
    GraphNode parent;
    GraphNode place_holder;

    public GraphNode(int key) {
        this.key = key;
        this.inEdges = new List();
        this.outEdges = new List();
        this.place_holder = null;
    }


    // O(deg_out(v))
    // out degree of node v
    public int getOutDegree() {
        return this.outEdges.list.length;
    }


    // O(deg_in(v))
    // in degree of node v
    public int getInDegree(){
        return this.inEdges.list.length;
    }


    // O(1)
    public int getKey(){
    return this.key;
    }


}