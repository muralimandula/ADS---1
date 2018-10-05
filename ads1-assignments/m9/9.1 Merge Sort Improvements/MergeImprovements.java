import java.util.Scanner;

/**
 * Class for merge.
 */
class MergeImprovements {
    /**
     * insertion point.
     */
    private final int pointSeven = 7;
    /**
     * Constructs the object.
     */
    MergeImprovements() {
        //Unused Constructor.
    }



    /**
     * {Method for sorting}.
     * @param      array  The array
     * @param      aux    The auxiliary array
     * @param      lo     The lower value
     * @param      hi     The higher value
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int lo, final int hi) {

        if (hi <= lo + pointSeven) {

            insertionSort(aux, lo, hi);
            System.out.println("Insertion sort method invoked...");
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(aux, array, lo, mid); //recursion
        sort(aux, array, mid + 1, hi);

        if (array[mid + 1].compareTo(array[mid]) > 0) {

           for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        //Done with sorting all the array.
        // call to merge.
        merge(array, aux, lo, mid, hi);
    }
    /**
     * {Method to merge two arrays}.
     * N iterations through the method, Time complexity : O(N).
     *
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      lo     The lower value
     * @param      mid    The middle value
     * @param      hi     The higher value
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int lo, final int mid, final int hi) {
        // assert isSorted(array, lo, mid);
        // assert isSorted(array, mid + 1, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > hi) {
                aux[k] = array[i++];
            } else if (array[j].compareTo(array[i]) < 0) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        // assert isSorted(aux, lo, hi);
    }


    /**
     *Takes from main as array, and sends to another sort() with parameters.
     *
     * Time complexity :  O(N).
     * @param      a     {Comparable array}.
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        // assert isSorted(a);
    }
    /**
     *
     * sort from a[lo] to a[hi].
     *
     * Time complexity : O((N^2)/2).
     *
     * @param      a     {Comparable array}.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public void insertionSort(final Comparable[] a,
                final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    swap(a, j, j - 1);
                }
            }
        }
    }
    /**
     * Swapping elelemts.
     *
     * Time complexity : O(1).
     *
     * @param      a     {Array of object}
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void swap(final Comparable[] a,
                     final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /**
     * TO check whether sorted.
     *
     * Time complexity : O(1).
     *
     * @param      a     {Comparable array}
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    /**
     * Method to determine if the array is sorted (or) not.
     * Time complexity of this method is O(N).
     * @param      a     {Comparable array}
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}