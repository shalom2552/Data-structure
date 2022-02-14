/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * Implementation of a node in a graph
 *
 * --- GRAPH-NODE ---
 */
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


    /**
     * Returns the amount edges going out of the node
     * Complexity: O(out degree(v))
     *
     * @return length of the out edges list
     */
    public int getOutDegree() {
        return this.outEdges.list.length;
    }


    /**
     * Returns the amount edges going in to the node
     * Complexity: O(in degree(v))
     *
     * @return length of the in edges list
     */
    public int getInDegree() {
        return this.inEdges.list.length;
    }


    /**
     * Complexity: O(1)
     *
     * @return key of the node
     */
    public int getKey() {
        return this.key;
    }


}