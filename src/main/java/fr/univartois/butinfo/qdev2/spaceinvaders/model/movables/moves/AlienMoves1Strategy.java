package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Alien;

public class AlienMoves1Strategy implements IAlienMovesStrategy {
    @Override
    public void update(Alien alien, boolean contactWithBorder) {
        if (contactWithBorder){
            alien.setVerticalSpeed(alien.getVerticalSpeed()*1.02);
            alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
        }
    }
}
