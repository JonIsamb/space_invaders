package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Spaceship;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import javafx.beans.property.IntegerProperty;


/**
 * Le type PointVie
 *
 * @author paul.sagot
 *
 * @version 0.1.0
 */
public class LifeDecorator extends MovableDecorator{
    private IntegerProperty life;

    public LifeDecorator(IMovable movable, IntegerProperty life) {
        super(movable);
        this.life=life;
    }

    /**
     * Donne l'attribut life de cette instance de PointVieAliens.
     *
     * @return L'attribut life de cette instance de PointVieAliens.
     */
    public IntegerProperty getLife() {
        return life;
    }

    @Override
    public boolean hasHitBorder(long delta) {
        return !super.move(delta);
    }

    @Override
    public void collidedWith(Bonus bonus) {

    }

    @Override
    public void collidedWith(Spaceship spaceship) {

    }

    @Override
    public void collidedWith(Shot shot){
        life.setValue(life.get()-1);
        if (life.get() == 0) {
            super.collidedWith(shot);
        } else {
            //faire methode pour enlever l'autre element en contact
        }
    }

}

