/**
 * Linked list implementation class.
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> {
    /**
     * Class for node.
     */
    private class Node {
        /**
         * To store list data.
         */
        E data;
        /**
         * To store the address of the next.
         */
        Node next;

        /**
         * Constructs the object.
         */
        Node() {}

        /**
         * Constructs the object.
         *
         * @param      data
         */
        Node(E data) {
            this(data, null);
        }

        /**
         * Constructs the object.
         *
         * @param      data  Data.
         * @param      next  Next address.
         */
        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Head node.
     */
    private Node head;

    /**
     * Function to add an element to the list.
     *
     * @param      e  an element.
     */
    public void add(E e) {
        Node node = new Node();
        node.data = e;
        node.next = head;

        if (head == node) {
            head = node;
        }

        head = node;
    }

    /**
     * Pop function for the list.
     *
     * @return     The element popped.
     */
    public E pop1() {
        E data = head.data;
        head = head.next;
        return data;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty1() {
        return head == null;
    }

}

/**
 * Class for stack 1.
 *
 * @param      <E>   Generic data type.
 */
public class Stack<E> {

    /**
     * Using Linked Lists.
     */
    LinkedList<E> list;

    /**
     * Constructs the object.
     */
    Stack() {
        list = new LinkedList<>();
    }

    /**
     * Push function for the stack.
     *
     * @param      e     item to be added.
     */
    public void push(E e) {
        list.add(e);
    }

    /**
     * Pop function for the stack.
     *
     * @return     The last item.
     */
    public E pop() {
        E c = list.pop1();
        return c;
    }

    /**
     *
     * @return     True if empty, else False.
     */
    public boolean isEmpty() {
        return list.isEmpty1();
    }
}