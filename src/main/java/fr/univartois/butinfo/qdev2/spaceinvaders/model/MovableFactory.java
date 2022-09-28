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
    
    SpaceInvadersGame Game;

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        // TODO Auto-generated method stub.
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        // TODO Auto-generated method stub.
        
    }
}

