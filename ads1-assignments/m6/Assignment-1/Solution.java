import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {

    private AddLargeNumbers() {
        //unused constructor.
    }

    /**
     * LinkedList of digits from given string.
     *
     * @param      number  String from the input.
     *
     * @return     a  linked list of integrs/digits.
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            integerList.add(digit);
        }
        return integerList;
    }

    /**
     * Digits to String.
     *
     * @param      list  of digits.
     *
     * @return     String format of digits in inked list.
     */
    public static String digitsToNumber(final LinkedList list) {
        String string = "";
        Iterator iterator = list.iterator();
            // Iterator implements linked list as For-each.

            // We can even use "node.next != null", to iterate.
        while (iterator.hasNext()) {
            // hasNext() is equivalent to "node.next != null"
          string += iterator.next();
            // iterator.next() returns each value in the list.
        }


        return string;

    }

    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     returns the reusultant linkedList.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
                                                final LinkedList list2) {

        LinkedList<Integer> additionList = new LinkedList<Integer>();



        return additionList;
    }
}


/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(
                                                        pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;

            default:
                break;
        }
    }

}
