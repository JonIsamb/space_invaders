/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 paul.sagot
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;

/**
 * Le type MovableFactory
 *
 * @author paul.sagot
 *
 * @version 0.1.0
 */
public class MovableFactory implements IMovableFactory{
    
    ISpriteStore SpriteStore;
    
    SpaceInvadersGame game;
    
    /**
     * Crée une nouvelle instance de MovableFactory.
     */
    public MovableFactory() {}

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.SpriteStore = spriteStore;
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
    public IMovable createAlien(int x, int y) {
        Alien alien = new Alien(game, x, y, SpriteStore);
        return alien;
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
        Ship ship = new Ship(game, x, y, SpriteStore);
        return ship;
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
        Shot shot = new Shot(game, x, y, SpriteStore);
        return shot;
    }
}

