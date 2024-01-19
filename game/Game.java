package game;

import game.Interfaces.IPlayer;
import game.Enums.GameStatus;
import game.Interfaces.IGame;
import game.Interfaces.IMap;

/**
 * Class that manages the whole game.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class Game implements IGame {
    /**
     * Singleton instance of the class Game.
     */
    private static Game instance = null;

    private IMap map;

    private IPlayer player1;
    private IPlayer player2;

    private GameStatus status;

    /**
     * Construtor
     */
    private Game() {
        this.map = Map.getInstance();
        this.player1 = null;
        this.player2 = null;
        this.status = GameStatus.MAP_DEF;
    }

    /**
     * Singleton method that returns the instance of this class, or creates a new
     * one if there isn't any.
     * 
     * @return the instance of the class.
     */
    public static Game getInstance() {
        if (Game.instance == null) {
            Game.instance = new Game();
        }
        return Game.instance;
    }

    /**
     * Method that takes the defenitions for a new map and creates it.
     * 
     * @param locations_qty amount of locations on the map.
     * @param direction     is either one-way or two-way.
     * @param density       is the percentage from 0 to 1 of the amount of edges.
     */
    public void mapDefenitions(int locations_qty, boolean direction, float density) { //make an enum for direction

        this.status = GameStatus.PLAYER_DEF;
    }

    /**
     * Method that imports the map defenitions from a specified file.
     * 
     * @param filename is the string containing the file name/path.
     */
    public void mapDefenitions(String filename) {

        this.status = GameStatus.PLAYER_DEF;
    }

    public void playerDefenitions() {
        
        this.status = GameStatus.NEW_GAME;
    }

    public void gameStart() {

        this.status = GameStatus.ONGOING;
    }

    public void gameEnd() {
        
    }

}
