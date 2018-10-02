import java.util.Scanner;



/**
 * Class for joseph problem.
 */
class JosephProblem {

    /**
     * Size of the persons, n.
     */
    private int size;
    /**
     * Elimination postion, m.
     */
    private int eliminationCount;
    /**
     * Head and tail as they are in circle.
     */
    private Node head, tail;
    /**
     * string format of the reulst.
     */
    private String output = "";

    /**
     * Constructs the object.
     *
     * @param      gameSize       The game size
     * @param      eliminationOn  The elimination on
     */
    JosephProblem(final int gameSize, final int eliminationOn) {
        this.size = gameSize;
        this.eliminationCount = eliminationOn;
    }

    /**
     * Class for Node.
     */
    private class Node {

        /**
         * position value.
         */
        private int data;

        /**
         * Next position.
         */
        private Node next;


        /**
         * Constructs the object.
         *
         * @param      position  The position
         */
        Node(final int position) {
            data = position;
        }
    }




    /**
     * FInds the solution to Josephs problem.
     */
    public void getResult() {

        Node newNode = new Node(0); //Zeroth position.
        head = newNode;
        tail = newNode;
        for (int i = 1; i < size; i++) {
                                // creatig n nodes/positions.
            Node nextPosition = new Node(i);
            tail.next = nextPosition;
            tail = nextPosition;
        }


        int count;
        Node temp;
        while (size != 1) {

            for (count = 1; count < eliminationCount; count++) {
                //moving towards right, till reaching elimination postion.
                temp = head;
                head = head.next;
                tail.next = temp;
                tail = temp;
            }

            output += head.data + " "; //taking it on reaching.
            head = head.next; //moving to next, for next elimination point.
            count = 1;
            size--;
        }
        output += head.data;
        System.out.println(output);
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
     * Mian Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int noOfInputs = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < noOfInputs; i++) {

            String[] josephSays = scan.nextLine().split(" ");

            JosephProblem problem = new JosephProblem(
                            Integer.parseInt(josephSays[0]),
                                Integer.parseInt(josephSays[1]));
            problem.getResult();
        }
    }
}
