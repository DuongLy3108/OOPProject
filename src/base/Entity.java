package base;

import interfaces.IAttacker;
import interfaces.IDamageable;

public abstract class Entity extends GameObject implements IDamageable {

    public enum AttackRange {
        MELEE,
        RANGE
    }

    //Example CELL_SIZE
    public static final int CELL_WIDTH = 80;
    public static final int SCREEN_WIDTH = 800;

    protected int hp;
    protected int maxHp;
    protected int damage;
    protected double cooldown;
    protected int attackTimer;
    protected AttackRange range;

    public Entity (int x, int y, int width, int height, int hp, int damage, double cooldown, AttackRange range) {
        super (x, y, width, height);
        this.hp = hp;
        this.maxHp = hp;
        this.damage = damage;
        this.cooldown = cooldown;
        this.attackTimer = 0;
        this.range = range;
    }

    @Override
    public void takeDamage (int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    public void attack (IDamageable target) {
        target.takeDamage(this.damage);
    }

    public boolean canAttack() {
        return attackTimer >= cooldown;
    }

    public void resetAttackTimer() {
        this.attackTimer = 0;
    }

    public void setHp (int hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getDamage() { return damage; }
    public double getCooldown() { return cooldown; }
    public AttackRange getRange() { return range; }
}
