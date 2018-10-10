import java.util.*;

public class Solution {

	Solution() {
	}


		static void median(final ArrayList<Integer> intArray) {

			// System.out.println(intArray);

			Collections.sort(intArray);
			// System.out.println(intArray);

			int arraySize = intArray.size();
			double median;
			if(arraySize % 2 != 0) {

				// System.out.println(intArray.get(arraySize / 2));
				median = intArray.get(arraySize / 2);
				System.out.println(median);
			} else {


				// System.out.println((intArray.get(arraySize / 2) + " "  + intArray.get((arraySize / 2) - 1)));

				median = ((double)intArray.get(arraySize / 2) + intArray.get((arraySize / 2) - 1)) / 2;



				System.out.println(median);

			}

		}

		public static void main(final String[] args) {

			Scanner scan = new Scanner(System.in);

			int nOfIntegers = Integer.parseInt(scan.nextLine());
			ArrayList<Integer> array = new ArrayList<>();
			for (int i = 0; i < nOfIntegers; i++) {
				array.add(Integer.parseInt(scan.nextLine()));
				median(array);
			}

		}
}
