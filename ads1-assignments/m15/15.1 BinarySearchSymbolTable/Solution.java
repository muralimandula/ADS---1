import java.util.Scanner;

/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputString = scan.nextLine().split(" ");

        BinarySearchTree<String, Integer> bst = new
                            BinarySearchTree<String, Integer>();

                //String and Integer represents key and value.

        for (int i = 0; i < inputString.length; i++) {
            bst.put(inputString[i], i);
            // adding (key, index) pair to bst object.
        }
        while (scan.hasNext()) {
            String[] command = scan.nextLine().split(" ");

            switch (command[0]) {

            case "max":
                System.out.println(bst.getMax());
                break;

            case "floor":
                System.out.println(bst.getFloor(command[1]));
                break;

            case "rank":
                System.out.println(bst.getRank(command[1]));
                break;

            case "deleteMin":
                        bst.deleteMin();
                break;

            case "contains":
                System.out.println(bst.contains(command[1]));
                break;

            case "keys":
                System.out.println(bst.toString());
                break;

            case "get":
                System.out.println(bst.get(command[1]));
                break;

            default:
                break;
            }
        }
    }
}
