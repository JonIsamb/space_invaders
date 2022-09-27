package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

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

    }
}
