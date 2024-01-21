package game.Interfaces;

import game.Enums.Direction;

/**
 * Interface for the class that stores the map to be used in the game.
 */
public interface IMap {
    /**
     * Wheighted graph that represents the game map.
     */
    // private WheightedGraph map;

    /**
     * Randomly generates a wheighted graph that will serve as the game map.
     * 
     * @param locations_qty amount of locations on the map.
     * @param direction     is either one-way or two-way.
     * @param density       is the percentage from 0 to 1 of the amount of edges.
     */
    public void generateMap(int locations_qty, Direction direction, float density);

    /**
     * Stores a previously saved map into the game.
     * 
     * @param filename is the string containing the file name/path.
     */
    public void loadMap(String filename);

    /**
     * Saves the current map to be used at a later date.
     * 
     * @param name whitch will be saved with the map.
     */
    public void saveMap(String name);
}
