import java.util.Comparator;
/**
 * Class for MaxPQ.
 *
 * @param      <Key>  The key
 */
public class MaxPQ<Key> {
    private Key[] pq;
        // store items at indices 1 to n
    private int n;
        // number of items on priority queue
    private Comparator<Key> comparator;
        // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MaxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns number of keys on this queue.
     *
     * @return the number of keys
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this queue.
     *
     * @return key
     */
    public Key max() {
        return pq[1];
    }


    /**
     * Resizes the arrays with given capacity.
     * Complexity N.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
            //resizing
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
            //inserting into newly resized queue.
        }
        pq = temp; //now, re assigning with new capacity.
    }


    /**
     * Inserting an element into queue.
     *
     * @param  key the new key
     */
    public void insert(Key key) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = key;
        swim(n);
    }

    /**
     * Removes and return the max key.
     *
     * @return a Maxkey on queue
     */
    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return max;
    }

    /**
    * Swim function on priority queue.
    *
    * TIme Complexity : log(N).
    * @param      key     passing key.
    */
    private void swim(int key) {
        while (key > 1 && less(key / 2, key)) {
            exch(key, key / 2);
            key = key / 2;
        }
    }
    /**
     * Sink function on priority queue.
     *
     * TIme Complexity  : log(N)
     *
     * @param      key     { parameter_description }
     */
    private void sink(int key) {
        while (2 * key <= n) {
            int j = 2 * key;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(key, j)) {
                break;
            }
            exch(key, j);
            key = j;
        }
    }


    /**
     * Less than function.
     *
     * @param      key1
     * @param      key2
     *
     * @return     True/False
     */
    private boolean less(final int key1, final int key2) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[key1]).compareTo(pq[key2]) < 0;
        } else {
            return comparator.compare(pq[key1], pq[key2]) < 0;
        }
    }


    /**
     * Swaps the values in the array.
     *
     * @param      key1     { parameter_description }
     * @param      key2  { parameter_description }
     */
    private void exch(final int key1, final int key2) {
        Key swap = pq[key1];
        pq[key1] = pq[key2];
        pq[key2] = swap;
    }
}