import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * SplatCheck.java
 * 
 * A searchable database for information on Splatoon 3 teams, players, and matches.
 * 
 * @author Brayden Hagedorn
 * @version 11/8/2026
*/
public class SplatCheck {
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Team> teams = new ArrayList<>();
    public static ArrayList<Match> matches = new ArrayList<>();
    public static void main(String[] args) {
        loadData();
        int input = 0;
        while (true) {
            IO.println("1) Display data");
            IO.println("2) Add data");
            IO.println("3) Edit data");
            IO.println("4) Save & Exit");

            try {
                input = Integer.parseInt(IO.readln("Enter your choice: "));
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Please enter a number.");
            }

            if (input == 1) {
                IO.println("1) Player");
                IO.println("2) Team");
                IO.println("3) Match");
                
                try {
                    input = Integer.parseInt(IO.readln("Enter your choice: "));
                } catch (NumberFormatException e) {
                    IO.println("Invalid input. Please enter a number.");
                }

                if (input == 1) {
                    IO.println("1) View All");
                    IO.println("2) Search by name");
                    IO.println("3) Search by splashtag");
                    
                    try {
                        input = Integer.parseInt(IO.readln("Enter your choice: "));
                    } catch (NumberFormatException e) {
                        IO.println("Invalid input. Please enter a number.");
                    }

                    if (input == 1) {
                        for (Player player : players) {
                            IO.println("Splashtag: " + player.getSplashtag() + ", Division: " + player.getDiv());
                        }
                    } else if (input == 2) {
                        String name = IO.readln("Enter the player's name: ");
                        for (Player player : players) {
                            if (player.getSplashtag().startsWith(name)) {
                                IO.println("Player found: " + player.getSplashtag() + ", Division: " + player.getDiv());
                                break;
                            }
                        }
                    } else if (input == 3) {
                        String splashtag = IO.readln("Enter the player's splashtag: ");
                        for (Player player : players) {
                            if (player.getSplashtag().equals(splashtag)) {
                                IO.println("Player found: " + player.getSplashtag() + ", Division: " + player.getDiv());
                                break;
                            }
                        }
                    }
                } else if (input == 2) {
                    String name = IO.readln("Enter the team's name: ");
                    for (Team team : teams) {
                        if (team.getName().equals(name)) {
                            IO.println("Team found: " + team.getName());
                            break;
                        }
                    }
                } else if (input == 3) {
                    // todo
                }
            } else if (input == 2) {
                IO.println("1) Player");
                IO.println("2) Team");
                IO.println("3) Match");
                
                try {
                    input = Integer.parseInt(IO.readln("Enter your choice: "));
                } catch (NumberFormatException e) {
                    IO.println("Invalid input. Please enter a number.");
                }

                if (input == 1) {
                    String splashtag = IO.readln("Enter the player's splashtag: ");
                    int div;
                    while (true) {
                        try {
                            div = Integer.parseInt(IO.readln("Enter the player's division: "));
                            break;
                        } catch (NumberFormatException e) {
                            IO.println("Invalid input. Please enter a number.");
                        }
                    }
                    addPlayer(splashtag, div);
                } else if (input == 2) {
                    String name = IO.readln("Enter the team's name: ");
                    addTeam(name);
                } else if (input == 3) {
                    // todo
                }
            } else if (input == 3) {
                IO.println("todo");
            } else if (input == 4) {
                saveData();
                IO.println("Data saved. Exiting...");
                break;
            }
            IO.println();
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadData() {
        try {
            FileInputStream in = new FileInputStream("players.data");
            ObjectInputStream out = new ObjectInputStream(in);
            players = (ArrayList<Player>) out.readObject();
            out.close();
            in.close();

            in = new FileInputStream("teams.data");
            out = new ObjectInputStream(in);
            teams = (ArrayList<Team>) out.readObject();
            out.close();
            in.close();

            in = new FileInputStream("matches.data");
            out = new ObjectInputStream(in);
            matches = (ArrayList<Match>) out.readObject();
            out.close();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            saveData(); // Create new files if they don't exist
        }
    }

    private static void saveData() {
        try {
            FileOutputStream in = new FileOutputStream("players.data");
            ObjectOutputStream out = new ObjectOutputStream(in);   
            out.writeObject(players);
            out.close();
            in.close();

            in = new FileOutputStream("teams.data");
            out = new ObjectOutputStream(in);
            out.writeObject(teams);
            out.close();
            in.close();

            in = new FileOutputStream("matches.data");
            out = new ObjectOutputStream(in);
            out.writeObject(matches);
            out.close();
            in.close();
        } catch (IOException e) {
            IO.println("Error saving data: " + e.getMessage());
        }
    }

    private static void addPlayer(String splashtag, int div) {
        players.add(new Player(splashtag, div));
    }

    private static void addTeam(String name) {
        teams.add(new Team(name));
    }

    private static void addMatch(Team winner, Team loser, String map, String mode) {
        matches.add(new Match(winner, loser, map, mode));
    }
}