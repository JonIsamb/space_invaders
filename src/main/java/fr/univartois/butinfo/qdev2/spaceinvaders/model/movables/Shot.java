package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Shot extends AbstractMovable {

    public Shot(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, int speed){
        super(game, xPosition, yPosition, sprite);
        this.setVerticalSpeed(speed);

    }
    @Override
    public void collidedWith(IMovable other) {
        other.collidedWith(this);
    }

    @Override
    public void collidedWith(Alien alien) {
        game.removeMovable(this);
    }

    @Override
    public void collidedWith(Bonus bonus) {

    }

    @Override
    public void collidedWith(Spaceship spaceship) {
        game.reducePlayerLife();
    }

    @Override
    public void collidedWith(Shot shot) {
        game.removeMovable(this);
        game.removeMovable(shot);
    }

    @Override
    public boolean move(long delta) {
        if (super.move(delta)) {
            return true;
        } else {
            game.removeMovable(this);
            return false;
        }
    }
}
