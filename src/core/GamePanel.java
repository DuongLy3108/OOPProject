package core;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private GameEngine gameEngine;
    private InputHandler inputHandler;

    //Tester
    private double testLeaderX = 100;
    private double testLeaderY = 250;
    private int leaderSize = 50;
    private double testSpeed = 4.0;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        inputHandler = new InputHandler();

        this.addMouseListener(inputHandler);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);

        gameEngine = new GameEngine(this);
    }

    public void startGame() {
        gameEngine.start();
    }

    public void updateLogic() {
        if (inputHandler.isPaused) {
            return;
        }

        double destX = inputHandler.targetX - (leaderSize / 2.0);
        double destY = inputHandler.targetY - (leaderSize / 2.0);

        double dx = destX - testLeaderX;
        double dy = destY - testLeaderY;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > testSpeed) {
            testLeaderX += (dx / distance) * testSpeed;
            testLeaderY += (dy / distance) * testSpeed;
        } else {
            testLeaderX = destX;
            testLeaderY = destY;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(inputHandler.targetX - 3, inputHandler.targetY - 3, 6, 6);

        // Lead Character
        g.setColor(Color.YELLOW);
        g.fillRect((int) testLeaderX, (int) testLeaderY, leaderSize, leaderSize);

        if (inputHandler.isPaused) {
            g.setColor(new Color(255, 182, 193, 150));
            g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40 ));
            g.drawString("GAME PAUSED", 260, 300);
        }
    }
    public InputHandler getInputHandler() {
        return inputHandler;
    }
}
