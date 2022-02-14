/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * Implementation of a Queue\List
 *
 * --- LIST ---
 */
class List {

    LinkedList list;
    Element last;

    /**
     * Default constructor
     */
    public List() {
        this.list = new LinkedList();
    }

    /**
     * Constructor with the first element
     *
     * @param element first to insert
     */
    public List(Element element) {
        element.next = null;
        element.prev = null;
        this.last = element;
        list.insert(element);
    }

    /**
     * Adding of a new element to the list
     *
     * @param element to add
     */
    public void insert(Element element) {
        if (this.last == null) {
            list.insert(element);
        } else {
            list.insertAfter(element, last);
        }
        this.last = element;
    }

    /**
     * Returns and remove the most waited element in the list
     *
     * @return the oldest element
     */
    public Element pop() {
        if (list.head != null) {
            Element head = new Element(this.list.head.pointer);
            this.list.delete(this.list.head);
            if (this.list.head == null) {
                this.last = null;
            }
            return head;
        }
        return null;
    }

}
