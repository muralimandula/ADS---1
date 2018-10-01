import java.util.Scanner;


public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());

		Steque steque = new Steque();


		while (scan.hasNext()) {

		String[] command = scan.nextLine().split(" ");


			switch(command[0]) {

				case "push":
					steque.push(Integer.parseInt(command[1]));
					break;

				case "pop":
                    try {
						steque.pop();
                        System.out.println(steque.convertString());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                       }
					break;

				case "enqueue":
					steque.enqueue(Integer.parseInt(command[1]));
					System.out.println(steque.convertString());
					break;

				default:
					break;
			}

		}
	}
}