package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

public class AlienMoves2Strategy implements IAlienMovesStrategy{

    @Override
    public void update(IMovable alien, boolean contactWithBorder) {
        if (contactWithBorder){
            alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
        } else {
            alien.setVerticalSpeed(alien.getVerticalSpeed()*1.001);
            alien.setHorizontalSpeed(alien.getHorizontalSpeed()*1.001);

        }
    }
}
