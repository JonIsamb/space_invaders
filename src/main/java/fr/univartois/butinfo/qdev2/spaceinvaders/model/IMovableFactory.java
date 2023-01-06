/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves.IAlienMovesStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * L'interface {@link IMovableFactory} permet de créer différentes instances de
 * {@link IMovable}.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public interface IMovableFactory {

    /**
     * Modifie l'instance de {@link ISpriteStore} fournissant les {@link Sprite} pour les
     * objets à créer.
     *
     * @param spriteStore L'instance de {@link ISpriteStore} fournissant les {@link Sprite}
     *        pour les objets à créer.
     */
    void setSpriteStore(ISpriteStore spriteStore);

    /**
     * Modifie le jeu dans lequel les objets sont créés.
     *
     * @param game Le jeu dans lequel les objets sont créés.
     */
    void setGame(SpaceInvadersGame game);

    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un alien.
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return L'alien qui a été créé.
     */
    IMovable createAlien(int x, int y);

    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un vaisseau (allié).
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return Le vaisseau qui a été créé.
     */
    IMovable createShip(int x, int y);

    IMovable createBonus(int x, int y);

    /**
     * Crée un nouvel objet pouvant se déplacer et représentant un tir.
     *
     * @param x La position initiale de l'objet en x.
     * @param y La position initiale de l'objet en y.
     *
     * @return Le tir qui a été créé.
     */
    IMovable createShot(int x, int y);

    IMovable createAlienShot(int x, int y);
    IMovable createWall(int x, int y);

}
