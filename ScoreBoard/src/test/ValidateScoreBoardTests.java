package test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import logic.FootballScoreBoard;
import logic.Match;

public class ValidateScoreBoardTests {

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
		assertEquals(4, match.getHomeScore());
		assertEquals(0, match.getAwayScore());
	}


}
