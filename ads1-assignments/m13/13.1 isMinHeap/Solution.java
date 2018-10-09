import java.util.Scanner;

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }


    /**
     * Determines if heap.
     *
     *TIme Complexity - Best case : O(1).
     *TIme Complexity - Worse Case : O(N).
     *TIme Complexity - Average Case : O(N).
     *
     * @param      a     Comparable array.
     *
     * @return     True/False.
     */
    public static boolean isHeap(final Comparable[] a) {

        for (int i = 0; i < a.length; i++) {

            if (((2 * i + 1) < a.length) && ((2 * i + 2) < a.length)) {

                if (a[i].compareTo(a[2 * i + 1]) > 0 //first child coparison
                 || a[i].compareTo(a[2 * i + 2]) > 0) { //second child
                    return false;
                }
            }

        }
        return true;
    }


    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int size;
        Scanner scan = new Scanner(System.in);
        String typeOfArray = scan.nextLine();
        int testcases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < testcases; i++) {
            String line = scan.nextLine();
            if (line.length() == 0) {
                System.out.println("false");
            } else {
                String[] array = line.split(",");
                switch (typeOfArray) {
                case "String":
                    size  = 0;
                    String[] stringArray = new String[array.length];
                    for (int j = 0; j < array.length; j++) {
                        stringArray[size++] = array[j];
                    }
                    System.out.println(isHeap(stringArray));
                    break;
                case "Integer":
                    size = 0;
                    Integer[] intArray = new Integer[array.length];
                    for (int j = 0; j < array.length; j++) {
                        intArray[size++] = Integer.parseInt(array[j]);
                    }
                    System.out.println(isHeap(intArray));
                    break;
                case "Float":
                    size = 0;
                    Float[] floatArray = new Float[array.length];
                    for (int j = 0; j < array.length; j++) {
                        floatArray[size++] = Float.parseFloat(array[j]);
                    }
                    System.out.println(isHeap(floatArray));
                    break;
                case "Double":
                    size = 0;
                    Double[] doubleArray = new Double[array.length];
                    for (int j = 0; j < array.length; j++) {
                        doubleArray[size++] = Double.parseDouble(array[j]);
                    }
                    System.out.println(isHeap(doubleArray));
                    break;
                default:
                    break;
                }
            }
        }
    }
}