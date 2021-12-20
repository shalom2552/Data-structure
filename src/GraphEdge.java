public class GraphEdge {

    GraphNode from;
    GraphNode to;
    GraphEdge before;
    GraphEdge next;

    public GraphEdge(GraphNode from, GraphNode to){
        this.from = from;
        this.to = to;
    }


}
