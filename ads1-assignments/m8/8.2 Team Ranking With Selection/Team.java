

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

  	public int compareTo(Team team2) {
  		if (this.wins > team2.wins) {
  			return 1;
  		}
 		return 0;
  	}


  	public String toString() {
  		return teamName;
  	}


}

class SelectionSortTeam {

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


	static void swap(Comparable[] teams, int i, int minimumPosition) {

		Comparable temp = teams[i];
		teams[i] = teams[minimumPosition];
		teams[minimumPosition] = temp;
	}


}