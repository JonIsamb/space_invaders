package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.wall;

public enum WallStatus {
    UNBROKEN(3),
    BREAKING(2),
    HEAVILY_BROKEN(1),
    BROKEN(0);

    private int life;

    WallStatus(int life) {
        this.life = life;
    }

    public WallStatus damageIt() {
        return switch (this) {
            case UNBROKEN -> BREAKING;
            case BREAKING -> HEAVILY_BROKEN;
            default -> BROKEN;
        };
    }
}
