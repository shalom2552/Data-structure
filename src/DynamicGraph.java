public class DynamicGraph {

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
//        stack<int> Stack;
//
//         Mark all the vertices as not visited (For first DFS)
//        bool *visited = new bool[V];
//        for(int i = 0; i < V; i++)
//            visited[i] = false;
//
//        // Fill vertices in stack according to their finishing times
//        for(int i = 0; i < V; i++)
//            if(visited[i] == false)
//                fillOrder(i, visited, Stack);
//
//        // Create a reversed graph
//        Graph gr = getTranspose();
//
//        // Mark all the vertices as not visited (For second DFS)
//        for(int i = 0; i < V; i++)
//            visited[i] = false;
//
//        // Now process all vertices in order defined by Stack
//        while (Stack.empty() == false)
//        {
//            // Pop a vertex from stack
//            int v = Stack.top();
//            Stack.pop();
//
//            // Print Strongly connected component of the popped vertex
//            if (visited[v] == false)
//            {
//                gr.DFSUtil(v, visited);
//                cout << endl;
//            }
//        }

        return null;
    }

    public RootedTree bfs(GraphNode source){
        //// Mark all the vertices as not visited
//
//        bool *visited = new bool[V];
//        for(int i = 0; i < V; i++)
//            visited[i] = false;
//
//        // Create a queue for BFS
//        list<int> queue;
//
//        // Mark the current node as visited and enqueue it
//        visited[s] = true;
//        queue.push_back(s);
//
//        // 'i' will be used to get all adjacent
//        // vertices of a vertex
//        list<int>::iterator i;
//
//        while(!queue.empty())
//        {
//            // Dequeue a vertex from queue and print it
//            s = queue.front();
//            cout << s << " ";
//            queue.pop_front();
//
//            // Get all adjacent vertices of the dequeued
//            // vertex s. If a adjacent has not been visited,
//            // then mark it visited and enqueue it
//            for (i = adj[s].begin(); i != adj[s].end(); ++i)
//            {
//                if (!visited[*i])
//                {
//                    visited[*i] = true;
//                    queue.push_back(*i);
//                }
//            }
//        }

        return null;
    }




    public static void main(String[] args) {
        System.out.println("Main!");

        // TODO
        DynamicGraph G = new DynamicGraph();
        G.insertNode(5);

    }

}
