import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {

    GraphNode root;


    // Default constructor
    // O(1)

    /**
     *
     */
    public RootedTree(){}


    // Constructor
    // O(1)
    /**
     *
     * @param key
     */
    public RootedTree(int key){
        this.root = new GraphNode(key);
    }


    // Constructor
    // O(1)
    /**
     *
     * @param root
     */
    public RootedTree(GraphNode root){
        this.root = root;
    }

    // TODO ?; look above constructor

    /**
     *
     * @param root
     */
    public void setRoot(GraphNode root){
        this.root = root;
    }

    /**
     *
     * @param out
     * @throws IOException
     */
    public void printByLayer(DataOutputStream out) throws IOException {
        try {
            Integer negative_inf = Integer.MIN_VALUE;
            List queue = new List();
            Element focus_element;
            Element root_element = new Element(this.root);
            queue.insert(root_element);
            GraphNode minimum_node = new GraphNode(negative_inf);
            Element minimum_element = new Element(minimum_node);
            queue.insert(minimum_element);
            while (queue.list.head != null){
                focus_element = queue.pop();
                if (focus_element.pointer.key == negative_inf){
                    if (queue.list.head != null){
                        queue.insert(new Element(new GraphNode(negative_inf)));
                    }
                }

                if (focus_element.pointer.outEdges.list.length > 0){
                    Element focus_neighbor = focus_element.pointer.outEdges.list.head;
                    while (focus_neighbor != null){
                        queue.insert(new Element(focus_neighbor.pointer));
                        focus_neighbor = focus_neighbor.next;
                    }
                }
                if (queue.list.head != null && queue.list.head.pointer.key == negative_inf){
                    if (queue.list.head.next == null){
                        out.writeBytes(focus_element.pointer.key + "");
                    } else {
                        out.writeBytes(focus_element.pointer.key + "\n");
                    }
                } else {
                    out.writeBytes(focus_element.pointer.key + ",");
                }
            }
        } catch (IOException e) { // TODO remove after debugging
            out.writeBytes("\nERROR!\n" + e + "\n");
        }
    }

    /**
     *
     * @param out
     * @throws IOException
     */
    public void preorderPrint(DataOutputStream out) throws IOException {
        GraphNode node = this.root;
        while (node.outEdges.last != null){
            node = node.outEdges.last.pointer;
        }
        preorderPrintRecursive(node.key, this.root, out);
    }

    /**
     *
     * @param key
     * @param root
     * @param out
     */
    public static void preorderPrintRecursive(int key, GraphNode root, DataOutputStream out) throws IOException {
        try {
            if (root == null){
                return;
            }
            Element focus_element = root.outEdges.list.head;

            if (root.key == key){
                out.writeBytes(root.key + "");
            } else {
                out.writeBytes(root.key + ",");
            }

            while (focus_element != null){
                preorderPrintRecursive(key, focus_element.pointer, out);
                focus_element = focus_element.next;
            }
        } catch (IOException e) { // TODO remove after debugging
            out.writeBytes("\nERROR!\n" + e + "\n");
        }
    }



}
