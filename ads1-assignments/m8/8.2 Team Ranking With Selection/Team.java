
/**
 * Class for team.
 */
public class Team implements Comparable<Team> {

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
    Team(final String nameOftheTeam, final int noOFwins,
                 final int noOflosses, final int noOfdraws) {
    this.teamName = nameOftheTeam;
    this.wins = noOFwins;
    this.losses = noOflosses;
    this.draws = noOfdraws;
  }


  	/**
  	 * That compares team1 with team2.
  	 *
  	 * This method does not have iterations, once executed will return.
  	 *
  	 * Hence, Complexity will be O(1).
  	 *
  	 * @param      team2  The team 2
  	 *
  	 * @return     1 - greater, -1 - lesser, 0 - equal.
  	 */
  	public int compareTo(Team team2) {
  		if (this.wins > team2.wins) {
  			return 1;
  		}
  		if (this.wins < team2.wins) {
  			return -1;
  		}
  		 		// if code above doesn't execcuted, says wins are equal.

  		if (this.losses < team2.losses) {
  			return 1;
  		}
  		if (this.losses > team2.losses) {
  			return -1;
  		}
  				// wins and looses are equls if code above doesn't satisfied.
  		if (this.draws > team2.draws) {
  			return 1; // team with more draws is good.
  		}
  		if (this.draws < team2.draws) {
  			return -1;
  		}
 		return 0;
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
 * Class for selection sort team.
 */
class SelectionSortTeam {

	/**
	 * Sorting the teams, through N(size/no.of.teams) teams.
	 *
	 * In any Case, it needs N iterations for each position.
	 * for each team to swap at each position, another N iterations.
	 *
	 * Hence, Complexity Base Case : N^2.
	 * 					 Average Case : N^2.
	 * 					 Worst Case : N^2.
	 *
	 * @param      teams  The teams
	 * @param      size   The size
	 */
	static void sort(Comparable[] teams, int size) {

		for(int i = 0; i < size; i++) {

			int minimumPosition = i;

			for(int j = i + 1; j < size; j++) {

				if(teams[j].compareTo(teams[minimumPosition]) > 0) {


					minimumPosition = j;

				}

			}
			swap(teams, i, minimumPosition);
		}
	}

	/**
	 * Swaps two compared teams.
	 *
	 * @param      teams            The teams
	 * @param      i                Index posiion to swap.
	 * @param      minimumPosition  The minimum position
	 */
	static void swap(Comparable[] teams, int i, int minimumPosition) {

		Comparable temp = teams[i];
		teams[i] = teams[minimumPosition];
		teams[minimumPosition] = temp;
	}


}