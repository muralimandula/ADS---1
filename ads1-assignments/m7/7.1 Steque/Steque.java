import java.util.Iterator;

/**
 * Class for steque.
 *
 * @param      <Generic>  The data type Object.
 */
class Steque <Generic> {

    /**
     * Class for node.
     */
    private class Node {

        /**
         * That store value of Node of type generic.
         */
        Generic data;

        /**
         * To Store the address of the next node.
         */
        Node next;

        /**
         * Constructs the object that creates a node with data, next fields.
         *
         * @param      data  The data, value of node.
         * @param      next  The next, address of next.
         */
        Node(Generic data, Node next) {

            this.data = data;
            this.next = next;
        }
    }


    /**
     * Head and Tail of the Steque.
     */
    private Node head, tail;

    /**
     * To insert value into Steque.
     *
     *                         TIme Complexity is 1 (No iterations).
     *
     * @param      data  The data, value of node.
     */
    public void push(Generic data) {

        /**
         * New node with a value and a head(as next) field.
         */
        Node node = new Node(data, head);

        if (head == null) {
            head = node;
            tail = node;
            // return;
        } else {
        head = node;
        }
    }


    /**
     * Pop, to remove node from Steque.
     *
     *                         TIme Complexity is 1 (No iterations).
     *
     * @return     The removed node value of type Generic.
     *
     * @throws     Exception  Empty, if Steque found empty.
     */
    public Generic pop() throws Exception {
        if (head == null) throw new Exception("Steque is empty.");
        Generic data = head.data;
        head = head.next;
        return data;
    }


    /**
     * Enqueue, to assign first occupied position/tail to new node.
     *
     *                         TIme Complexity is 1 (No iterations).
     *
     * @param      data  Value of node to add/enqueue.
     */
    public void enqueue(Generic data) {
        if (head == null) {
            push(data);
            return;
        }
        tail.next = new Node(data, null);
        tail = tail.next;
    }

    /**
     * converting to string, prints all the content of object.
     * Has "for loop" to iterate over elements of the object.
     *
     *                         TIme Complexity is N (Say, object has N elements)
     *
     * @return     String format of object.
     *
     * @throws     Exception  If object is empty.
     */
    public String convertString() throws Exception {
        if (head == null) throw new Exception("Steque is empty.");
        String str = "";


        for (Iterator i = this.iterate(); i.hasNext(); str += i.next() + ", ");
        return str.substring(0, str.length() - 2);
    }


    /**
     * Iterator overriding.
     *
     * @return     Iterator.
     */
    public Iterator  iterate() {
        return new StIterator(head);
    }

    /**
     * Class for Steque Iterator as StIterator.
     */
    private class StIterator implements Iterator {
        private Node current;

        StIterator(Node node) {
            current = node;
        }

        /**
         * Determines if it has next.
         *
     *                         TIme Complexity is 1 (No iterations).
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * { function_description }
         */
        public void remove() {
            //Empty method.
        }


        /**
         * TO get next Node's address from curent node.
         *
     *                         TIme Complexity is 1 (No iterations).
         *
         * @return     Next node value of type Generic.
         */
        public Generic next() {
            Generic data = current.data;
            current = current.next;
            return data;
        }
    }


}

