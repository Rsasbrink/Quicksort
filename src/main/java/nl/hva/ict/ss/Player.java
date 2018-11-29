package nl.hva.ict.ss;

/**
 * Player keeps track of the name and the highscore for a player. Once created
 * the name can't be changed. The best score for this player can be changed
 * during the lifetime of an instance.
 */
public class Player implements Comparable<Player> {

    private String firstName;
    private String lastName;
    private long highScore;

    public Player(String firstName, String lastName, long highScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.highScore = highScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getHighScore() {
        return highScore;
    }

    public void setHighScore(long highScore) {
        this.highScore = highScore;
    }

    @Override
    public int compareTo(Player other) {
        if (this.highScore > other.getHighScore()) {
            return 1;
        } else if (this.highScore == other.getHighScore()) {
            String lastName1 = this.lastName;
            String lastName2 = other.getLastName();
            if (lastName1.compareTo(lastName2) > 0) {
                return 1;
            } else if (lastName1.compareTo(lastName2) == 0) {
                String firstName1 = this.firstName;
                String firstName2 = other.getFirstName();

                if (firstName1.compareTo(firstName2) > 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
