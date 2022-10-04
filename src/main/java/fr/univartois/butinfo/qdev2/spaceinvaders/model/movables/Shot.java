package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.Alien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Shot extends AbstractMovable {

    public Shot(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite){
        super(game, xPosition, yPosition, sprite);
        this.setVerticalSpeed(-300);
    }
    @Override
    public void collidedWith(IMovable other) {
        game.removeMovable(this);
    }

    @Override
    public void collidedWith(Alien alien) {
        game.alienIsDead(alien);
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
