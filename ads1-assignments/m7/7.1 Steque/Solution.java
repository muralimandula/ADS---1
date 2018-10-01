import java.util.Scanner;


public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Steque steque = new Steque();

		for(int i = 0; i < n; i++) {

		while (scan.hasNext()) {
		String[] command = scan.nextLine().split(" ");

			if (command.length == 0) {
				break;
			}

			switch(command[0]) {

				case "push":
					steque.push(Integer.parseInt(command[1]));
					System.out.println(steque.convertString());
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

		System.out.println("");
	}
	}
}