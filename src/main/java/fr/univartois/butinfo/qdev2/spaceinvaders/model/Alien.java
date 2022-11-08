package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shot;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Alien  extends AbstractMovable{


    /*
    * Attribut pour l'alien qui tire au niveau 1
    * (ne peut pas tirer).
     */
    private IStrategy strategyLevel1;

    /*
     * Attribut pour l'alien qui tire au niveau 2

     */
    private IStrategyLevel2 strategyLevel2;


    /*
     * Attribut pour l'alien qui tire au niveau 2

     */
    private IStrategyLevel3 strategyLevel3;


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
        this.setHorizontalSpeed(75);
        this.setVerticalSpeed(1


    @Override
    public boolean move(long delta) {

        if(!super.move(delta)) {
            setVerticalSpeed(getVerticalSpeed() * 1.02);
            this.setHorizontalSpeed(-getHorizontalSpeed());
            return false;
        }

        if (getY()+this.getHeight() >= game.getBottomLimit()) {
            game.alienReachedPlanet();
            return false;
        }
        return true;
    }

    @Override
    public void collidedWith(IMovable other) { return ; }

    @Override
    public void collidedWith(Alien alien) { return ; }

    @Override
    public void collidedWith(Shot shot) { return ; }


}
