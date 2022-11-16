package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Alien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shot;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

/**
 * Le type Protection
 *
 * @author paul.sagot
 *
 * @version 0.1.0
 */
public abstract class MovableDecorator implements IMovable{
    protected IMovable protection;

    public MovableDecorator(IMovable protection) {
        this.protection = protection;
    }

    @Override
    public int getWidth() {
        return protection.getWidth();
    }

    @Override
    public int getHeight() {
        return protection.getHeight();
    }

    @Override
    public void setX(int xPosition) {
        protection.setX(xPosition);
    }

    @Override
    public int getX() {
        return protection.getX();
    }

    @Override
    public DoubleProperty getXProperty(){
        return protection.getXProperty();
    }

    @Override
    public void setY(int yPosition) {
        protection.setY(yPosition);
    }

    @Override
    public int getY() {
        return protection.getY();
    }

    @Override
    public DoubleProperty getYProperty() {
        return protection.getYProperty();
    }

    @Override
    public void consume() {
        protection.consume();
    }

    @Override
    public boolean isConsumed() {
        return protection.isConsumed();
    }

    @Override
    public BooleanProperty isConsumedProperty() {
        return protection.isConsumedProperty();
    }

    @Override
    public void setHorizontalSpeed(double speed) {
        protection.setHorizontalSpeed(speed);
    }

    @Override
    public double getHorizontalSpeed() {
        return protection.getHorizontalSpeed();
    }

    @Override
    public void setVerticalSpeed(double speed) {
        protection.setVerticalSpeed(speed);
    }

    @Override
    public double getVerticalSpeed() {
        return protection.getVerticalSpeed();
    }

    @Override
    public boolean move(long timeDelta) {
        return protection.move(timeDelta);
    }

    @Override
    public Sprite getSprite() {
        return protection.getSprite();
    }

    @Override
    public boolean isCollidingWith(IMovable other) {
        return protection.isCollidingWith(other);
    }

    @Override
    public void collidedWith(IMovable other) {
        protection.collidedWith(other);
    }

    @Override
    public void collidedWith(Alien alien) {
        protection.collidedWith(alien);
    }

    @Override
    public void collidedWith(Shot shot) {
        protection.collidedWith(shot);
    }

    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return protection.getSpriteProperty();
    }

    @Override
    public void setSprite(Sprite sprite) {
        protection.setSprite(sprite);
    }

    @Override
    public IMovable self() {
        return protection.self();
    }
}

