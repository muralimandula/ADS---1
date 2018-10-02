import java.util.Scanner;





class Deque<Generic> {

private class Node {

    Generic data;
    Node next;

    Node() {

    }

    Node(Generic data) {
        this.data = data;
    }

    Node(Generic data, Node node) {
        this.data = data;
        this.next = node;
    }
}


    Deque() {

    }

    Node head, tail; // values are null when created.

    int size;   //No value assigned when created.

    public void pushLeft(Generic data) {

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

public void pushRight(Generic data) {

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
        // now tempNode is last but one in the queue.
        tail = tempNode; // now tail is last but one.
        size--;
        return tempNode.next.data;
    }
}

public int getSize() {
    return size;
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
