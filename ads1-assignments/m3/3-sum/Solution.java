import java.util.*;



public class Solution {


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


    Arrays.sort(array);

    int count = 0;

    for(int initial = 0; initial < noOfInputs; initial++) {

    	int last = noOfInputs - 1;

    	int i = 0;

    	int initialElement = array[initial];

    	while ( i != initial && last != initial) {

    		int threeSum = array[i] + array[last];

    		if (threeSum + initialElement > 0) {
    			last -= 1;

    		} else if (threeSum + initialElement < 0) {
    			i += 1;

    		} else {
    			count += 1;
    			i++;
    		}
    	}

    }

    System.out.println(count);


   }
}
