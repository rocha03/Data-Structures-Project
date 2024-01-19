package game;

import game.Interfaces.IPlayer;
import game.Enums.Direction;
import game.Enums.GameStatus;
import game.Exceptions.gameStatusIllegalAction;
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

    /**
     * Singleton instance of the map.
     */
    private IMap map;

    /**
     * First player.
     */
    private IPlayer player1;
    /**
     * Second player.
     */
    private IPlayer player2;

    /**
     * Status of the current game.
     */
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
     * {@inheritdoc}
     */
    @Override
    public IPlayer getPlayer1() throws gameStatusIllegalAction {
        if (this.status != GameStatus.NEW_GAME) {
            throw new gameStatusIllegalAction(
                    "You can only use this method when ths status is: " + GameStatus.NEW_GAME + ".");
        }
        return player1;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public IPlayer getPlayer2() throws gameStatusIllegalAction {
        if (this.status != GameStatus.NEW_GAME) {
            throw new gameStatusIllegalAction(
                    "You can only use this method when ths status is: " + GameStatus.NEW_GAME + ".");
        }
        return player2;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void mapDefenitions(int locations_qty, Direction direction, float density) throws gameStatusIllegalAction {
        if (this.status != GameStatus.MAP_DEF) {
            throw new gameStatusIllegalAction(
                    "You can only use this method when ths status is: " + GameStatus.MAP_DEF + ".");
        }
        this.map.generate_map(locations_qty, direction, density);
        this.status = GameStatus.PLAYER_DEF;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void mapDefenitions(String filename) throws gameStatusIllegalAction {
        if (this.status != GameStatus.MAP_DEF) {
            throw new gameStatusIllegalAction(
                    "You can only use this method when ths status is: " + GameStatus.MAP_DEF + ".");
        }
        this.map.load_map(filename);
        this.status = GameStatus.PLAYER_DEF;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void playerDefenitions(String p1, String flag1, String p2, String flag2) throws gameStatusIllegalAction {
        if (this.status != GameStatus.PLAYER_DEF) {
            throw new gameStatusIllegalAction(
                    "You can only use this method when ths status is: " + GameStatus.PLAYER_DEF + ".");
        }
        this.player1 = new Player(p1, flag1);
        this.player2 = new Player(p2, flag2);
        this.status = GameStatus.NEW_GAME;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void gameStart() {

        this.status = GameStatus.ONGOING;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void gameEnd() {

    }

}