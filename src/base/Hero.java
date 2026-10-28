package base;

import java.awt.*;

public abstract class Hero extends Entity {
    protected int price;
    protected int level = 1;

    public Hero (int x, int y, int width, int height, int hp, int price, int damage, double cooldown, AttackRange range) {
        super (x, y, width, height, hp, damage, cooldown, range);
        this.price = price;
    }

    public Rectangle getAttackRangeBox() {
        int startX = this.x + this.width;
        if (this.range == AttackRange.MELEE) {
            return new Rectangle (startX, this.y, CELL_WIDTH, this.height);
        } else {
            return new Rectangle (startX, this.y, SCREEN_WIDTH, this.height);
        }
    }

    public void upgradeLevel() {
        //example
        this.level++;
        this.maxHp += 15;
        this.hp = this.maxHp;
        this.damage += 5;
    }

    public int getPrice() { return price; }
    public int getLevel() { return level; }
}
