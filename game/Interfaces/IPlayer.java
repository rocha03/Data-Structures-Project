package game.Interfaces;

/**
 * Interface for the players of the game.
 */
public interface IPlayer {
    /**
     * Finds the bot whitch will move next.
     * 
     * @return the next bot to move.
     */
    public IBot nextBot();
}
