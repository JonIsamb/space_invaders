package fr.univartois.butinfo.qdev2.spaceinvaders.model;

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
}
