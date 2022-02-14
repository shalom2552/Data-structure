/**
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 * Implementation of a LinkedList.
 *
 * --- LINKED-LIST ---
 */
public class LinkedList {

    Element head;
    int length = 0;

    /**
     * Adding of an element into the lost
     *
     * @param element to insert
     */
    public void insert(Element element) {
        element.next = this.head;
        if (this.head != null)
            head.prev = element;
        head = element;
        element.prev = null;
        this.length++;
    }

    /**
     * Adding of an element into the lost at a specific location.
     *
     * @param new_element to insert
     * @param element     to insert after
     */
    public void insertAfter(Element new_element, Element element) {
        if (element.next != null)
            element.next.prev = new_element;
        new_element.next = element.next;
        element.next = new_element;
        new_element.prev = element;
        this.length++;
    }

    /**
     * Deleting an elemnt from the list
     *
     * @param element to remove
     */
    public void delete(Element element) {
        if (element.prev != null)
            element.prev.next = element.next;
        else
            this.head = element.next;
        if (element.next != null)
            element.next.prev = element.prev;
        this.length--;
    }

}
