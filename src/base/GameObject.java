package base;

import interfaces.IRenderable;
import interfaces.IUpdatable;
import java.awt.Rectangle;

public abstract class GameObject implements IUpdatable, IRenderable {
    protected int x, y;
    protected int width, height;

    public GameObject (int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
