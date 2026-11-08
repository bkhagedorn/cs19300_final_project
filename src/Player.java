import java.util.ArrayList;
/**
 * Player.java
 * 
 * Represents an entry for a specific player
 * 
 * @author Brayden Hagedorn
 * @version 11/8/2026
*/
public class Player {
    private String splashtag;
    private ArrayList<String> weapons;
    private ArrayList<String> teams;
    private int div;

    public Player(String splashtag, int div) {
        this.splashtag = splashtag;
        weapons = new ArrayList<>();
        teams = new ArrayList<>();
        this.div = div;
    }

    public String getSplashtag() {
        return splashtag;
    }

    public void updateSplashtag(String splashtag) {
        this.splashtag = splashtag;
    }

    public String[] getWeapons() {
        return weapons.toArray(new String[0]);
    }

    public void addWeapon(String weapon) {
        weapons.add(weapon);
    }

    public void removeWeapon(String weapon) {
        weapons.remove(weapon);
    }

    public String[] getTeams() {
        return teams.toArray(new String[0]);
    }

    public void addTeam(String team) {
        teams.add(team);
    }

    public void removeTeam(String team) {
        teams.remove(team);
    }

    public int getDiv() {
        return div;
    }
    
    public void updateDiv(int div) {
        this.div = div;
    }
}