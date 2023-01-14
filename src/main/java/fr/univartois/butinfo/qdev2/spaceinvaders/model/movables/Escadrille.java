package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Escadrille extends AbstractMovable {

    private List<IMovable> aliens = new ArrayList<>();

    private IMovable alienHit;

    private IAlienMovesStrategy strategy;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param strategy  La stratégie de déplacement de l'escadrille
     */
    public Escadrille(SpaceInvadersGame game, IAlienMovesStrategy strategy, Sprite sprite) {
        super(game, 0, 0, sprite);
        this.strategy = strategy;
    }

    public void addAlien(IMovable alien){
        this.aliens.add(alien);
    }

    public List<IMovable> getAliens(){
        return this.aliens;
    }

    @Override
    public boolean move(long delta) {
        boolean contactWithBorder = hasHitBorder(delta);
        if (aliens.size() != 0) {
            for(IMovable alien : aliens) {
                update(strategy, alien, contactWithBorder);
            }
        }
        return contactWithBorder;
    }

    @Override
    public boolean hasHitBorder(long delta){
        for (IMovable alien : aliens) {
            if (alien.hasHitBorder(delta)){
                return true;
            }
        }
        return false;
    }

    private void update(IAlienMovesStrategy strategy, IMovable alien, boolean contactWithBorder) {
        strategy.update(alien, contactWithBorder);
    }

    @Override
    public boolean isCollidingWith(IMovable other){
        boolean isColliding = false;
        if (aliens.size() != 0){
            for(IMovable alien : aliens){
                if (alien.isCollidingWith(other)){
                    this.alienHit = alien;
                    isColliding = true;
                }
            }
        }

        return isColliding;
    }

    @Override
    public void collidedWith(IMovable other) {
        alienHit.collidedWith(other);
    }

    @Override
    public void collidedWith(Alien alien) {
        // Ça ne peut pas arriver
    }

    @Override
    public void collidedWith(Bonus bonus) {
        // Rien ne doit se passer ici
    }

    @Override
    public void collidedWith(Spaceship spaceship) {
        // Ça ne peut pas arriver
    }

    @Override
    public void collidedWith(Shot shot) {
        game.alienIsDead(this.alienHit);
        aliens.remove(this.alienHit);
        this.alienHit.consume();
    }
}
