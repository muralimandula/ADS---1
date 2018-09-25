// public class Percolation {
//    public Percolation(int n)
            // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)
            // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)
            // is site (row, col) open?
//    public boolean isFull(int row, int col)
            // is site (row, col) full?
//    public     int numberOfOpenSites()
            // number of open sites
//    public boolean percolates()
            // does the system percolate?
// }


// You can implement the above API to solve the problem

import java.util.Scanner;


/**
 * Percolation class.
 */
class Percolation {

    /**
     * boolean array, stores true/false.
     */
    private boolean[][] grid;

    /**
     * Size of the grid, rows*columns.
     */
    private int n;

    /**
     * count.
     */
    private int count;

    /**
     * Top size of the grid.
     */
    private int top;

    /**
     * Bottom of the grid.
     */
    private int bottom;
    /**
     * Object for Percolate.
     */
    private PathCompression objPercolate;

/**
 * Constructs the object.
 *
 * @param      gridSize  The grid size
 */
Percolation(final int gridSize) {
    grid = new boolean[gridSize][gridSize];
    count = 0;
    top = 0;
    bottom = gridSize * gridSize + 1;
    objPercolate = new PathCompression(gridSize * gridSize + 2);
    n = gridSize;
  }

 /**
  * Gets the number.
  *
  * @param      row   The row
  * @param      col   The col
  *
  * @return     The number.
  */
 public int getNum(final int row, final int col) {
    return row * n + col + 1;
  }

 /**
  * Turns block site to open site.
  *
  * @param      row   The row
  * @param      col   The col
  */
 public void open(final int row, final int col) {
    if (!(isOpen(row, col))) {
      grid[row][col] = true;
      count += 1;
    }
    if (row == 0) {
      objPercolate.union(getNum(row, col), top);
    }
    if (row == n - 1) {
      objPercolate.union(getNum(row, col), bottom);
    }
    if (col > 0 && isOpen(row, col - 1)) {
      objPercolate.union(getNum(row, col), getNum(row, col - 1));
    }
    if (col < n - 1 && isOpen(row, col + 1)) {
      objPercolate.union(getNum(row, col), getNum(row, col + 1));
    }
    if (row > 0 && isOpen(row - 1, col)) {
      objPercolate.union(getNum(row, col), getNum(row - 1, col));
    }
    if (row < n - 1 && isOpen(row + 1, col)) {
      objPercolate.union(getNum(row, col), getNum(row + 1, col));
    }
    return;
  }

  /**
   * Determines if open.
   *
   * @param      row   The row
   * @param      col   The col
   *
   * @return     True if open, False otherwise.
   */
   public boolean isOpen(final int row, final int col) {
        return grid[row][col];
  }

  /**
   * Finds number of open Sites.
   *
   * @return     count of open sites.
   */
  public int numberOfOpenSites() {
         return count;
  }

  /**
   * Determines if full.
   *
   * @param      row   The row
   * @param      col   The col
   *
   * @return     True if full, False otherwise.
   */
  public boolean isFull(final int row, final int col) {
        return objPercolate.connected(top, (getNum(row, col)));
  }

  /**
   * checks whether percoltes.
   *
   * @return     true/false.
   */
  public boolean percolates() {
        return objPercolate.connected(top, bottom);
  }
}

/**
 * Class for path compression.
 */
class PathCompression {
    /**
     * array id[].
     */
    private int[] id;
    /**
     * size assessed.
     */
    private int[] sz;

    /**
     * Constructs the object.
     *
     * @param      number  The number
     */
    PathCompression(final int number) {
    id = new int[number];
    sz = new int[number];
    for (int i = 0; i < number; i++) {
        id[i] = i;
        sz[i] = 1;
     }
   }

/**
   * Searches for the first match.
   *
   * @param      x     index_value
   *
   * @return     {value replaced
   */
  public int find(final int x) {
    int p = x;
    while (p != id[p]) {
      id[p] = id[id[p]];
      p = id[p];
    }
    return p;
  }

  /**
   * Check whether connected.
   *
   * @param      p     { parameter_description }
   * @param      q     The quarter
   *
   * @return     { description_of_the_return_value }
   */
  public boolean connected(final int p, final int q) {
    return find(p) == find(q);
  }

  /**
   * union method merge.
   *
   * @param      p     { parameter_description }
   * @param      q     The quarter
   */
  public void union(final int p, final int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) {
        return;
    }

    if (sz[i] < sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
    } else {
        id[j] = i;
        sz[i] += sz[j];
        }
    }

}


/**
 * Main class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
    // unused constructor
  }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
    Scanner s = new Scanner(System.in);
    int gridSize = s.nextInt();
    // reading no.of rows and columns of grid
    Percolation obj = new Percolation(gridSize);
    while (s.hasNext()) {
      int p = s.nextInt();
      int q = s.nextInt();
      obj.open(p - 1, q - 1);
    }
    System.out.println(obj.percolates());
  }
}



//##.... Below is my understanding of the testcases....##
// import java.util.*;

// class Percolation {
//  char[][] grid;
//  public Percolation(final int n) {
//      grid = new char[n][n];
//  }
//  public void openSite(final int x, final int y) {
//      grid[x - 1][y - 1] = 'X';
//  }
//  public void printGrid() {
//    System.out.println(Arrays.deepToString(grid));
//  }
// }

// public class Solution {
//  public static void main(String[] args) {
//      Scanner s = new Scanner(System.in);
//      int noOflines = s.nextInt();
//      Percolation obj = new Percolation(noOflines);
//      System.out.println("\n");
//      int i = 0;
//      for(char[] eachrow : obj.grid) {
//          int j = 0;
//          for(char eachelement : eachrow) {
//              obj.grid[i][j] = '-';
//              j++;
//          }
//          i++;
//      }
//      System.out.println("\n");
//      while(s.hasNext()) {
//          obj.openSite(s.nextInt(), s.nextInt());
//      }
//      System.out.println("\n");
//      for(char[] eachrow : obj.grid) {
//          for(char eachelement : eachrow) {
//          System.out.print(eachelement + " ");
//          }
//          System.out.println("");
//      }
//  }
// }
