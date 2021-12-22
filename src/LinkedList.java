public class LinkedList<T> {

    Node<T> head;


    public LinkedList(){
        this.head = null;
    }

    /**
     * Insert Node x to the front of this list
     */
    public void Insert(Node<T> elem){
        elem.next = head;
        if (this.head != null){
            this.head.prev = elem;
        }
        this.head = elem;
        elem.prev = null;
    }

    public void Delete(Node<T> elem){
        if (elem.prev != null) {
            elem.prev.next = elem.next;
        } else {
            this.head = elem.next;
        }
        if (elem.next != null){
            elem.next.prev = elem.prev;
        }
    }

    public int GetLength(){
        int count = 0;
        if (this.head == null){
            return count;
        }
        count = 1;
        Node<T> node = this.head;
        while (node.next != null){
            node = node.next;
            count++;
        }
        return count;
    }
}


class Node<T>{

    T pointer;
    Node<T> next;
    Node<T> prev;

    public Node(T pointer, Node<T> next, Node<T> prev){
        this.pointer = pointer;
        this.next = next;
        this.prev = prev;
    }

}