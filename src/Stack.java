public class Stack<T> {
    private Stack<T> stack;
    private T top;
    private int size;


    // default constructor
    public Stack(){
        this.size = 0;
        this.stack = null;
        this.top = null;
    }

    public Stack(T top){
        this.size = 1;
        this.top = top;
    }

    public Stack(Stack<T> stack, T top){
        this.stack = stack;
        this.top = top;
        this.size = this.stack.size() + 1;
    }


    // Returns size of the stack
    public int size(){
        return this.size;
    }


    // Adding an element to the top of the stack
    public void push(T element){
        if (this.top == null){
            this.top = element;
            this.size = 1;
        } else if (this.stack == null){
            this.stack = new Stack<>(this.top);
            this.top = element;
            this.size = 2;
        } else {
            this.stack = new Stack<>(this.stack, element);
            this.top = element;
            this.size = this.stack.size() + 1;
        }
    }


    // Return and remove the top item from the stack
    public T pop(){
        if (this.top != null) {
            T top = this.top;
            if (this.stack != null) {
                this.top = this.stack.top;
                this.stack = this.stack.stack;
                this.size--;
            } else {
                this.top = null;
                this.size =0;
            }
            return top;
        }
        return null;
    }


    // Show the top item
    public T peek(){
        return this.top;
    }


    // Find element index in the stack
    public int findElement(Object object){
        int index = 1;
        Stack<T> stack = this;
        while (stack.size() != 0){
            if (stack.size == 0){
                return index;
            }
            stack = stack.stack;
            index++;
        }
        return -1;
    }



}
