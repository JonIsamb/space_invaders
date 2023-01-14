package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.*;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Alien extends AbstractMovable{
    private IAlienMovesStrategy strategy;

    private final IStrategyShot strategyShot;



    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Alien(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, IAlienMovesStrategy strategy, IStrategyShot strategyShot) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(200);
        this.setVerticalSpeed(20);
        this.strategy = strategy;
        this.strategyShot = strategyShot;
    }



    @Override
    public boolean move(long delta) {
        if(!super.move(delta)) {
            if (getY()+this.getHeight() >= game.getBottomLimit()) {
                game.alienReachedPlanet();
            }else{
                update(strategy, this, true);
                strategyShot.switchCurrent();
            }
            return false;
        } else {
            update(strategy, this, false);
            strategyShot.counterAttack(this);
            if (strategyShot.counterAttack(this)) {
                game.fireShotAlien(this);
            }
        }
        return true;
    }

    private void update(IAlienMovesStrategy strategy, Alien alien, boolean contactWithBorder) {
        strategy.update(alien, contactWithBorder);
    }

    @Override
    public void collidedWith(IMovable other) {
        other.collidedWith(this);
    }

    @Override
    public void collidedWith(Alien alien) {
        // Rien ne doit se passer ici
    }


    @Override
    public void collidedWith(Bonus bonus) {
        // On ne veut pas qu'il se passe quelque chose ici
    }

    @Override
    public void collidedWith(Spaceship spaceship) {
        // On ne veut pas que cela arrive
    }

    @Override
    public void collidedWith(Shot shot) {
        game.alienIsDead(this);
        game.removeMovable(this);
    }



}
