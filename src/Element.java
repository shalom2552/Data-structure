/**
 *
 * @author : Shalom Mauda, Eliahu Israel Amar
 * @mailto : shalom2552@gmail.com
 * @created : 14/12/2021, Tuesday
 *
 *
 * Implementation of a dynamic data structure,
 * as part of the course 'Data Structure and Algorithms' curse taught at Technion - israel institute of technology.
 *
 *
 * Implementation of an element in a list
 *
 * --- ELEMENT --- */
public class Element {

    GraphNode pointer;
    Element next;
    Element prev;

    /**
     * Constructor
     * @param pointer to the element reference
     */
    public Element(GraphNode pointer){
        this.pointer = pointer;
    }

}
