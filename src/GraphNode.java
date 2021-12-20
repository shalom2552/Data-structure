public class GraphNode{

    private final int key;
    GraphEdge [] in_edges;
    GraphEdge [] out_edges;
    GraphNode before;
    GraphNode next;


    public GraphNode(int key){
        this.key = key;
    }


        // O(deg_out(v))
    // out degree of node v
    public int getOutDegree(){
        return out_edges.length;
    }

    // O(deg_in(v))
    // in degree of node v
    public int getInDegree(){
        return in_edges.length;
    }

    // O(1)
    public int getKey(){
    return this.key;
    }


}