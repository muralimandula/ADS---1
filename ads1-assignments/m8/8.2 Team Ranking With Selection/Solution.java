import java.util.Scanner;

public final class Solution {

	Solution() {

	}

	public static String leaderBoard(final Team[] teams, final int size) {

	    SelectionSortTeam.sort(teams, size);

	    String leaderboard = "";
	    for (int i = 0; i < size; i++) {
	      leaderboard += teams[i].toString();
	      leaderboard += ",";
	    }
	    leaderboard = leaderboard.substring(0, leaderboard.length() - 1);
	    return leaderboard;
	  }




	public static void main(String[] args) {


   		final int three = 3;
   		final int ten = 10;
   		int size = 0;

		Team[] teams = new Team[ten];

		Scanner scan = new Scanner(System.in);

		while(scan.hasNext()) {

			String[] teamRecord = scan.nextLine().split(",");

			Team temp = new Team(teamRecord[0], Integer.parseInt(teamRecord[1]),
                      Integer.parseInt(teamRecord[2]), Integer.parseInt(teamRecord[three]));
			teams[size] = temp;
			size++;
		}
		scan.close(); //closing scanner.
		System.out.println(leaderBoard(teams, size));
	}
}