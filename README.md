### FootballScoreBoard - 
FootballScoreBoard provides functionality to start a match, update the score of a match, finish a match, retrieve a list of matches in progress and display the summary of matches in progress.

FootballScoreBoard class instance variables:
- matchId : ID of the match.
- matches : A map that stores matches with matchId as key and Mathc object as value.
- inProgressMatches : A list that keeps track of matches currently in progress.

The FootballScoreBoard class methods:

### startMatch(String homeTeam, String awayTeam)
Starts a new match with the given home team and away team with initial score of 0 0. It creates a new Match object, assigns a unique ID to it, and adds it to the matches map and the inProgress list.

### updateScore(int matchId, int homeScore, int awayScore)
Updates the score of the match with the given match ID. 

### finishMatch(int matchId)
Finishes the match with the given match ID. It removes the Match object from the inProgress list.

### getMatchesInProgress()
Returns a sorted list of matches currently in progress. It sorts the inProgress list using a custom MatchComparator that compares matches based on their total score and Match ID.

### displayMatchSummary()
Displays the list of matches that are in progress.

### Match class - 
The Match class represents a single match. 

Match instance variables:
- matchId : A unique identifier for the match (int).
- homeTeam : The name of the home team (String).
- awayTeam : The name of the away team (String).
- homeTeamScore : The score of the home team (int).
- awayTeamScore : The score of the away team(int).


### TestingCtrl class - 
TestingCtrl class provides main() to check the implementation of FootballScoreBoard class.
