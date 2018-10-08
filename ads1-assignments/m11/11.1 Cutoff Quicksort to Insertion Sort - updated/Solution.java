import java.util.Scanner;
import java.util.Arrays;

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
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            QuickSort quick = new QuickSort();
            int cutoff = Integer.parseInt(scan.nextLine());
            // taking cutoff value.
            String line = scan.nextLine();
            //elelements to be sorted.
            if (line.length() > 0) {
                String[] array = line.split(" ");
                quick.sort(array, cutoff);
                System.out.println(Arrays.toString(array));
            } else {
                System.out.println("[]");
            }
        }
    }
}
