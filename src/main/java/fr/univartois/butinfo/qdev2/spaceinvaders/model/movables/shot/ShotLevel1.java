package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.shot;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IStrategyShot;

public class ShotLevel1 implements IStrategyShot
{

    @Override
    public boolean counterAttack(IMovable alien) {
        return false;
    }

    @Override
    public void switchCurrent() {
        // Ne fait rien
        // Uniquement utile pour le composite
    }


}
