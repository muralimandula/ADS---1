import java.util.Scanner;

/**
 * Class for team object.
 * We use comparable interface to implement sort algortihms.
 */
class Stock implements Comparable<Stock> {

    /**
     * Stock name.
     */
    private String stockName;

    /**
     * Stock rate.
     */
    private double stockRate;


    /**
     * Constructs the object.
     *
     * @param      nameOftheStock    The name ofthe stock
     * @param      currentstockRate  The currentstock rate
     */
    Stock(final String nameOftheStock, final double currentstockRate) {
        this.stockName = nameOftheStock;
        this.stockRate = currentstockRate;
    }

    /**
     * Compares two objects of this class.
     * Complexity Analysis: O(1).
     *
     * @param      other  The other
     *
     * @return     1 if greater
     *             0 if equal.
     *             -1 if lesser.
     */
    public int compareTo(final Stock other) {
        if (this.stockRate > other.stockRate) {
            return 1;
        }
        if (this.stockRate < other.stockRate) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return stockName +  " " + stockRate;
    }
}



/**
 * Class for insertion sort of applications.
 */
final class SortingStock {

    /**
     * Constructs the object.
     */
    private SortingStock() {
        //dummy constructor.
    }
    /**
     * To check if the object is greater.
     *
     * @param      a     team 1
     * @param      b     team 2
     *
     * @return     returns true if team 1 is greater than
     * team 2 on the leader board.
     */
    static boolean more(final Comparable a, final Comparable b) {
        return a.compareTo(b) > 0;
    }

    /**
     * Swaps 2 objects in the array of objects.
     *
     * @param      a     Array of objects.
     * @param      i     Object 1.
     * @param      j     Object 2.
     */
    static void swap(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Sorts the array of objects using Insertion Sort.
     *
     * Best Case: N-1 compares and 0 exchanges.
     * Average Case: (N^2)/4 compares and (N^2)/4 exchanges.
     * Worst Case: (N^2)/2 compares and (N^2)/2 exchanges.
     *
     * @param      stock   The array of apllications.
     * @param      size  The number of objects in the array.
     */
    static void sort(final Comparable[] stock, final int size) {

        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {

                if (more(stock[j], stock[j - 1])) {
                    swap(stock, j, j - 1);   // Swapping team positions.
                }
            }
        }
    }
}


/**
 * Class for Solution.
 */
public final class Solution {

    static int FIVE = 5;

    static int SIX = 6;
    /**
     * Constructs the object.
     */
    private Solution() {
        // unused constructor
    }

    /**
     * sorting stock.
     *
     * @param      stockInfo  The stock information
     * @param      size       The size
     */
    public static void sortedStock(final Stock[] stockInfo, final int size) {

        SortingStock.sort(stockInfo, size);
        for (int i = 0; i < FIVE; i++) {
            System.out.println(stockInfo[i]);
        }

        System.out.println("");

        for (int j = size - 1; j > size - SIX; j--) {
            System.out.println(stockInfo[j]);
        }
    }

    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {


        int lines = 0;

        Scanner scan = new Scanner(System.in);

        int noOfStocks = Integer.parseInt(scan.nextLine());


        while (lines < SIX) {

            int size = 0;
            Stock[] stockArray = new Stock[noOfStocks];
            for (int i = 0; i < noOfStocks; i++) {
                String[] stockDetails = scan.nextLine().split(",");
                Stock stockObj = new Stock(stockDetails[0],
                             Double.parseDouble(stockDetails[1]));
                stockArray[size] = stockObj;
                size += 1;
            }
            sortedStock(stockArray, noOfStocks);
            lines += 1;
            if (lines != SIX) {
                System.out.println("");

            }


        }
    }
}
