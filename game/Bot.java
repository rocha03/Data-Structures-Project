package game;

import game.Interfaces.IAlgorithm;
import game.Interfaces.IBot;
import game.Interfaces.IMap;

public class Bot implements IBot {
    private static IMap map;

    private String posicao;
    private IAlgorithm algorithm;

    public Bot(String posicao, IAlgorithm algorithm) {
        this.posicao = posicao;
        this.algorithm = algorithm;
    }

    public static void loadMap() {
        Bot.map = Map.getInstance();
    }

    @Override
    public void movement() {
        // TODO Auto-generated method stub
        
    }
    
}
