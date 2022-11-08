package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

public class ShotLevel2 implements IStrategyLevel2
{

    private IMovableFactory movable;
    private SpaceInvadersGame space;

    @Override
    public boolean counterAttackLevel2(IMovable alien) {
        Random r = new Random();
        new Random(r.nextInt(101));
        if (r.nextInt() == 6){
            movable.createShot(alien.getX()+alien.getHeight(), alien.getY()+alien.getHeight());
            return true;
        }else {
            return false;
        }
    }




}
