package test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import main.model.Match;
import main.service.FootballScoreBoard;

public class ScoreBoardTests {

	
	@Test
	public void testStartMatch()
	{
		FootballScoreBoard scoreboard = new FootballScoreBoard();
		scoreboard.startMatch("Mexico", "Canada");
		
		List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
		assertEquals(1, matchesInProgress.size());      
		 
		Match match = matchesInProgress.get(0);     
		assertEquals("Norway", match.getHomeTeam());         
		assertEquals("Canada", match.getAwayTeam());		
		assertEquals(6, match.getHomeScore());       		
		assertEquals(0, match.getAwayScore()); 				
	}
	
	@Test
	public void testUpdateScore() 
	{
		FootballScoreBoard scoreboard = new FootballScoreBoard();
		scoreboard.startMatch("Spain", "Brazil");
		scoreboard.startMatch("Argentina", "Australia"); 
		
		List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
		
		Match match = matchesInProgress.get(0);
		
		scoreboard.updateScore(match.getMatchId(), 2, 1);     
		scoreboard.updateScore(2, 2, 1); 						
		
		assertEquals(2, match.getHomeScore());       
		assertEquals(1, match.getAwayScore());		  
	}

	
	@Test
	public void testFinishMatch() 
	{
		FootballScoreBoard scoreboard = new FootballScoreBoard();
		scoreboard.startMatch("Uruguay", "Italy");
		scoreboard.startMatch("Spain", "Brazil");
		scoreboard.startMatch("Mexico", "Canada");
		
		List<Match> matchesInProgress = scoreboard.getMatchesInProgress();
		Match match = matchesInProgress.get(0);
		
		scoreboard.finishMatch(match.getMatchId());
		
		matchesInProgress = scoreboard.getMatchesInProgress();		
		assertEquals(0, matchesInProgress.size());
	}

}
