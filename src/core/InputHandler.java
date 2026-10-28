package core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;

public class InputHandler extends MouseAdapter implements KeyListener {
    public int targetX = 100;
    public int targetY = 250;
    public int clickX = -1;
    public int clickY = -1;

    public boolean isPaused = false;

    @Override
    public void mousePressed (MouseEvent e) {
        if (isPaused) return;

        // Right mouse click to move main character
        if (SwingUtilities.isRightMouseButton(e)) {
            targetX = e.getX();
            targetY = e.getY();
        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            clickX = e.getX();
            clickY = e.getY();
        }
    }

    @Override
    public void keyPressed (KeyEvent e) {
        // Implement more KeyEvent? -> use switch
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            isPaused = !isPaused;
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {}
    @Override
    public void keyTyped (KeyEvent e) {}
}
