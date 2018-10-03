import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for team object.
 * We use comparable interface to implement sort algortihms.
 */
class Team implements Comparable<Team> {
  /**
   * team name.
   */
  String teamName;
  /**
   * wins for the team.
   */
  int wins;
  /**
   * losses for the team.
   */
  int losses;
  /**
   * draws for the team.
   */
  int draws;

  /**
   * Constructs the object.
   *
   * @param      nameOftheTeam  The name ofthe team
   * @param      noOFwins       No o fwins
   * @param      noOflosses     No oflosses
   * @param      noOfdraws      No ofdraws
   */
  Team(final String nameOftheTeam, final int noOFwins, final int noOflosses, final int noOfdraws) {
    teamName = nameOftheTeam;
    wins = noOFwins;
    losses = noOflosses;
    draws = noOfdraws;
  }

  /**
   * Compares two objects of this class.
   * Complexity Analysis: O(1).
   *
   * @param      other  The other
   *
   * @return     1 if greater
   *             0 if equal.
   *             -1 if lesser.
   */
  public int compareTo (Team other) {
    if (this.wins > other.wins) return 1;
    if (this.wins < other.wins) return -1;
    if (this.losses < other.losses) return 1;
    if (this.losses > other.losses) return -1;
    if (this.draws > other.draws) return 1;
    if (this.draws < other.draws) return -1;
    else return 0;
  }

  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return teamName;
  }

}

/**
 * Class for insertion sort of teams.
 */
class InsertionSortTeam {
  /**
   * To check if the object is greater.
   *
   * @param      a     team 1
   * @param      b     team 2
   *
   * @return     returns true if team 1 is greater than
   * team 2 on the leader board.
   */
  static boolean more (Comparable a, Comparable b) {
    return a.compareTo(b) > 0;
  }

  /**
   * Swaps 2 objects in the array of objects.
   *
   * @param      a     Array of objects.
   * @param      i     Object 1.
   * @param      j     Object 2.
   */
  static void swap (Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * Sorts the array of objects using Insertion Sort.
   *
   * Best Case: N-1 compares and 0 exchanges.
   * Average Case: (N^2)/4 compares and (N^2)/4 exchanges.
   * Worst Case: (N^2)/2 compares and (N^2)/2 exchanges.
   *
   * @param      teamObjectArr   The array of objects/teams.
   * @param      size  The number of objects in the array.
   */
  static void sort(Comparable[] teamObjectArr, int size) {

    for (int i = 0; i < size; i++) {
      for (int j = i; j > 0; j--) {

        if (more(teamObjectArr[j], teamObjectArr[j - 1])) {
            swap(teamObjectArr, j, j - 1);   // Swapping team positions.
        }
      }
    }
  }
}


/**
 * Class for Solution.
 */
public final class Solution {

  final static int three = 3;
  final static int ten = 10;

  /**
   * Constructs the object.
   */
  private Solution() {
    // unused constructor
  }

  /**
   * like toString, to display leaderboard.
   *
   * @param      teamsTOCompare  The teams to compare
   * @param      sizeOfteams     The size ofteams
   *
   * @return     { description_of_the_return_value }
   */
  public static String leaderBoard(final Team[] teamsTOCompare, final int sizeOfteams) {

    InsertionSortTeam.sort(teamsTOCompare, sizeOfteams);

    String leaderboard = "";
    for (int i = 0; i < sizeOfteams; i++) {
      leaderboard += teamsTOCompare[i].toString();
      leaderboard += ",";
    }
    leaderboard = leaderboard.substring(0, leaderboard.length() - 1);
    return leaderboard;
  }

  /**
   * Main method.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);

    Team[] teams = new Team[ten];
    int size = 0;

    while (scan.hasNext()) {
      String[] teamRecord = scan.nextLine().split(",");
      Team temp = new Team(teamRecord[0],
                           Integer.parseInt(teamRecord[1]),
                           Integer.parseInt(teamRecord[2]),
                           Integer.parseInt(teamRecord[three]));
      teams[size] = temp;
      size += 1;
    }
    scan.close();
    System.out.println(leaderBoard(teams, size));
  }
}
