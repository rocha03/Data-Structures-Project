package game;

import game.Interfaces.IMap;

public class Map implements IMap {
    private static Map instance = null;

    private Map() {

    }

    public static Map getInstance() {
        if (Map.instance == null) {
            Map.instance = new Map();
        }
        return Map.instance;
    }

    @Override
    public void generate_map() {
        // TODO Auto-generated method stub

    }

    @Override
    public void load_map() {
        // TODO Auto-generated method stub

    }

    @Override
    public void save_map(String name) {
        // TODO Auto-generated method stub

    }

}
