import java.util.Arrays;
/**
 * Class for binary st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public final class BinarySearchTree<Key extends Comparable<Key>, Value> {

    //       class ---------------<String extends Comparable , Integer> {
    /**
     * Stores the keys.
     */
    private Key[] keys;
    /**
     * Stores the keys.
     */
    private Value[] values;
    /**
     * Size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    public BinarySearchTree() {
        keys = (Key[]) new Comparable[2];
        values = (Value[]) new Object[2];
        size = 0;
    }


    /**
     * Adds the key, value pair.
     * Time Complexity : N
     * @param      k
     * @param      v
     */
    public void put(final Key k, final Value v) {
        if (v == null) {
            delete(k);
            return;
        }

        int i = getRank(k);
        if ((i < size) && (keys[i].compareTo(k) == 0)) {
            values[i] = v;
            return;
        }
        for (int j = size; j > i; j--)  {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;   //inserting key.
        values[i] = v; //inserting value.
        size++;        // increasing size.
        if (size == keys.length) {
            resize(2 * size);
        }
    }


    /**
     * Resizes the array.
     *
     * @param      newSize   The newSize
     */
    private void resize(final int newSize) {
        keys = Arrays.copyOf(keys, newSize);
                    //newSized array with all previous keys.
        values = Arrays.copyOf(values, newSize);
                //newSized array with all previous values.
    }

    /**
     * Find rank of the key.
     * Time Complexity :log(N).
     * @param      key   The key
     *
     * @return     rank
     */
    public int getRank(final Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp > 0) {
                lo = mid + 1;
            } else if (comp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * Gets the value.
     *
     * @param      key     Key.
     *
     * @return     Value.
     */
    public Value get(final Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = getRank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the key is in the given array.
     *
     * @param      key     key
     *
     * @return     true/false
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }


    /**
     * Finds the floor of the entered key.
     *
     * @param      key
     *
     * @return     floor of key.
     */
    public Key getFloor(final Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = getRank(key);
        if (i == 0) {
            return null;
        }
        if (i < size && keys[i].compareTo(key) == 0) {
            return keys[i];
        }
        return keys[i - 1];
    }

    /**
     * Deletes a given key.
     * Complexity N
     * @param      keyToDelete  The keyToDelete
     */
    public void delete(final Key keyToDelete) {
        final int four = 4;
        if (isEmpty()) {
            return;
        }
        int keyRank = getRank(keyToDelete);
        if (keyRank < size && keys[keyRank].compareTo(keyToDelete) != 0) {
            return;
        }
        for (int j = keyRank; j < size - 1; j++)  {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        size--;
        keys[size] = null;
        values[size] = null;
        if (size > 0 && size == keys.length / four) {
            resize(keys.length / 2);
        }
    }
    /**
     * deletes the minimum value.
     */
    public void deleteMin() {

        if (!(isEmpty())) {
            delete(keys[0]); //since sorted.
        }
    }

    /**
     * Returns a string representation of the object.
     * Complexity N.
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                s += keys[i] + " " + values[i] + "\n";
            }
            return s.substring(0, s.length() - 1);
        }
        return s;
    }
    /**
     * Gets the maximum.
     *
     * @return     The maximum.
     */
    public Key getMax() {
        return keys[size - 1];
    }
}
