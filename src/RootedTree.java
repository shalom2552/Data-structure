/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * Printing methods of a tree
 *
 * --- ROOTED-TREE-
 */

import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {

    GraphNode root;


    /**
     * Default constructor
     * Complexity: O(1)
     */
    public RootedTree() {
    }


    /**
     * Print the graph layer by layer
     *
     * @param out the output stream
     * @throws IOException for DataOutputStream
     */
    public void printByLayer(DataOutputStream out) throws IOException {
        try {
            int negative_inf = Integer.MIN_VALUE;
            List queue = new List();
            Element focus_element;
            Element root_element = new Element(this.root);
            queue.insert(root_element);
            GraphNode minimum_node = new GraphNode(negative_inf);
            Element minimum_element = new Element(minimum_node);
            queue.insert(minimum_element);
            while (queue.list.head != null) {
                focus_element = queue.pop();
                if (focus_element.pointer.key == negative_inf) {
                    if (queue.list.head != null) {
                        queue.insert(new Element(new GraphNode(negative_inf)));
                    }
                }
                if (focus_element.pointer.outEdges.list.length > 0) {
                    Element focus_neighbor = focus_element.pointer.outEdges.list.head;
                    while (focus_neighbor != null) {
                        queue.insert(new Element(focus_neighbor.pointer));
                        focus_neighbor = focus_neighbor.next;
                    }
                }
                if (queue.list.head != null && queue.list.head.pointer.key == negative_inf) {
                    if (queue.list.head.next == null) {
                        out.writeBytes(focus_element.pointer.key + "");
                    } else {
                        out.writeBytes(focus_element.pointer.key + "\n");
                    }
                } else {
                    out.writeBytes(focus_element.pointer.key + ",");
                }
            }
        } catch (IOException ignored) {
        }
    }

    /**
     * Print the graph by order
     *
     * @param out the output stream
     * @throws IOException for DataOutputStream
     */
    public void preorderPrint(DataOutputStream out) throws IOException {
        GraphNode node = this.root;
        while (node.outEdges.last != null)
            node = node.outEdges.last.pointer;
        preorderPrintRecursive(node.key, this.root, out);
    }

    /**
     * A recursive function used by the original function to print the layers of the graph
     *
     * @param key  of the root
     * @param root of the graph
     * @param out  the output stream
     */
    public static void preorderPrintRecursive(int key, GraphNode root, DataOutputStream out) throws IOException {
        try {
            if (root == null)
                return;
            Element focus_element = root.outEdges.list.head;
            if (root.key == key)
                out.writeBytes(root.key + "");
            else
                out.writeBytes(root.key + ",");
            while (focus_element != null) {
                preorderPrintRecursive(key, focus_element.pointer, out);
                focus_element = focus_element.next;
            }
        } catch (IOException ignored) {
        }
    }


}
