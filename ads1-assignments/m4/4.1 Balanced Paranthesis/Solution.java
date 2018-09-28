import java.util.Scanner;

/**
 * Class to check for balanced paranthesis.
 */
class BalancedParanthesis {
  /**
   * inputs.
   */
  private char[] parenthesis;
  /**
   * Makes a stack of the given inputs.
   */
  private Stack<Character> stackOfBrackets;

  /**
   * Constructs the object.
   *
   * @param      s     { parameter_description }
   */
  BalancedParanthesis(final String s) {
    parenthesis = s.toCharArray();
    stackOfBrackets = new Stack();
  }

  /**
   * Determines if balanced.
   *
   * @return     True if balanced, False otherwise.
   */
  public boolean isBalanced() {

    for (char c : parenthesis) {

      if (c == '[' || c == '(') {
        stackOfBrackets.push(c);
      } else if (c == ']') {

        if (stackOfBrackets.isEmpty() || stackOfBrackets.pop() != '[') {
          return false;
        }
      } else if (c == ')') {

        if (stackOfBrackets.isEmpty() || stackOfBrackets.pop() != '(') {
          return false;
        }
      } else if (c == '}') {
        if (stackOfBrackets.isEmpty() || stackOfBrackets.pop() != '{') {
          return false;
        }
      }

    }
    return stackOfBrackets.isEmpty();
  }

}


/**
 * Class for Solution.
 */
public final class Solution {

  /**
   * Constructs the object.
   */
  private Solution() {
    /**
     * Unused constructor.
     */
  }

  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner sc = new Scanner(System.in);
    int noOfLines = Integer.parseInt(sc.nextLine());

    while (sc.hasNext()) {
      String input = new String(sc.nextLine());
      BalancedParanthesis stringCheck = new BalancedParanthesis(input);
      if (stringCheck.isBalanced()) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

}
