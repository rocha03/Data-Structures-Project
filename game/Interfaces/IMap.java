package game.Interfaces;

/**
 * Interface for the superclass Map that stores the map to be used in the game.
 */
public interface IMap {
    /**
     * Wheighted graph that represents the game map.
     */
    // private WheightedGraph map;

    /**
     * Randomly generates a wheighted graph that will serve as the game map.
     * 
     * @param description is the set of modifiers that restrict the map generation.
     */
    public void generate_map(/* description */);

    /**
     * Saves the current map to be used at a later date.
     * 
     * @param name whitch will be saved with the map.
     */
    public void save_map(String name);

    /**
     * Stores a previously saved map into the game.
     */
    public void load_map();
}
