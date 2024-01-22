package game;

import java.util.Random;

import datastructs.Classes.graph.Network;
import game.Enums.Direction;
import game.Interfaces.IMap;

/**
 * Class for the game map.
 */
public class Map implements IMap {

    /**
     * Singleton instance of the class Map.
     */
    private static Map instance = null;
    /**
     * Network with the map.
     */
    private Network<String> map;
    /**
     * Whether the bots in the game will be able to move backwards in the map.
     */
    private Direction direction;

    /**
     * Constructor
     */
    private Map() {
        this.map = new Network<String>();
    }

    /**
     * Singleton method that returns the instance of this class, or creates a new
     * one if there isn't any.
     * 
     * @return the instance of the class.
     */
    public static Map getInstance() {
        if (Map.instance == null) {
            Map.instance = new Map();
        }
        return Map.instance;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void generateMap(int locations_qty, Direction direction, float density) {
        this.direction = direction;
        for (int i = 0; i < locations_qty; i++) {
            this.map.addVertex("vx" + (i + 1));
        }

    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void loadMap(String filename) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void saveMap(String name) {
        // TODO Auto-generated method stub

    }

}
