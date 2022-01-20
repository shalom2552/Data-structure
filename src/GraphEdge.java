public class GraphEdge {

    GraphNode from;
    GraphNode to;
    GraphEdge prev;
    GraphEdge next;

    public GraphEdge(GraphNode from, GraphNode to){
        this.from = from;
        this.to = to;
        this.prev = null;
        this.next = null;
    }


}
