import java.util.Arrays;

/**
 * Class for Insertion.
 */
public class Insertion {
    /**
     * Constructs the object.
     */
    public Insertion() {

    }
    /**
     * Insertion Sort function for array.
     * Omega(N)
     * Theta(N^2)
     * O(N^2)
     * @param      array  The array
     * @param      size   The size
     */
    public void sort(Comparable[] array, int low, int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * Swaps the values in the array.
     *
     * @param      a     Team array
     * @param      ind1  The ind 1
     * @param      ind2  The ind 2
     */
    public void swap(Comparable[] a, int ind1, int ind2) {
        Comparable temp = a[ind1];
        a[ind1] = a[ind2];
        a[ind2] = temp;
    }
}
