import java.util.Scanner;

/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }

    /**
     * Leaderboard format of teams.
     *
     * @param      teams  The teams
     * @param      size   The size
     *
     * @return     String format of leaderboard.
     */
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



    /**
     * Main fUnction.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {


        final int three = 3;
        final int ten = 10;
        int size = 0;

        Team[] teams = new Team[ten];

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            String[] teamRecord = scan.nextLine().split(",");

            Team temp = new Team(teamRecord[0],
                     Integer.parseInt(teamRecord[1]),
                          Integer.parseInt(teamRecord[2]),
                           Integer.parseInt(teamRecord[three]));
            teams[size] = temp;
            size++;
        }
        scan.close(); //closing scanner.
        System.out.println(leaderBoard(teams, size));
    }
}