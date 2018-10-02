import java.util.Scanner;




class JosephProblem {

    int size;
    int eliminationCount;
    Node head, tail;
    String output = "";

    /**
     * Constructs the object.
     *
     * @param      gameSize       The game size
     * @param      eliminationOn  The elimination on
     */
    JosephProblem(int gameSize, int eliminationOn) {
        size = gameSize;
        eliminationCount = eliminationOn;
    }

    /**
     * Class for Node.
     */
    private class Node {
        int data;
        Node next;


        /**
         * Constructs the object.
         *
         * @param      position  The position
         */
        Node(int position) {
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
public class Solution {

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

            JosephProblem problem = new JosephProblem(Integer.parseInt(josephSays[0]),
                Integer.parseInt(josephSays[1]));
            problem.getResult();
        }
    }
}
