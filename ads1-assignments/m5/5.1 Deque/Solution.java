import java.util.Scanner;




/**
 * Class for deque.
 *
 * @param      <Generic>  The generic
 */
class Deque<Generic> {


/**
 * Class for node.
 */
private class Node {

    /**
     * Data for generic type.
     */
    private Generic data;

    /**
     * next/reference  of the next node.
     */
    private Node next;

    /**
     * Constructs the object.
     */
    Node() {

    }

    /**
     * constructor for adding a node.
     *
     * @param      nodeData  The node data
     */
    Node(final Generic nodeData) {
        this.data = data;
    }

    /**
     * Constructs the object.
     *
     * @param      nodeData  The node data
     * @param      node      The next node
     */
    Node(final Generic nodeData, final Node node) {
        this.data = data;
        this.next = node;
    }
}

    /**
     * Constructs the object.
     */
    Deque() {

    }

    private Node head, tail; // values are null when created.
    /**
     * size of the deque.
     */
    private int size;   //No value assigned when created.

    /**
     * Pushes a left.. adding at tail.
     *
     * @param      data  The data
     */
    public void pushLeft( final Generic data) {

        if (head == null) {

            head = new Node(data);
                    // new one, created as below
                    // head.data = data;
                    // head.next = null;

            tail = head;  // i.e., only one element in deque.
                            // Tail assigned/created.
            size++;
            return;

        } else {
            Node node = new Node(data, head); // taking last assigned head.
            head = node;
            size++;

        }
    }

/**
 * Pushes a right.. adding at head.
 *
 * @param      data  The data
 */
public void pushRight(final Generic data) {

        if (head == null) {

            head = new Node(data);
                    // created as below
                    // head.data = data;
                    // head.next = null;

            tail = head;  // i.e., only one element in deque.
                            // Tail assigned/created.
            size++;
            return;

        } else {
            Node node = new Node(data, null); //null, as it's at the tail.
            tail.next = node; // adding new node/data at end.
            tail = node;  // reassigning tail with newly created, as pushRight
            size++;

        }
    }


/**
 * Removing first element/head.
 *
 * @return     returns popped element.
 */
public Generic popLeft() {

    if (head == null) {
        System.out.println("Deck is empty");
        return null;
    } else {
        Node tempBesideNode = head; //just uses to display/return.
        head = head.next;
        size--;
        return tempBesideNode.data;
    }
}

/**
 * Removing last element/tail.
 *
 * @return     returns popped element.
 */
public Generic popRight() {

    if (head == null) {
        System.out.println("Deck is empty");
        return null;
    } else {

        Node tempNode = head; //just uses to display/return.

        while(tempNode.next != tail) {
            tempNode = tempNode.next;
                    // moving towards right, till you reach tail.
        }
        Generic popped = tempNode.next.data;
        // now tempNode is last but one in the queue.
        tail = tempNode; // now tail is last but one.
        tail.next = null;
        size--;
        return popped;
    }
}

/**
 * Gets the size.
 *
 * @return     The size.
 */
public int getSize() {
    return size;
}

/**
 * Returns a string representation of the object.
 *
 * @return     String representation of the object.
 */
public String toString() {

    String output = "[";

    if (head == null) {
        return "[]";
    } else {
        Node tempNodeOut = head;

        while (tempNodeOut.next != null) {
            output += tempNodeOut.data + ", ";
            tempNodeOut = tempNodeOut.next;
        }
        output += tempNodeOut.data + "]";
    }
    return output;
}

}




/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Reads the inputs and displays the outputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        Deque deck = new Deque();

        int numOfinputs = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numOfinputs; i++) {

            String[] command = scan.nextLine().split(" ");

            switch (command[0]) {

            case "pushLeft":
                deck.pushLeft(Integer.parseInt(command[1]));
                System.out.println(deck);
                break;

            case "pushRight":
                deck.pushRight(Integer.parseInt(command[1]));
                System.out.println(deck);
                break;

            case "popLeft":
                if (deck.popLeft() != null) {
                    System.out.println(deck);
                }
                break;

            case "popRight":
                if (deck.popRight() != null) {
                    System.out.println(deck);
                }
                break;

            case "size":
                System.out.println(deck.getSize());
                break;

            default:
                break;

            }
        }
    }
}
