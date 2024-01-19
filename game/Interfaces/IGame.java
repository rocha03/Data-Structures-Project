package game.Interfaces;

import game.Enums.Direction;
import game.Enums.GameStatus;
import game.Exceptions.gameStatusIllegalAction;

/**
 * Interface for the game itself.
 */
public interface IGame {

    /**
     * Getter for the first player.
     * 
     * @return the first player.
     * @throws gameStatusIllegalAction when you can no longer use this method.
     */
    public IPlayer getPlayer1() throws gameStatusIllegalAction;

    /**
     * Getter for the second player.
     * 
     * @return the second player.
     * @throws gameStatusIllegalAction when you can no longer use this method.
     */
    public IPlayer getPlayer2() throws gameStatusIllegalAction;

    /**
     * Getter for the current status of the game.
     * 
     * @return
     */
    public GameStatus getStatus();

    /**
     * Method that takes the defenitions for a new map and creates it.
     * 
     * @param locations_qty amount of locations on the map.
     * @param direction     is either one-way or two-way.
     * @param density       is the percentage from 0 to 1 of the amount of edges.
     * @throws gameStatusIllegalAction when you can no longer use this method.
     */
    public void mapDefenitions(int locations_qty, Direction direction, float density) throws gameStatusIllegalAction;

    /**
     * Method that imports the map defenitions from a specified file.
     * 
     * @param filename is the string containing the file name/path.
     * @throws gameStatusIllegalAction when you can no longer use this method.
     */
    public void mapDefenitions(String filename) throws gameStatusIllegalAction;

    /**
     * Method that sets the players' defenitions for the first time in the game.
     * 
     * @param p1    name of the first player.
     * @param flag1 the flag that the first player chose.
     * @param p2    name of the second player.
     * @param flag2 the flag that the second player chose.
     * @throws gameStatusIllegalAction when you can no longer use this method.
     */
    public void playerDefenitions(String p1, String flag1, String p2, String flag2) throws gameStatusIllegalAction;// change

    /**
     * Method that starts the game itself.
     */
    public void gameStart();

    /**
     * Method that ends the current game.
     */
    public void gameEnd();
}
