package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.moves;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

public interface IAlienMovesStrategy {
    void update(IMovable alien, boolean contactWithBorder);
}
