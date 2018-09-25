// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem

import java.util.*;


class Percolation {

	int[][] grid;


	public Percolation(final int n) {

		grid = new int[n][n];
	}


	public void openSite(final int x, final int y) {

		grid[x - 1][y - 1] = 1;
	}

	public void printGrid() {
	  System.out.println(Arrays.deepToString(grid));

	}
}


	// public void open(final int row, final int col) {

	// }

	// public boolean isOpen(final int row, final int col) {

	// }

	// public boolean isFull(final int row, final int col) {

	// }

	// public int numberOfOpenSites() {

	// } m$itc1hl@pa$$w0rd

	// public boolean percolates() {

	// }



public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int noOflines = s.nextInt();
		Percolation obj = new Percolation(noOflines);
		System.out.println("\n");

		// Scanner n = new Scanner(System.in);

		while(s.hasNext()) {
			// System.out.println("input");
			// String[] openingBlock = n.nextLine().split(" ");
			// obj.openSite(Integer.parseInt(openingBlock[0]), Integer.parseInt(openingBlock[1]));
			// int x = s.nextInt();
			// int y = s.nextInt();
			obj.openSite(s.nextInt(), s.nextInt());

		}

		for(int[] eachrow : obj.grid) {

			for(int eachelement : eachrow) {
			System.out.print(eachelement + " ");
			}
			System.out.println("");
		}

	}
}