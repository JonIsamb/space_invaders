package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Alien  extends AbstractMovable{
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected Alien(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }

    @Override
    public void setHorizontalSpeed(double speed) {
        speed = 75;
    }

    @Override
    public void setVerticalSpeed(double speed) {
        speed = 1;
    }

    @Override
    public boolean move(long delta) {

        if(!super.move(delta)) {
            setVerticalSpeed(getVerticalSpeed() * 1.02);
            return false;
        }

        if (game.getBottomLimit() == getY()) {
            game.alienReachedPlanet();
            return false;
        }
        return true;
    }

    @Override
    public void collidedWith(IMovable other) {
        //todo adaopdja
    }


}
