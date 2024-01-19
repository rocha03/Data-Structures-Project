package game.Interfaces;

/**
 * Interface for the players of the game.
 */
public interface IPlayer {

    /**
     * Getter for the player's name.
     * 
     * @return the name in String form.
     */
    public String getName();

    /**
     * Getter for the position of the player's flag.
     * 
     * @return the flag's position in String form.
     */
    public String getFlag();

    /**
     * Finds the bot whitch will move next.
     * 
     * @return the next bot to move.
     */
    public IBot nextBot();
}
