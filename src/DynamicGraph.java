/**
 *
 * Core DynamicGraph class
 *
 * by @shalom_mauda @eliyahu_amar
 *
 * --- DYNAMIC-GRAPH --- */
public class DynamicGraph {

    static int tick;
    List graphNodes;
    GraphEdge edges_head;

    /**
     * Default constructor
     */
    public DynamicGraph(){
        this.graphNodes = new List();
    }

    /**
     * insert a new node into the graph
     * complexity: O(1)
     * @param nodeKey key to the new node
     * @return the new added node
     */
    public GraphNode insertNode(int nodeKey){
        GraphNode new_node = new GraphNode(nodeKey);
        Element node_pointer = new Element(new_node);
        graphNodes.insert(node_pointer);
        new_node.pointer = node_pointer;
        return new_node;
    }

    /**
     *
     * @param node
     */
    public void deleteNode(GraphNode node){
        if (node.getInDegree() == 0 && node.getOutDegree() == 0){
            if (node.pointer == graphNodes.last){
                graphNodes.last = graphNodes.last.prev;
            }
            graphNodes.list.delete(node.pointer);
        }
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    public GraphEdge insertEdge(GraphNode from, GraphNode to){
        GraphEdge edge = new GraphEdge(from, to);
        /*
        * edge.from.outEdges.list.insert(edge.to_pointer);
        * edge.to.inEdges.list.insert(edge.from_pointer);
        */
        return edge;
    }

    /**
     *
     * @param edge
     */
    public void deleteEdge(GraphEdge edge){
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
     *
     * @return
     */
    public RootedTree scc(){
        RootedTree tree = new RootedTree();
        tree.root = new GraphNode(0); // TODO 0?
        List nodes = dfs(this.graphNodes);
        transpose(nodes);
        List scc_nodes = dfs(nodes);
        transpose(nodes);
        Element node = scc_nodes.list.head;
        while (node != null){
            node.pointer.place_holder = new GraphNode(node.pointer.key);
            node = node.next;
        }
        node = scc_nodes.list.head;
        while (node != null){
            if (node.pointer.parent == null)
                new GraphEdge(tree.root, node.pointer.place_holder);
            else new GraphEdge(node.pointer.parent.place_holder, node.pointer.place_holder);
            node = node.next;
        }
        return tree;
    }

    /**
     *
     * @param nodes
     */
    public void transpose(List nodes){
        Element node = nodes.list.head;
        while (node != null){
            List outEdges = node.pointer.outEdges;
            node.pointer.outEdges = node.pointer.inEdges;
            node.pointer.inEdges = outEdges;
            node = node.next;
        }
    }


    public void bfs_init(GraphNode source, List list){
        Integer negative_inf = Integer.MIN_VALUE;
        Element node = this.graphNodes.list.head;
        while (node != null){
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
     * colors: 'w': white,'g': gray,'b': black.
     * @param source
     * @return
     */
    public RootedTree bfs(GraphNode source){
        RootedTree tree = new RootedTree();
        List list = new List();
        bfs_init(source, list);
        source.place_holder = new GraphNode(source.key);
        while (list.last != null){
            Element node = list.pop();
            Element neighbor = node.pointer.outEdges.last;
            while (neighbor != null){
                if (neighbor.pointer.color == 'w'){
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
     *
     * @param nodes
     * @return
     */
    public List dfs(List nodes){
        Element node = nodes.list.head;
        List dfs_nodes = new List();
        while (node != null){
            node.pointer.color = 'w';
            node.pointer.parent = null;
            node.pointer.place_holder = null;
            node = node.next;
        }
        tick = 0;
// ==============================================================================
        node = nodes.list.head;
        while (node != null && node.next != null)
            node = node.next;
// ====TODO====^^^^^^^===========================================================
//        node = nodes.last;
// ==============================================================================
        while (node != null){
            if (node.pointer.color == 'w')
                dfs_visit(dfs_nodes, node.pointer);
            node = node.prev;
        }
        return dfs_nodes;
    }



    /**
     *
     * @param nodes
     * @param node
     */
    public void dfs_visit(List nodes, GraphNode node){
        tick++;
        node.d = tick;
        node.color = 'g';
        Element neighbor = node.outEdges.list.head;
        while (neighbor != null && neighbor.next != null)
            neighbor = neighbor.next;
        while (neighbor != null){
            if (neighbor.pointer.color == 'w'){
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
