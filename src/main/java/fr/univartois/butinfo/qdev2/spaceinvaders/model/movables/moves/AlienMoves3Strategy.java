package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

import java.util.Random;

public class AlienMoves3Strategy implements IAlienMovesStrategy {
    private final Random randomGenerator = new Random();
    @Override
    public void update(IMovable alien, boolean contactWithBorder) {
        if (contactWithBorder){
            alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
        } else {
            if(randomGenerator.nextInt(1080)<10) {
                alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
            }
        }
    }
}
