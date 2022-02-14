// A class to represent a queue
class List
{

    LinkedList list;
    Element last;

    public List(){
        this.list = new LinkedList();
    }

    /**
     *
     * @param element
     */
    public List(Element element){
        element.next = null;
        element.prev = null;
        this.last = element;
        list.insert(element);
    }

    /**
     *
     * @param element
     */
    public void insert(Element element){
        if (this.last == null){
            list.insert(element);
        } else {
            list.insertAfter(element, last);
        }
        this.last = element;
    }

    /**
     *
     * @return
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
