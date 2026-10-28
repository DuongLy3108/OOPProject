package base;

import interfaces.IMoveable;

import java.awt.*;

public abstract class Monster extends Entity implements IMoveable {
    protected int speed;
    protected int goldReward;
    protected boolean isManaCarrier;

    public Monster (int x, int y, int width, int height, int hp, int damage, double cooldown, AttackRange range, int speed, int goldReward, boolean isManaCarrier) {
        super (x, y, width, height, hp, damage, cooldown, range);
        this.speed = speed;
        this.goldReward = goldReward;
        this.isManaCarrier = isManaCarrier;
    }

    @Override
    public void move() {
        this.x -= speed;
    }

    public Rectangle getAttackRangeBox() {
        if (this.range == AttackRange.MELEE) {
            return new Rectangle (this.x - CELL_WIDTH, this.y, CELL_WIDTH, this.height);
        } else {
            return new Rectangle (0, this.y, this.x, this.height);
        }
    }

    public void setSpeed (int speed) { this.speed = speed; }
    public int getSpeed() { return speed; }
    public int getGoldReward() { return goldReward; }
    public boolean isManaCarrier() { return isManaCarrier; }
}
