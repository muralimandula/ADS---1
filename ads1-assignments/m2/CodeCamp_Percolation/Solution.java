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


    private boolean[][] grid;
    private int n;
    private int count;
    private int top;
    private int bottom;
    private WeightedUnion percCheck;

Percolation(final int num) {
    grid = new boolean[num][num];
    count = 0;
    top = 0;
    bottom = num * num + 1;
    percCheck = new WeightedUnion(num * num + 2);
    n = num;
  }

 public int getNum(final int row, final int col) {
    return row * n + col + 1;
  }


 public void open(final int row, final int col) {
    if (!(isOpen(row, col))) {
      grid[row][col] = true;
      count += 1;
    }
    if (row == 0) {
      percCheck.union(getNum(row, col), top);
    }
    if (row == n - 1) {
      percCheck.union(getNum(row, col), bottom);
    }
    if (col > 0 && isOpen(row, col - 1)) {
      percCheck.union(getNum(row, col), getNum(row, col - 1));
    }
    if (col < n - 1 && isOpen(row, col + 1)) {
      percCheck.union(getNum(row, col), getNum(row, col + 1));
    }
    if (row > 0 && isOpen(row - 1, col)) {
      percCheck.union(getNum(row, col), getNum(row - 1, col));
    }
    if (row < n - 1 && isOpen(row + 1, col)) {
      percCheck.union(getNum(row, col), getNum(row + 1, col));
    }
    return;
  }

   public boolean isOpen(final int row, final int col) {
        return grid[row][col];
  }

  public int numberOfOpenSites() {
         return count;
  }

  public boolean isFull(final int row, final int col) {
        return percCheck.connected(top, (getNum(row, col)));
  }

  public boolean percolates() {
        return percCheck.connected(top, bottom);
  }
}

class WeightedUnion {

    private int[] id;
    private int[] sz;

    WeightedUnion(int number) {
    id = new int[number];
    sz = new int[number];
    for (int i = 0; i < number; i++) {
        id[i] = i;
        sz[i] = 1;
     }
   }

  public int find(int p) {
    while (p != id[p]) {
      id[p] = id[id[p]];
      p = id[p];
    }
    return p;
  }

  public boolean connected(final int p, final int q) {
    return find(p) == find(q);
  }

  public void union(final int p, final int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) return;

    if (sz[i] < sz[j]) {
        id[i] = j; sz[j] += sz[i];
    } else {
        id[j] = i; sz[i] += sz[j]; }
    }
}



public final class Solution {


    private Solution() {
    // unused constructor
  }

    public static void main(final String[] args) {
    Scanner s = new Scanner(System.in);
    int gridSize = s.nextInt();
    // reading no.of rows and columns of grid
    Percolation obj = new Percolation(gridSize);
    while (s.hasNext()) {
      int p = s.nextInt();
      int q = s.nextInt();
      obj.open(p, q);
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