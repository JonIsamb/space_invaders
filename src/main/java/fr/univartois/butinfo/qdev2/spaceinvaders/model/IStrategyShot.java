package fr.univartois.butinfo.qdev2.spaceinvaders.model;
/*
*Interface a implementer pour que l'alien réplique aussi
*
* @author Gregoire Legrand
 */
public interface IStrategyShot {

    /*
    * methode qui servira a repliquer sur le joueur
    */
    boolean counterAttack(IMovable alien);

    void switchCurrent();

}
