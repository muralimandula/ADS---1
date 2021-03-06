import java.util.Scanner;



/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Magic number.
     */
    private static final int THOUSAND = 1000;

    /**
     * Magic Number.
     */
    private static final int FIFTEENH = 1500;

    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }

    /**
     * Main Method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 1; i <= THOUSAND; i++) {
            pq.insert(new CubeSum(i, i));
        }
        CubeSum prev = new CubeSum(0, 0);
        int sum = 0;
        int p = 1;
        int k = 0;
        while (!pq.isEmpty()) {
            CubeSum c = pq.delMin();
            if (prev.sum() == c.sum()) {
                p++;
                if (p == m) {
                    sum = c.sum();

                    if (++k == n) {
                        break;
                    }
                }
            } else {
                p = 1;
            }
            prev = c;
            if (c.j < FIFTEENH) {
                pq.insert(new CubeSum(c.i, c.j + 1));
            }

        }
        System.out.println(sum);

    }
}
