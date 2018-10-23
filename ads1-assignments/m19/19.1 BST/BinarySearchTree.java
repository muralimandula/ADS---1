import java.util.NoSuchElementException;
/**
 * Class for book.
 */
class BookDetails {
	/**
	 * name.
	 */
	private String name;
	/**
	 * author.
	 */
	private String author;
	/**
	 * price.
	 */
	private Double price;

	/**
	 * Constructs the object.
	 *
	 * @param      nameOfbook  The name ofbook
	 * @param      bookAuthor  The book author
	 * @param      bookPrice   The book price
	 */
	BookDetails(final String nameOfbook,
		 final String bookAuthor, final Double bookPrice) {
		this.name = nameOfbook;
		this.author = bookAuthor;
		this.price = bookPrice;
	}
	/**
	 * get name.
	 *
	 * @return     Gets the name.
	 */
	String getname() {
		return this.name;
	}
	/**
	 * get author.
	 *
	 * @return     Gets the author name.
	 */
	String getauthor() {
		return this.author;
	}
	/**
	 * get price.
	 *
	 * @return     Gets the price.
	 */
	Double getprice() {
		return this.price;
	}
	/**
	 * compare.
	 *
	 * @param      that  The that book.
	 *
	 * @return     Integer value.
	 */
	int compareTo(final BookDetails that) {
		if (this.name.compareTo(that.name) > 0) {
			return 1;
		} else if (this.name.compareTo(that.name) < 0) {
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
		String s = "";
		s = name + ", " + author + ", " + price;
		return s;
	}
}
/**
 * Class for binary search tree.
 */
public class BinarySearchTree {
	/**
	 * Class for node.
	 */
	class Node {
		/**
		 * key.
		 */
		private BookDetails key;
		/**
		 * value.
		 */
		private Integer value;
		/**
		 * left.
		 */
		private Node left;
		/**
		 * right.
		 */
		private Node right;
		/**
		 * size.
		 */
		private int size;
		/**
		 * Constructs the object.
		 *
		 * @param      k     key.
		 * @param      v     value.
		 */
		Node(final BookDetails k, final Integer v, final int size) {
			this.key = k;
			this.value = v;
			this.left = null;
			this.right = null;
			this.size = size;
		}
	}

	/**
	 * root.
	 */
	private Node root;
	/**
	 * Constructs the object.
	 */
	BinarySearchTree() {
		root = null;
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * size of tree.
	 *
	 * @return     Size of the tree.
	 */
	public int size() {
		return size(root);
	}
	/**
	 * size of subtree.
	 *
	 * @param      x     node.
	 *
	 * @return     integer value.
	 */
	private int size(Node x) {
		if (x == null) return 0;
		else return x.size;
	}
	/**
	 * put.
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	public void put(final BookDetails key, final Integer value) {
		root = put(root, key, value);
	}
	/**
	 * put.
	 *
	 * @param      x      Node.
	 * @param      key    The key
	 * @param      value  The value
	 *
	 * @return     The node.
	 */
	private Node put(final Node x, final BookDetails key, final Integer value) {
		if (x == null) {
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}
	/**
	 * get.
	 *
	 * @param      key   The key
	 *
	 * @return     Gets the value.
	 */
	public Integer get(final BookDetails key) {
		return get(root, key);
	}
	/**
	 * get.
	 *
	 * @param      x     Node.
	 * @param      key   The key
	 *
	 * @return     Gets the value.
	 */
	private Integer get(final Node x, final BookDetails key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			return get(x.left, key);
		} else if (cmp > 0) {
			return get(x.right, key);
		}
		return x.value;
	}
	/**
	 * min value.
	 *
	 * @return     Book object.
	 */
	public BookDetails min() {
		if (isEmpty()) {
			throw new NoSuchElementException("calls min() with empty symbol table");
		}
		return min(root).key;
	}
	/**
	 * min value.
	 *
	 * @param      x     Node.
	 *
	 * @return     The node.
	 */
	private Node min(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}

	/**
	 * max value.
	 *
	 * @return     Book object.
	 */
	public BookDetails max() {
		if (isEmpty()) {
			throw new NoSuchElementException("calls max() with empty symbol table");
		}
		return max(root).key;
	}
	/**
	 * max value.
	 *
	 * @param      x     Node.
	 *
	 * @return     The node.
	 */
	private Node max(Node x) {
		if (x.right == null) {
			return x;
		} else {
			return max(x.right);
		}
	}
	/**
	 * floor.
	 *
	 * @param      key   The key
	 *
	 * @return     The book object.
	 */
	public BookDetails floor(BookDetails key) {
		if (key == null) throw new IllegalArgumentException("argument to floor() is null");
		if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
		Node x = floor(root, key);
		if (x == null) return null;
		else return x.key;
	}
	/**
	 * floor.
	 *
	 * @param      x     The node.
	 * @param      key   The key
	 *
	 * @return     The node.
	 */
	private Node floor(Node x, BookDetails key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp <  0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if (t != null) return t;
		else return x;
	}
	/**
	 * ceiling.
	 *
	 * @param      key   The key
	 *
	 * @return     The book object.
	 */
	public BookDetails ceiling(BookDetails key) {
		if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
		if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
		Node x = ceiling(root, key);
		if (x == null) return null;
		else return x.key;
	}
	/**
	 * ceiling.
	 *
	 * @param      x     The node.
	 * @param      key   The key
	 *
	 * @return     The node.
	 */
	private Node ceiling(Node x, BookDetails key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) {
			Node t = ceiling(x.left, key);
			if (t != null) return t;
			else return x;
		}
		return ceiling(x.right, key);
	}
	/**
	 * select.
	 *
	 * @param      k
	 *
	 * @return     The book object.
	 */
	public BookDetails select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("argument to select() is invalid: " + k);
		}
		Node x = select(root, k);
		return x.key;
	}
	/**
	 * Return key of rank k.
	 *
	 * @param      x     The node.
	 * @param      k
	 *
	 * @return     The node.
	 */
	private Node select(Node x, int k) {
		if (x == null) return null;
		int t = size(x.left);
		if      (t > k) return select(x.left,  k);
		else if (t < k) return select(x.right, k - t - 1);
		else            return x;
	}
	/**
	 * rank.
	 *
	 * @param      key   The key
	 *
	 * @return     The integer.
	 */
	public int rank(BookDetails key) {
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");
		return rank(key, root);
	}
	/**
	 * Number of keys in the subtree less than key.
	 *
	 * @param      key   The key
	 * @param      x     { parameter_description }
	 *
	 * @return     The integer.
	 */
	private int rank(BookDetails key, Node x) {
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return rank(key, x.left);
		else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
		else              return size(x.left);
	}
}
