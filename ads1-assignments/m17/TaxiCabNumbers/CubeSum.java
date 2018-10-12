/**
 * Class for cube sum.
 */
public class CubeSum implements Comparable<CubeSum> {

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