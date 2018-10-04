import java.util.*;


class LinkedList<Generic> implements Iterable<Generic> {

	Node head; //creating first/ead element.

							private class Node {

								private Generic data;
								private Node next;

								Node (Generic dataCreate, Node nextCreate) {
									this.data = dataCreate;
									this.next = nextCreate;
								}

							}


	public void insertAt(int index, Generic element) {
		// inserting at a position/index
		head = insertHelper(head, index, element);
		}

	public Node insertHelper(final Node head, final int position,
								 final Generic element) {

		if(position == 0) {
			return new Node(element, head);
				// for the first time, head is null.
				// Thereafter, head is previous head.data.
			}
			head.next = insertHelper(head.next,  position - 1, element);
			// System.out.println(head.data);
			return head;
		}

	public void reverseOf() {
			head = reverseHelper(head);
		}

	public Node reverseHelper(Node head) {
			if (head == null || head.next == null) return head;
			Node nhead = reverseHelper(head.next);
			head.next.next = head;
			head.next = null;
			return nhead;
		}

	public Iterator iterator() {
			return new MyIterator(head);
		}

	private class MyIterator implements Iterator {

			Node current;

			public MyIterator(Node first) {
				current = first;
			}

			public boolean hasNext() {
				return current !=  null;
			}

			public void remove() {

			}

			public Generic next() {
				Generic data = current.data;
				current = current.next;
				return data;
			}
	}


}


class Solution {

	public static void main(final String[] args) {

		Scanner scan = new Scanner(System.in);
		LinkedList<Integer> lList = new LinkedList<>();
		while (scan.hasNext()) {

		String string = "";


			String[] input = scan.nextLine().split(" ");

			switch (input[0]) {

			case "insertAt" :
				lList.insertAt(Integer.parseInt(input[1]),
											 Integer.parseInt(input[2]));

				for (Integer element : lList) {
					string += element + ", ";
				}
				System.out.println(string.substring(0, string.length() - 2));
				break;


			case "reverse" :
				lList.reverseOf();
				for (Integer element : lList) {
					string += element + ", ";
				}
				System.out.println(string.substring(0, string.length() - 2));
				break;
			}
		}

	}
}
