import java.util.Scanner;
/**
 *Class for dynamic median.
 */
class DynamicMedian {

    /**
     *object for MinPQ class of type Double.
     */
    private MinPQ<Double> min;

    /**
     *object for MaxPQ class of type Double.
     */
    private MaxPQ<Double> max;

    /**
     *COnstrucotr.
     */
    DynamicMedian() {
        min = new MinPQ<Double>();
        max = new MaxPQ<Double>();
    }

    /**
     *inserting into minHeap.
     *
     * @param      item  The item
     */
    public void insertAtMin(final double item) {
        min.insert(item);
    }

    /**
     *inserting into maxHeap.
     *
     * @param      item  The item
     */
    public void insertAtMax(final double item) {
        max.insert(item);
    }

    /**
     *getter for minHeap.
     *
     * @return     The minimum.
     */
    public double getMin() {
        return min.min();
    }

    /**
     *getter for maxHeap.
     *
     * @return     The maximum.
     */
    public double getMax() {
        return max.max();
    }

    /**
     *deleting max from maxHeap.
     *
     * @return     The max.
     */
    public double delMax() {
        return max.delMax();
    }

    /**
     *deleting minimum.
     *
     * @return     The minimum.
     */
    public double delMin() {
        return min.delMin();
    }

    /**
     *getter for minimum size.
     *
     * @return     The minimum size.
     */
    public int getMinSize() {
        return min.size();
    }
    /**
     * Gets the maximum size of maxheap.
     *
     * @return     The maximum size.
     */
    public int getMaxSize() {
        return max.size();
    }
}
/**
 *this class is for main method.
 */
final class Solution {
    /**
     *an empty constructor.
     */
    private Solution() {
    }
    /**
     *the main method is to.
     *take the input from user.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        DynamicMedian medianObj = new DynamicMedian();
        long inputs = scan.nextLong();
        double element = scan.nextDouble();
        medianObj.insertAtMin(element);
        double median = element;
        System.out.println(median);
        for (long i = 1; i < inputs; i++) {
            double input = scan.nextDouble();
            if (input > median) {
                medianObj.insertAtMin(input);
            } else if (input < median) {
                medianObj.insertAtMax(input);
            } else {
                medianObj.insertAtMin(input);
            }
            if (medianObj.getMinSize() - medianObj.getMaxSize() > 1) {
                medianObj.insertAtMax(medianObj.delMin());
            }
            if (medianObj.getMaxSize() - medianObj.getMinSize()  > 1) {
                medianObj.insertAtMin(medianObj.delMax());
            }
            if (Math.abs(
                        medianObj.getMinSize() - medianObj.getMaxSize()) == 1) {
                if (medianObj.getMinSize() > medianObj.getMaxSize()) {
                    median = medianObj.getMin();
                    System.out.println(median);
                } else {
                    median = medianObj.getMax();
                    System.out.println(median);
                }
            }
            if (medianObj.getMinSize()  == medianObj.getMaxSize()) {
                double min = medianObj.getMin();
                double max = medianObj.getMax();
                median = (min + max) / 2.0;
                System.out.println(median);
            }
        }
    }
}
