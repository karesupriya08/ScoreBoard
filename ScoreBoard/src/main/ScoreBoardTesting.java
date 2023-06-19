package main;

import service.FootballScoreBoard;

/**
 * Testing controller to test the Football Score Board Library Implementation
 *
 */
public class ScoreBoardTesting
{
	 public static void main(String a[])
    {
		 //Create object of FootballScoreBoard
    	FootballScoreBoard sb = new FootballScoreBoard();
    	
    	/*-----------Start the Match--------------*/
    	sb.startMatch("Mexico", "Canada");
    	sb.startMatch("Spain", "Brazil");
    	sb.startMatch("Germany", "France");
    	sb.startMatch("Uruguay", "Italy");
    	sb.startMatch("Argentina", "Australia"); 
    	sb.startMatch(null, null); 
    	/*----------------------------------------*/
    	
    	/*---------Update Match Score---------*/
    	sb.updateScore(1, 0, 5);
    	sb.updateScore(2, 10, 2);
    	sb.updateScore(3, 2, 2);
    	sb.updateScore(4, 6, 6);
    	sb.updateScore(5, 3, 1);
    	sb.updateScore(6, 4, 1);
    	/*------------------------------------*/
    	
    	sb.finishMatch(10);        //Finish Match
    	sb.finishMatch(6);   
    	
    	//Display Summary of matches in progress    	
    	sb.displayMatchSummary(sb.getMatchesInProgress());    	
    	
    	
    }
}
