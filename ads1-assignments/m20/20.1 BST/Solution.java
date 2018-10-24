import java.util.Scanner;
/**
 * solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (scan.hasNextLine()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {

            case "put":
                bst.put(new BookDetails(tokens[1], tokens[2],
                                 Double.parseDouble(tokens[2 + 1])),
                        Integer.parseInt(tokens[2 + 2]));
                break;

            case "get":
                System.out.println(bst.get(new BookDetails(tokens[1],
                        tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;

            case "max":
                System.out.println(bst.max());
                break;

            case "min":
                System.out.println(bst.min());
                break;

            case "floor":
                System.out.println(bst.floor(new BookDetails(tokens[1],
                        tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;

            case "ceiling":
                System.out.println(bst.ceiling(new BookDetails(tokens[1],
                          tokens[2], Double.parseDouble(tokens[2 + 1]))));
                break;

            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;

            case "deleteMax":
                bst.deleteMax();
                break;

            case "deleteMin":
                bst.deleteMin();
                break;

            case "delete":
                bst.delete(new BookDetails(tokens[1],
                         tokens[2], Double.parseDouble(tokens[2 + 1])));
                break;

            default:
                break;
            }
        }
    }
}