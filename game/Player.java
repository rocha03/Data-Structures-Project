package game;

import game.Interfaces.IBot;
import game.Interfaces.IPlayer;

/**
 * Class for the players of the game.
 * 
 * @author Alexandre Rocha, Gabriel Klotz
 */
public class Player implements IPlayer {

    /**
     * Name of the player.
     */
    private String name;
    /**
     * Position of the player's flag.
     */
    private String flag;

    /**
     * Constructor.
     * 
     * @param name is the name of the player.
     * @param flag is the position of the player's flag.
     */
    public Player(String name, String flag) {
        this.name = name;
        this.flag = flag;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public String getFlag() {
        return flag;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public IBot nextBot() {
        // TODO Auto-generated method stub
        return null;
    }

}
