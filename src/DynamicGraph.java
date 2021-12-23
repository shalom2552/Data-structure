public class DynamicGraph {

    RootedTree tree;

    LinkedList<GraphNode> nodes;
    LinkedList<GraphEdge> edges;

    // default constructor
    public DynamicGraph(){
        this.nodes = null;
        this.edges = null;
    }


    public GraphNode insertNode(int nodeKey){
        Node<GraphNode> node = new Node<>(new GraphNode(nodeKey, null, null), null, null);
        this.nodes.Insert(node);
        return node.pointer;
    }

    public void deleteNode(GraphNode node){

    }

//    public GraphNode insertNode(int nodeKey){
//        GraphNode node = new GraphNode(nodeKey, null, null);
//        GraphNode[] old_nodes = this.tree.nodes;
//        int num_nodes = old_nodes.length;
//        GraphNode[] new_nodes = new GraphNode[num_nodes + 1];
//        for (int i = 0; i < num_nodes; i++) {
//            new_nodes[i] = old_nodes[i];
//        }
//        new_nodes[num_nodes + 1] = node;
//        this.tree.nodes = new_nodes;
//        return node;
//    }
//
//    public void deleteNode(GraphNode node){
//        // TODO those algorithms can't be implemented that way!!
//        // TODO they have to be O(1), then maybe linked lists?
//        if (node.getInDegree() == 0 && node.getOutDegree() == 0){
//            int key = node.getKey();
//            GraphNode[] old_nodes = this.tree.nodes;
//            int num_nodes = old_nodes.length;
//            GraphNode[] new_nodes = new GraphNode[num_nodes - 1];
//            int index = 0;
//            for (GraphNode old_node : old_nodes) {
//                if (old_node.getKey() != key) {
//                    new_nodes[index] = old_node;
//                    index++;
//                }
//            }
//            this.tree.nodes = new_nodes;
//        }
//    }

    public GraphEdge insertEdge(GraphNode from, GraphNode to){
        return null;
    }

    public void deleteEdge(GraphEdge edge){

    }

    public RootedTree scc(){
        return null;
    }

    public RootedTree bfs(GraphNode source){
        return null;
    }




    public static void main(String[] args) {
        System.out.println("Main!");
    }

}
