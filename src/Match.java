/**
 * Match.java
 * 
 * Represents an entry for a match
 * 
 * @author Brayden Hagedorn
 * @version 11/8/2026
*/
public class Match {
    private final Team winner; // winning team
    private final Team loser; // losing team
    private final  String map;
    private final String mode;

    public Match(Team winner, Team loser, String map, String mode) {
        this.winner = winner;
        this.loser = loser;
        this.map = map;
        this.mode = mode;
    }

    public Team getWinner() {
        return winner;
    }

    public Team getLoser() {
        return loser;
    }

    public String getMap() {
        return map;
    }

    public String getMode() {
        return mode;
    }
}