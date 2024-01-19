package game;

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
     * Constructor
     */
    private Map() {

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
    public void generate_map(int locations_qty, Direction direction, float density) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void load_map(String filename) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void save_map(String name) {
        // TODO Auto-generated method stub

    }

}
