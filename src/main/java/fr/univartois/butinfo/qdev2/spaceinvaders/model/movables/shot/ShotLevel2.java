package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.shot;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IStrategyShot;

import java.util.Random;

public class ShotLevel2 implements IStrategyShot
{

    @Override
    public boolean counterAttack(IMovable alien) {
        Random r = new Random();
        if (r.nextInt(1000) ==1 ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void switchCurrent() {
        // Ne fait rien
        // Uniquement utile pour le composite
    }


}
