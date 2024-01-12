package game.Interfaces;

/**
 * Interface for the algorithms that the bots will use.
 */
public interface IAlgorithm {
    /**
     * Calculates the position where the bot will move.
     */
    public void/* nodes */ next();
}
