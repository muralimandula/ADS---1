import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //Constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);

        MergeImprovements mergeImp = new MergeImprovements();

        while (scan.hasNextLine()) {

            String[] elements = scan.nextLine().split(",");

            mergeImp.sort(elements);

            String improvedMerge = "[";
            int i;
            for (i = 0; i < elements.length - 1; i++) {
                improvedMerge += elements[i] + ", ";
            }
            improvedMerge += elements[i] + "]";
            System.out.println(improvedMerge);
            System.out.println();
        }
    }
}
