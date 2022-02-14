/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * This is the main file of the data structure
 * It has actions and algorithms learned in the course
 *
 * --- DYNAMIC-GRAPH ---
 */
public class DynamicGraph {

    static int tick;
    List graphNodes;

    /**
     * Default constructor
     */
    public DynamicGraph() {
        this.graphNodes = new List();
    }

    /**
     * insert a new node into the graph
     * complexity: O(1)
     *
     * @param nodeKey key to the new node
     * @return the new added node
     */
    public GraphNode insertNode(int nodeKey) {
        GraphNode new_node = new GraphNode(nodeKey);
        Element node_pointer = new Element(new_node);
        graphNodes.insert(node_pointer);
        new_node.pointer = node_pointer;
        return new_node;
    }

    /**
     * Delete a node from the graph
     *
     * @param node to remove
     */
    public void deleteNode(GraphNode node) {
        if (node.getInDegree() == 0 && node.getOutDegree() == 0) {
            if (node.pointer == graphNodes.last) {
                graphNodes.last = graphNodes.last.prev;
            }
            graphNodes.list.delete(node.pointer);
        }
    }

    /**
     * Adding a new edge to the graph
     *
     * @param from graph node
     * @param to   graph node
     * @return the created edge
     */
    public GraphEdge insertEdge(GraphNode from, GraphNode to) {
        return new GraphEdge(from, to);
    }

    /**
     * Deleting of an edge from the graph
     *
     * @param edge to remove
     */
    public void deleteEdge(GraphEdge edge) {
        // fix last element in the lists
        if (edge.to_pointer == edge.from.outEdges.last)
            edge.from.outEdges.last = edge.from.outEdges.last.prev;
        if (edge.from_pointer == edge.to.inEdges.last)
            edge.to.inEdges.last = edge.to.inEdges.last.prev;
        // Delete the edge from the 'in' and 'out' lists
        edge.from.outEdges.list.delete(edge.to_pointer);
        edge.to.inEdges.list.delete(edge.from_pointer);
    }


    /**
     * implementation of the SCC algorithm
     *
     * @return rooted tree
     */
    public RootedTree scc() {
        RootedTree tree = new RootedTree();
        tree.root = new GraphNode(0);
        List nodes = dfs(this.graphNodes);
        transpose(nodes);
        List scc_nodes = dfs(nodes);
        transpose(nodes);
        Element node = scc_nodes.list.head;
        while (node != null) {
            node.pointer.place_holder = new GraphNode(node.pointer.key);
            node = node.next;
        }
        node = scc_nodes.list.head;
        while (node != null) {
            if (node.pointer.parent == null)
                new GraphEdge(tree.root, node.pointer.place_holder);
            else new GraphEdge(node.pointer.parent.place_holder, node.pointer.place_holder);
            node = node.next;
        }
        return tree;
    }

    /**
     * Transpose all the graph edges
     *
     * @param nodes list of the graph nodes
     */
    public void transpose(List nodes) {
        Element node = nodes.list.head;
        while (node != null) {
            List outEdges = node.pointer.outEdges;
            node.pointer.outEdges = node.pointer.inEdges;
            node.pointer.inEdges = outEdges;
            node = node.next;
        }
    }


    /**
     * Init function for the bfs algorithm
     *
     * @param source graph node
     * @param list   of graph nodes
     */
    public void bfs_init(GraphNode source, List list) {
        int negative_inf = Integer.MIN_VALUE;
        Element node = this.graphNodes.list.head;
        while (node != null) {
            node.pointer.color = 'w';
            node.pointer.d = negative_inf;
            node.pointer.parent = null;
            node.pointer.place_holder = null;
            node = node.next;
        }
        list.insert(new Element(source));
        source.color = 'g';
        source.parent = null;
    }

    /**
     * implementation of the BFS algorithm
     * colors: 'w': white,'g': gray,'b': black.
     *
     * @param source graph node
     * @return rooted tree
     */
    public RootedTree bfs(GraphNode source) {
        RootedTree tree = new RootedTree();
        List list = new List();
        bfs_init(source, list);
        source.place_holder = new GraphNode(source.key);
        while (list.last != null) {
            Element node = list.pop();
            Element neighbor = node.pointer.outEdges.last;
            while (neighbor != null) {
                if (neighbor.pointer.color == 'w') {
                    neighbor.pointer.color = 'g';
                    neighbor.pointer.d = node.pointer.d + 1;
                    neighbor.pointer.parent = node.pointer;
                    if (neighbor.pointer.place_holder == null) {
                        neighbor.pointer.place_holder = new GraphNode(neighbor.pointer.key);
                    }
                    new GraphEdge(node.pointer.place_holder, neighbor.pointer.place_holder);
                    list.insert(new Element(neighbor.pointer));
                }
                neighbor = neighbor.prev;
            }
            node.pointer.color = 'b';
        }
        tree.root = source.place_holder;
        return tree;
    }

    /**
     * implementation of the DFS algorithm
     *
     * @param nodes list of graph nodes
     * @return list of graph nodes
     */
    public List dfs(List nodes) {
        Element node = nodes.list.head;
        List dfs_nodes = new List();
        while (node != null) {
            node.pointer.color = 'w';
            node.pointer.parent = null;
            node.pointer.place_holder = null;
            node = node.next;
        }
        tick = 0;
        node = nodes.last;
        while (node != null) {
            if (node.pointer.color == 'w')
                dfs_visit(dfs_nodes, node.pointer);
            node = node.prev;
        }
        return dfs_nodes;
    }


    /**
     * implementation of the DFS visit
     *
     * @param nodes list of graph nodes
     * @param node  graph node
     */
    public void dfs_visit(List nodes, GraphNode node) {
        tick++;
        node.d = tick;
        node.color = 'g';
        Element neighbor = node.outEdges.list.head;
        while (neighbor != null && neighbor.next != null)
            neighbor = neighbor.next;
        while (neighbor != null) {
            if (neighbor.pointer.color == 'w') {
                neighbor.pointer.parent = node;
                dfs_visit(nodes, neighbor.pointer);
            }
            neighbor = neighbor.prev;
        }
        tick++;
        node.f = tick;
        node.color = 'b';
        nodes.insert(new Element(node));
    }

}
