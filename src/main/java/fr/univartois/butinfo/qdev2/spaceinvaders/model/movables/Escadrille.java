package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Escadrille extends AbstractMovable {

    private List<Alien> aliens = new ArrayList<>();

    private Alien alienHit;

    private IAlienMovesStrategy strategy;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected Escadrille(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, IAlienMovesStrategy strategy) {
        super(game, xPosition, yPosition, sprite);
        this.strategy = strategy;
    }

    @Override
    public boolean move(long delta){
        boolean reachLimit = false;
        for(Alien alien : aliens){
            if (!alien.move(delta)) {
                reachLimit = true;
            }
        }
        if (reachLimit) {
            for(Alien alien : aliens){
                update(strategy, alien, true);
            }
        }
        return reachLimit;
    }

    private void update(IAlienMovesStrategy strategy, Alien alien, boolean contactWithBorder) {
        strategy.update(alien, contactWithBorder);
    }

    @Override
    public boolean isCollidingWith(IMovable other){
        for(Alien alien : aliens){
            if (alien.isCollidingWith(other)){
                this.alienHit = alien;
                return true;
            }
        }
        return false;
    }

    @Override
    public void collidedWith(IMovable other) {
        aliens.remove(alienHit);
        alienHit.collidedWith(other);
        this.alienHit = null;
    }

    @Override
    public void collidedWith(Alien alien) {}

    @Override
    public void collidedWith(Shot shot) {}
}
