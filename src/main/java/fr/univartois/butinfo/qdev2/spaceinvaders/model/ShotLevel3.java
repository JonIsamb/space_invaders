package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

public class ShotLevel3 implements IStrategy
{

    private IMovableFactory movable;

    protected static int CONSTANTE = 75;

    @Override
    public boolean counterAttack(IMovable alien) {
        Random r = new Random();
        new Random(r.nextInt(101));
        if (r.nextInt()>CONSTANTE ){
            movable.createShot(alien.getX()+ alien.getHeight(), alien.getY()+ alien.getHeight());
            return true;
        }
            return false;
    }
}
