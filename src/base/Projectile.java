package base;

import interfaces.IMoveable;

public abstract class Projectile extends GameObject implements IMoveable {
    protected int damage;
    protected int speed;
    protected boolean active = true;

    public Projectile (int x, int y, int width, int height, int speed, int damage) {
        super (x, y, width, height);
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    public void move() {
        this.x += speed;
    }

    public void deactivate() { this.active = false; }

    public int getDamage() { return damage; }
    public boolean isActive() { return active; }
}
