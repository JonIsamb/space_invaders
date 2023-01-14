package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.shot;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IStrategyShot;

import java.util.Random;

public class ShotLevel3 implements IStrategyShot
{

    private IMovableFactory movable;

    protected static int CONSTANTE = 9950;

    @Override
    public boolean counterAttack(IMovable alien) {
        Random r = new Random();
        if (r.nextInt(10000)>CONSTANTE ){
            return true;
        }
            return false;
    }

    @Override
    public void switchCurrent() {
        // Ne fait rien
        // Uniquement utile pour le composite
    }
}
