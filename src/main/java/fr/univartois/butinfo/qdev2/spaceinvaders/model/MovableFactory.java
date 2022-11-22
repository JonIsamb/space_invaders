/**
 * Ce fichier fait partie du projet : projet-2022-2023.
 *
 * (c) 2022 paul.sagot
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Alien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Escadrille;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.Bonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Spaceship;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusLife;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.AlienMoves4Strategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.List;

/**
 * Le type MovableFactory
 *
 * @author paul.sagot
 *
 * @version 0.1.0
 */
public class MovableFactory implements IMovableFactory{
    
    ISpriteStore spriteStore;

    IStrategyShot strategy;
    SpaceInvadersGame game;

    ShotLevel1 shotLevel1;

    ShotLevel2 shotLevel2;


    ShotLevel3 shotLevel3;


    
    /**
     * Crée une nouvelle instance de MovableFactory.
     */
    public MovableFactory() { /* TODO document why this constructor is empty */ }



    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        this.game = game;
    }




    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un alien.
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return L'alien qui a été créé.
     */

    @Override
    public IMovable createAlien(int x, int y, IAlienMovesStrategy strategy) {
        return new LifeDecorator(
                new Alien(game, x, y, spriteStore.getSprite("alien"), strategy, new ShotLevel3()),
                new SimpleIntegerProperty(2));
    }


    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un vaisseau (allié).
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return Le vaisseau qui a été créé.
     */
    @Override
    public IMovable createShip(int x, int y) {
        return new Spaceship(game, x, y, spriteStore.getSprite("ship"));
    }

    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un tir.
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return Le tir qui a été créé.
     */
    @Override
    public IMovable createShot(int x, int y) {
        return new Shot(game, x, y,spriteStore.getSprite("shot"),-300);
    }
    @Override
    public IMovable createAlienShot(int x, int y) {
        return new Shot(game, x, y,spriteStore.getSprite("shot"),300);
    }

    public IMovable createBonus(int x, int y) {
        Bonus bonus = new BonusLife(game, x, y, spriteStore.getSprite("bonus-invulnerable"));
        return bonus;
    }
}

