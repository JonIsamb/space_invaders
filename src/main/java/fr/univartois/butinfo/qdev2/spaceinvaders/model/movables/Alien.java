package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.AlienMoves1Strategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Alien  extends AbstractMovable{
    public IAlienMovesStrategy strategy;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Alien(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(75);
        this.setVerticalSpeed(50);
        this.strategy = new AlienMoves1Strategy();
    }


    public boolean move(long delta, IAlienMovesStrategy strategy) {

        if(!super.move(delta)) {
            if (getY()+this.getHeight() >= game.getBottomLimit()) {
                game.alienReachedPlanet();
            }else{
                update(strategy, this);
            }
            return false;
        }

        return true;
    }

    private void update(IAlienMovesStrategy strategy, Alien alien) {
        strategy.update(alien);
    }

    @Override
    public void collidedWith(IMovable other) { other.collidedWith(this); }

    @Override
    public void collidedWith(Alien alien) { return ; }

    @Override
    public void collidedWith(Shot shot) { return ; }


}
