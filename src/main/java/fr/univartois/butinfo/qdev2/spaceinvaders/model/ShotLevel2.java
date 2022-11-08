package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

public class ShotLevel2 implements IStrategy
{

    private IMovableFactory movable;
    private SpaceInvadersGame space;

    @Override
    public boolean counterAttack(IMovable alien) {
        Random r = new Random();
        new Random(r.nextInt(101));
        if (r.nextInt() == 6){
            return true;
        }else {
            return false;
        }
    }




}
