public class LinkedList {

    Element head;
    int length = 0;

    public void insert(Element element){
        element.next = this.head;
        if (this.head != null)
            head.prev = element;
        head = element;
        element.prev = null;
        this.length++;
    }

    public void insertAfter(Element new_element, Element element){
        if (element.next != null)
            element.next.prev = new_element;
        new_element.next = element.next;
        element.next = new_element; // TODO ?
        new_element.prev = element;
        this.length++;
    }

    public void delete(Element element){
        if (element.prev != null)
            element.prev.next = element.next;
        else
            this.head = element.next;
        if (element.next != null)
            element.next.prev = element.prev;
        if (element.next != null)
            element.next.prev = element.prev;
        this.length--;
        assert this.length >= 0; // TODO ?
    }

}
