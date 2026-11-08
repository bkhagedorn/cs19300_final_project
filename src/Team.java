import java.util.ArrayList;
/**
 * Team.java
 * 
 * Represents an entry for a team
 * 
 * @author Brayden Hagedorn
 * @version 11/8/2026
*/
public class Team {
    private String name;
    private ArrayList<Player> players;
    private ArrayList<String> playerTypes;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
        playerTypes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players.toArray(new Player[0]);
    }

    public String getPlayerType(Player player) {
        int index = players.indexOf(player);
        if (index != -1) {
            return playerTypes.get(index);
        }
        return null;
    }

    public void addPlayer(Player player, String playerType) {
        if (playerType.toLowerCase().equals("captain") || playerType.toLowerCase().equals("sub") || playerType.toLowerCase().equals("main")) {
            playerTypes.add(playerType);
        } else {
            throw new IllegalArgumentException("Player type must be either 'captain', 'sub', or 'main'.");
        }
        players.add(player);
    }

    public void removePlayer(Player player) {
        int index = players.indexOf(player);
        if (index != -1) {
            players.remove(index);
            playerTypes.remove(index);
        }
    }

    public void updatePlayerType(Player player, String newType) {
        int index = players.indexOf(player);
        if (index != -1) {
            if (newType.toLowerCase().equals("captain") || newType.toLowerCase().equals("sub") || newType.toLowerCase().equals("main")) {
                playerTypes.set(index, newType);
            } else {
                throw new IllegalArgumentException("Player type must be either 'captain', 'sub', or 'main'.");
            }
        }
    }
}