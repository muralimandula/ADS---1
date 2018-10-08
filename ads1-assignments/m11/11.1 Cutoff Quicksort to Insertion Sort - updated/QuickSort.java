import java.util.Arrays;

/**
 * Class for quick sort.
 */
public class QuickSort {

    /**
     * Constructs the object.
     */
    QuickSort() {

    }
    /**
     * Partitioning of elements.
     *
     * @param      a     { comparable array }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { int }
     */
    public int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i].compareTo(a[lo]) < 0) {
                if (i >= hi) {
                    break;
                }
            }
            while (a[lo].compareTo(a[--j]) < 0) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, j, i);
        }
        swap(a, lo, j);
        System.out.println(Arrays.toString(a));
        return j;
    }

    /**
     * sorting - quick.
     *
     * @param      a       { array to sort }
     * @param      cutoff  The cutoff
     */
    public void sort(Comparable[] a, int cutoff) {
        int lo = 0;
        int hi = a.length - 1;
        if(a!=null) {
            sort(a, lo, hi, cutoff);
        } else {
            return;
        }
    }

    /**
     * sorting, Insertion if under cutOff
     *
     * @param      arr   The arr
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      cut   The cut
     */
    public void sort(Comparable[] arr, int lo, int hi, int cut) {
        // if (hi <= lo) {
        //     return;
        // }
        if (hi <= lo + cut - 1) {
            Insertion ins = new Insertion();
            ins.sort(arr, lo, hi);
            return;
        }
        int mid = partition(arr, lo, hi);
        sort(arr, lo, mid - 1, cut);
        sort(arr, mid + 1, hi, cut);
    }

    /**
     * swapping to sort.
     *
     * @param      a     { array to comprare }
     * @param      i1    I 1
     * @param      i2    I 2
     */
    public void swap(Comparable[] a, int i1, int i2) {
        Comparable temp = a[i2];
        a[i2] = a[i1];
        a[i1] = temp;
    }
}
