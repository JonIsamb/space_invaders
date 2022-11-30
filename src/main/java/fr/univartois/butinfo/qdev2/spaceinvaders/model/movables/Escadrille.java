package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.scene.image.Image;

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

    public void addAliens(List<IMovable> aliens){
        this.aliens.addAll(aliens);
    }

    @Override
    public boolean move(long delta) {
        System.out.println("move de l'escadrille");
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
        if (aliens.size() != 0){
            for(IMovable alien : aliens){
                if (alien.isCollidingWith(other)){
                    this.alienHit = alien;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void collidedWith(IMovable other) {
        alienHit.collidedWith(other);
        game.alienIsDead(alienHit);
        aliens.remove(alienHit);
        this.alienHit = null;
    }

    @Override
    public void collidedWith(Alien alien) {}

    @Override
    public void collidedWith(Bonus bonus) {}

    @Override
    public void collidedWith(Spaceship spaceship) {}

    @Override
    public void collidedWith(Shot shot) {}
}
