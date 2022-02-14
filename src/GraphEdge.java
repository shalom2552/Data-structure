public class GraphEdge {

    GraphNode from;
    GraphNode to;
    Element from_pointer;
    Element to_pointer;

    public GraphEdge(GraphNode from, GraphNode to){
        this.from = from;
        this.to = to;
        this.from_pointer = new Element(from);
        this.to_pointer = new Element(to);
        this.from.outEdges.insert(this.to_pointer);
        this.to.inEdges.insert(this.from_pointer);
    }

    public GraphNode getFrom(){
        return this.from;
    }

    public GraphNode getTo(){
        return this.to;
    }

}
