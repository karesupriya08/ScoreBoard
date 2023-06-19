package helper;

import java.util.Comparator;
import model.Match;


/**
 * MatchComparator is custom comparator class for sorting the recent matches
 * ordered by their total score
 *
 */
public class MatchComparator implements Comparator<Match> 
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