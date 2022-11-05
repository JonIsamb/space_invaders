package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Alien;

import java.util.Random;

public class AlienMoves3Strategy implements IAlienMovesStrategy {
    @Override
    public void update(Alien alien, boolean contactWithBorder) {
        if (contactWithBorder){
            alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
        } else {
            double random = new Random().nextInt(1080);
            if(random<10) {
                alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
            }
        }
    }
}
