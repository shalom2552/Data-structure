/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * Implementation of an Edge in a graph
 *
 * --- GRAPH-EDGE ---
 */
public class GraphEdge {

    GraphNode from;
    GraphNode to;
    Element from_pointer;
    Element to_pointer;

    /**
     * Constructor
     *
     * @param from graph node
     * @param to   graph node
     */
    public GraphEdge(GraphNode from, GraphNode to) {
        this.from = from;
        this.to = to;
        this.from_pointer = new Element(from);
        this.to_pointer = new Element(to);
        this.from.outEdges.insert(this.to_pointer);
        this.to.inEdges.insert(this.from_pointer);
    }

    /**
     * Returns the node who the edge coming out from
     *
     * @return graph node
     */
    public GraphNode getFrom() {
        return this.from;
    }

    /**
     * Returns the node who the edge coming in to
     *
     * @return graph node
     */
    public GraphNode getTo() {
        return this.to;
    }

}
