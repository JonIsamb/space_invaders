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
public class AlienPlusResistant extends MovableDecorator{
    private IntegerProperty life;

    public AlienPlusResistant(IMovable Alien, IntegerProperty life) {
        super(Alien);
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
    public void collidedWith(Bonus bonus) {

    }

    @Override
    public void collidedWith(Spaceship spaceship) {

    }

    @Override
    public void collidedWith(Shot other){
        life.setValue(life.get()-1);
        if (life.get() == 0) {
            super.collidedWith(other);
        } else {
            other.collidedWith(this);
            //faire methode pour enlever l'autre element en contact
        }
    }

}

