package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.wall;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Alien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Spaceship;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Wall extends AbstractMovable {

    private WallStatus status;

    private int life;

    private Sprite[] sprites;

    private int actualSprite = 0;

    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Wall(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, Sprite[] sprites) {
        super(game, xPosition, yPosition, sprite);
        this.status = WallStatus.UNBROKEN;
        this.life = 3;
        this.sprites = sprites;
    }

    @Override
    public void collidedWith(IMovable other) {
        //other.collidedWith(this);
    }

    @Override
    public void collidedWith(Alien alien) {
        game.alienIsDead(alien);
        game.removeMovable(alien);
    }

    @Override
    public void collidedWith(Bonus bonus) {
        bonus.consume();
    }

    @Override
    public void collidedWith(Spaceship spaceship) {
        this.consume();
    }

    @Override
    public void collidedWith(Shot shot) {

        System.out.println(this.life);
        this.life--;
        System.out.println(this.life);
        if (this.life == 0) {
            this.consume();
        } else {
            //this.status = this.status.damageIt();
            setSprite(sprites[actualSprite]);
            actualSprite += 1;
        }
    }
}
