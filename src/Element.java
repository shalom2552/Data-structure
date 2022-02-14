public class Element {

    GraphNode pointer;
    Element next;
    Element prev;

    public Element(GraphNode pointer){
        this.pointer = pointer;
    }

    public GraphNode getPointer(){
        return this.pointer;
    }

    public Element getNext(){
        return this.next;
    }

    public Element getPrev(){
        return this.prev;
    }

}
