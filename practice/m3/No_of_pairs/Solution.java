import java.util.*;
/**
 * Class for Solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    // unused constructor
  }

  /**
   * Main function.
   * Returns the combinational number of equal pairs in the given array.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    int noOfInputs = scan.nextInt();

    ArrayList<Integer> repeatCount = new ArrayList<>();

    int[] array = new int[noOfInputs];
    							//An int[] create for given size.

    for (int i = 0; i < noOfInputs; i++) {
      array[i] = scan.nextInt();
    }   						//Values inserted into int[].

    Arrays.sort(array); 		 //Array Sorted.

    int count = 1;
    int noOfPairs = 0;

    for (int i = 0; i < array.length - 1; i++) {

      if (array[i] == array[i + 1]) {
        count += 1;

      } else if(count > 1) {
        repeatCount.add(count);
        count = 1;
      }
    }
    repeatCount.add(count);

    for(int eachCount : repeatCount) {
    	noOfPairs += (eachCount * (eachCount - 1) ) / 2;
    }

    System.out.println("The possible number of equal pairs are: "
                       + noOfPairs);
  }
}