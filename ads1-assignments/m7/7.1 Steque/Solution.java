import java.util.Scanner;

/**
 * Class for solution.
 */
final public class Solution {


    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }

    /**
     * Main Function.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(final String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            Steque steque = new Steque();

            while (scan.hasNext()) {
                String input = scan.nextLine();

                if (input.length() == 0) {
                    break;
                }

                String[] command = input.split(" ");


                switch (command[0]) {

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
            System.out.println();
            }
        }
}
