package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.shot;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IStrategyShot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

import java.util.List;
import java.util.Random;

public class ShotComposite implements IStrategyShot {
    List<IStrategyShot> shots;
    IStrategyShot actualShot;
    SpaceInvadersGame game;

    Random randomGenerator;

    public ShotComposite(List<IStrategyShot> shots, IStrategyShot actualShot, SpaceInvadersGame game) {
        this.shots = shots;
        this.actualShot = actualShot;
        this.randomGenerator = new Random();
        this.game = game;
    }

    public void switchCurrent() {
        this.actualShot = this.shots.get(this.randomGenerator.nextInt(0, this.shots.size()));
    }

    @Override
    public boolean counterAttack(IMovable alien) {
        return actualShot.counterAttack(alien);
    }
}
