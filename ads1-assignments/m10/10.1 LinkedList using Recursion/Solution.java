import java.util.Scanner;
import java.util.Iterator;
/**
 * LinkedList implementing Iterator.
 *
 * @param      <Generic>  The generic type.
 */
class LinkedList<Generic> implements Iterable<Generic> {

  /**
   * Node head, initialised.
   */
  private Node head; //creating first/ead element.

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

                /**
                 * Constructs the object.
                 *
                 * @param      dataCreate  The data created
                 * @param      nextCreate  The next created
                 */
                Node(final Generic dataCreate, final Node nextCreate) {
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
  public void insertAt(final int index, final Generic element) {
    // inserting at a position/index
    head = insertHelper(head, index, element);
    }


  /**
   * Inserting node/element into the linkedList.
   *
   * Time COmplexity : O(N).
   *
   * @param      insertHead      The insertHead
   * @param      position  The position
   * @param      element   The element
   *
   * @return     { description_of_the_return_value }
   */
  public Node insertHelper(final Node insertHead, final int position,
                 final Generic element) {

    if (position == 0) {
      return new Node(element, insertHead);
        // for the first time, insertHead is null.
        // Thereafter, insertHead is previous insertHead.data.
      }
      insertHead.next = insertHelper(insertHead.next,  position - 1, element);
      // System.out.println(insertHead.data);
      return insertHead;
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
   * @param      rhead  The head in reversing.
   *
   * @return     Node/element.
   */
  public Node reverseHelper(final Node rhead) {
      if (rhead == null || rhead.next == null) {
        return rhead;
      }
      Node nhead = reverseHelper(rhead.next);
      rhead.next.next = rhead;
      rhead.next = null;
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
       * Current node initialised.
       */
      private Node current;

      /**
       * Constructs the object.
       * taking node as current.
       *
       * @param      first  The first
       */
      MyIterator(final Node first) {
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
final class Solution {

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
