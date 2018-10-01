import java.util.Iterator;
import java.util.Scanner;


class Steque <Generic> {
	private class Node {
		Generic data;
		Node next;


		Node(Generic data, Node next) {

			this.data = data;
			this.next = next;
		}
	}

	private Node head, tail;

	public void push(Generic data) {

		Node node = new Node(data, head);

		if (head == null) {
			head = node;
			tail = node;
			// return;
		} else {
		head = node;
		}
	}

	public Generic pop() throws Exception {
		if (head == null) throw new Exception("Stack is Empty");
		Generic data = head.data;
		head = head.next;
		return data;
	}

	public void enqueue(Generic data) {
		if (head == null) {
			push(data);
			return;
		}
		tail.next = new Node(data, null);
		tail = tail.next;
	}

	public String convertString() throws Exception {
		if (head == null) throw new Exception("Stack is Empty");
		String str = "";


		for (Iterator i = this.iterate(); i.hasNext(); str += i.next() + ", ");
		return str.substring(0, str.length() - 2);
	}

	public Iterator  iterate() {
		return new StIterator(head);
	}

	private class StIterator implements Iterator {
		private Node current;

		StIterator(Node node) {
			current = node;
		}

		public boolean hasNext() {
			return current != null;
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



public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());

		Steque steque = new Steque();

		while (scan.hasNext()) {

			switch(scan.nextLine()) {

				case "push":

				steque.push(Integer.parseInt(scan.nextLine()));
				break;

				case "pop":
                    try {
					steque.pop();
                        System.out.println(steque);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                       }

				break;

				case "enqueue":
				steque.enqueue(Integer.parseInt(scan.nextLine()));
				break;

				default:

				break;
			}

		}
	}
}