package logic;
import java.util.*;

public class FootballScoreBoard
{
	public static Integer matchId = 0;             
    private Map<Integer, Match> matches;
    private List<Match> inProgressMatches;

    public FootballScoreBoard() 
    {
        matches = new HashMap<>();
        inProgressMatches = new ArrayList<>(); 
    }

    /**
     * This function is responsible to start the match
     * @param homeTeam
     * @param awayTeam
     */
    public void startMatch(String homeTeam, String awayTeam)
    {
    	if((homeTeam != null && homeTeam.length() > 0) && (awayTeam != null && awayTeam.length() > 0))
    	{
	        Match match = new Match(homeTeam, awayTeam ,++matchId);
	        matches.put(match.getMatchId(), match);
	        inProgressMatches.add(match);
    	}
    	else
    		System.err.print("Cannot start the match. Home Team/Away Team name is NULL");
    }

    /**
     * This function is responsible to update match score 
     * @param matchId
     * @param homeScore
     * @param awayScore
     */
    public void updateScore(int matchId, int homeScore, int awayScore)
    {    	
        Match match = matches.get(matchId);
        if (match != null) {
            match.updateScore(homeScore, awayScore);
        }
        else
        	System.err.println("Cannot update score. Match with Id => " + matchId + " not found.");
    }

    /**
     * This function is responsible to end the match and remove the match from inprogress match list 
     * @param matchId
     */
    public void finishMatch(int matchId)
    {
        Match match = matches.get(matchId);
        if (match != null) 
        {
        	inProgressMatches.remove(match);
            matches.remove(matchId);
        }
        else
        	System.err.println("Cannot finish the match. Match with Id => " + matchId + " not found.");
    }
    
    /**
     * This function is responsible to get the list of matches which are ongoing
     * @return - In progress matches list 
     */
    public List<Match> getMatchesInProgress() 
    {
        Collections.sort(inProgressMatches, new MatchComparator());
        
        return inProgressMatches;
    }     
}

/**
 * MatchComparator is custom comparator class for sorting the recent matches
 * ordered by their total score
 *
 */
class MatchComparator implements Comparator<Match> 
{
    public int compare(Match m1, Match m2) 
    {
        int scoreDiff = m2.getTotalScore() - m1.getTotalScore();
        
        if (scoreDiff != 0) {
            return scoreDiff;
        } else {
            return m2.getMatchId().compareTo(m1.getMatchId());
        }
    }
}