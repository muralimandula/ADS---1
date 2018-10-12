import java.util.*;

/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {

	/**
	 * For summation.
	 */
	int sum;

	/**
	 * ith cube.
	 */
	int i;

	/**
	 * jth cube.
	 */
	int j;

	/**
	 * Calcullating CubeSum.
	 *
	 * @param      ith   The ith
	 * @param      jth   The jth
	 */
	CubeSum(int ith, int jth) {
		this.sum = ith * ith * ith + jth * jth * jth;
		this.i = ith;
		this.j = jth;
	}

	/**
	 * comparing sum.
	 *
	 * @param      that  The that
	 *
	 * @return     int
	 */
	public int compareTo(CubeSum that) {
		if (this.sum < that.sum) return -1;
		if (this.sum > that.sum) return +1;
		return 0;
	}

	/**
	 * to get sum.
	 *
	 * @return     { int }
	 */
	public int sum() {
		return sum;
	}

	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return sum + " = " + i + "^3" + " + " + j + "^3";
	}

}

/**
 * Class for solution.
 */
class Solution {

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
		for (int i = 1; i <= 1000; i++) {
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

					if (++k == n) break;
				}
			} else {
				p = 1;
			}
			prev = c;
			if (c.j < 1500)
				pq.insert(new CubeSum(c.i, c.j + 1));

		}
		System.out.println(sum);

	}
}