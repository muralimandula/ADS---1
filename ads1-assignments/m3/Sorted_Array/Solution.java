import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for sorted.
 */
final class Sorting {

  /**
   * Constructs the object.
   */
  private Sorting() {

  }


  /**
   * Adds an arr.
   *
   * @param      intArray1  The int array 1
   * @param      intArray2  The int array 2
   */
  public static void addArr(final int[] intArray1, final int[] intArray2) {
    int newArrLength = intArray1.length + intArray2.length;

    int[] newArray = new int[newArrLength];
    int size = 0;
    int i = 0;
    int j = 0;

    while (size < newArrLength) {
      if (i < intArray1.length && j < intArray2.length
       && intArray1[i] <= intArray2[j]) {

        newArray[size] = intArray1[i];
        size += 1;
        i += 1;
      }
      if (i < intArray1.length && j < intArray2.length
       && intArray1[i] > intArray2[j]) {
        newArray[size] = intArray2[j];
        size += 1;
        j += 1;
      } else if (i < intArray1.length) {
        newArray[size] = intArray1[i];
        i += 1;
        size += 1;
      } else if (j < intArray2.length) {
        newArray[size] = intArray2[j];
        j += 1;
        size += 1;
      }

    }
    System.out.println(Arrays.toString(newArray).replaceAll("[\\]\\[ ]", ""));
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

  }

  /**
   * main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);

    int size1 = Integer.parseInt(scan.nextLine());
    int size2 = Integer.parseInt(scan.nextLine());

    String[] array1 = scan.nextLine().split(",");
    String[] array2 = scan.nextLine().split(",");

    int[] intarray1 = new int[size1];
    int[] intarray2 = new int[size2];

    if (size1 != 0) {
      for (int i = 0; i < array1.length; i++) {

        intarray1[i] = Integer.parseInt(array1[i]);
        // String to int, whike creating new array.
      }
    }

    if (size2 != 0) {
      for (int j = 0; j < array2.length; j++) {

        intarray2[j] = Integer.parseInt(array2[j]);
      }
    }

    Sorting.addArr(intarray1, intarray2);
  }
}
