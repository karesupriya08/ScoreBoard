package main.service;
import java.util.*;

import main.helper.MatchComparator;
import main.model.Match;

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
    	if((Optional.ofNullable(homeTeam).isPresent() && homeTeam.length() > 0) && (Optional.ofNullable(awayTeam).isPresent() && awayTeam.length() > 0))
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
        if (Optional.ofNullable(match).isPresent()) {
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
        if (Optional.ofNullable(match).isPresent()) 
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
    
    
    public void displayMatchSummary(List<Match> matchList)
    {    	
    	if(matchList.size() > 0)
    	{
	    	System.out.println("------------IN PROGRESS MATCHES-----------");    	
	    	
	    	int index = 1;    	
	    	for(Match m : matchList)
	    	{
	    		System.out.println(index++ + " " + m.getHomeTeam() + " " + m.getHomeScore() + " - " + m.getAwayTeam() + " " + m.getAwayScore());
	    	}    	
	    	System.out.println("-------------------------------------------");
    	}
    	else
    		System.out.println("Currently no matches found.");
    	
    }
}
