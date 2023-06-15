/** 
 *POJO Class to represent a Football Match
 */
class Match
{
   private int matchId;      	  //Unique identifier for match
   private String homeTeam;   	 //Home Team Name
   private String awayTeam; 	 //Away Team Name
   private int homeTeamScore;	 //Home Team Score
   private int awayTeamScore;	 //Away Team Score

   public Match(String homeTeam, String awayTeam, int id)
   {
       this.matchId = id;
       this.homeTeam = homeTeam;
       this.awayTeam = awayTeam;
       this.homeTeamScore = 0;
       this.awayTeamScore = 0;
   }

   public Integer getMatchId() 
   {
       return matchId;
   }    
 
    public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public int getHomeScore() {
		return homeTeamScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeTeamScore = homeScore;
	}

	public int getAwayScore() {
		return awayTeamScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayTeamScore = awayScore;
	}

	//Method to update score of both the teams(Home Team and Away team)
	public void updateScore(int homeScore, int awayScore) 
   {
       this.homeTeamScore = homeScore;
       this.awayTeamScore = awayScore;
   }

	//Method to calculate score of both the teams(Home Team and Away team)
   public int getTotalScore() 
   {
       return homeTeamScore + awayTeamScore;
   }      
}
