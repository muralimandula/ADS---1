import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {

    	LinkedList<Integer> integerList = new LinkedList<Integer>();

    	for(int i =0; i < number.length(); i++) {


    		integerList.add(Integer.parseInt(String.valueOf(number.charAt(i))));

    	}

    	return integerList;
    }

    public static String digitsToNumber(LinkedList list) {

    	String string = "";

		Iterator iterator = list.iterator();

	    while(iterator.hasNext())
	    {
	      string += iterator.next();
	    }


    	return string;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    	LinkedList<Integer> additionList = new LinkedList<Integer>();



 		return additionList;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
     			pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }

}
