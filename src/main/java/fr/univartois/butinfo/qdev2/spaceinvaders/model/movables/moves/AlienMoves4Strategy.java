package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

public class AlienMoves4Strategy implements IAlienMovesStrategy{
    @Override
    public void update(IMovable alien, boolean contactWithBorder) {
        if (contactWithBorder){
            alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
        } else {
            if (alien.getHorizontalSpeed() > 0){
                alien.setHorizontalSpeed(f(alien.getX()/10.) * 5);
            } else {
                alien.setHorizontalSpeed(- (f(alien.getX()/10.) * 5));
            }
        }
    }

    public double f(double x){
        return -(x*x/50) + (2.2*x) + 5;
    }
}
