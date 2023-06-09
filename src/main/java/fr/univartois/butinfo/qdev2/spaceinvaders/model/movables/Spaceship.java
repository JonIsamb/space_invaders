package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Spaceship extends AbstractMovable {
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Spaceship(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }

    @Override
    public void collidedWith(IMovable other) {
        other.collidedWith(this);
    }

    @Override
    public void collidedWith(Alien alien) {
        game.playerIsDead();
    }

    @Override
    public void collidedWith(Bonus bonus) {
        // Géré dans le collideWith entre le bonus et le vaisseau
    }

    @Override
    public void collidedWith(Spaceship spaceship) {
        // Ce cas n'arrivera jamais (jeu non multi joueur)
    }

    @Override
    public void collidedWith(Shot shot) {
        game.removeMovable(shot);
    }


}
