public class DynamicGraph {

    RootedTree tree;

    GraphNode nodes_head;
    GraphEdge edges_head;

    // default constructor
    public DynamicGraph(){
        this.nodes_head = null;
        this.edges_head = null;
    }


    public GraphNode insertNode(int nodeKey){
        GraphNode new_node = new GraphNode(nodeKey);
        if (this.nodes_head != null){
            this.nodes_head.prev = new_node;
            new_node.next = nodes_head;
        }
        this.nodes_head = new_node;
        return new_node;
    }

    public void deleteNode(GraphNode node){
        if (node.getInDegree() == 0 && node.getOutDegree() == 0){
            //nodes.Delete(node);
            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                this.nodes_head = node.next;
            }
            if (node.next != null){
                node.next.prev = node.prev;
            }
        }
    }


    public GraphEdge insertEdge(GraphNode from, GraphNode to){
        GraphEdge new_edge = new GraphEdge(from, to);
        // Add the new edge to Graph's edges list
        if (this.edges_head != null){
            new_edge.next = this.edges_head;
            this.edges_head.prev = new_edge;
        } else {
            this.edges_head = new_edge;
        }
        return new_edge;
    }

    public void deleteEdge(GraphEdge edge){
        // Remove from the edges list

        // remove the in and out list of the corresponding nodes
    }

    // צריך להחזיר עץ מושרש עם שורש 'דמיוני' אשר יש לו n ילדים (כאשר n מס' הרכיבים הקשירים שמצאנו בגרף
    // scc מריץ פעמיים dfs. אתם מתבקשים להחזיר את הפלט של ה dfs השני שמיוצג ע"י המחלקה RootedTree לאחר שהוספתם צומת דימיוני.
    // כמו כן, חשוב לשים לב שדאגנו לקבע את סדר סריקת הצמתים והקשתות בהרצת dfs
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
