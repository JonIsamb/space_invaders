package fr.univartois.butinfo.qdev2.spaceinvaders.model;

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




}
