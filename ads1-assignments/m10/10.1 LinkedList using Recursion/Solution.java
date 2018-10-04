import java.util.*;

/**
 * LinkedList implementing Iterator.
 *
 * @param      <Generic>  The generic type.
 */
class LinkedList<Generic> implements Iterable<Generic> {

  /**
   * Node head, initialised.
   */
  Node head; //creating first/ead element.

              /**
               * Class for node.
               */
              private class Node {

                /**
                 * data/value/element of the node.
                 */
                private Generic data;

                /**
                 * Next part or address part of node.
                 */
                private Node next;

                Node (Generic dataCreate, Node nextCreate) {
                  this.data = dataCreate;
                  this.next = nextCreate;
                }

              }

  /**
   * Insert method calling with index and element.
   *
   * @param      index    The index
   * @param      element  The element
   */
  public void insertAt(int index, Generic element) {
    // inserting at a position/index
    head = insertHelper(head, index, element);
    }


  /**
   * Inserting node/element into the linkedList.
   *
   * Time COmplexity : O(N).
   *
   * @param      head      The head
   * @param      position  The position
   * @param      element   The element
   *
   * @return     { description_of_the_return_value }
   */
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

  /**
   * Reverse called for LinkedList.
   */
  public void reverseOf() {
      head = reverseHelper(head);
    }

  /**
   * reversal of the LinkedList, Recursive.
   *
   * Time COmplexity : O(N).
   *
   * @param      head  The head
   *
   * @return     Node/element.
   */
  public Node reverseHelper(Node head) {
      if (head == null || head.next == null) return head;
      Node nhead = reverseHelper(head.next);
      head.next.next = head;
      head.next = null;
      return nhead;
    }

    /**
     * iterator form Iterator class.
     *
     * @return     Iterator object.
     */
  public Iterator iterator() {
      return new MyIterator(head);
    }


  /**
   * Class for my iterator.
   */
  private class MyIterator implements Iterator {
      /**
       * Current initialised.
       */
      Node current;

      /**
       * Constructs the object.
       * taking node as current.
       *
       * @param      first  The first
       */
      public MyIterator(Node first) {
        current = first;
      }

      /**
       * Determines if it has next.
       *
       * @return     True if has next, False otherwise.
       */
      public boolean hasNext() {
        return current !=  null;
      }

      /**
       * method of Iterator.
       */
      public void remove() {
                //unused.
      }

      /**
       * next() - gives next element.
       *
       * @return     value of node.
       */
      public Generic next() {
        Generic data = current.data;
        current = current.next;
        return data;
      }
  }


}

/**
 * Class for solution.
 */
class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {
    //unused construcotr.
  }

  /**
   * Main Function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    LinkedList<Integer> lList = new LinkedList<>();
    while (scan.hasNext()) {

    String string = "";


      String[] input = scan.nextLine().split(" ");

      switch (input[0]) {

      case "insertAt" :

        try {
          lList.insertAt(Integer.parseInt(input[1]),
                       Integer.parseInt(input[2]));
          for (Integer element : lList) {
            string += element + ", ";
          }
          System.out.println(string.substring(0, string.length() - 2));
        } catch (Exception e) {
          System.out.println("Can't insert at this position.");
        }
        break;


      case "reverse" :
        try {
        lList.reverseOf();
        for (Integer element : lList) {
          string += element + ", ";
        }
        System.out.println(string.substring(0, string.length() - 2));
        } catch (Exception e) {
          System.out.println("No elements to reverse.");
        }
        break;


      default:
      break;
      }
    }

  }
}
