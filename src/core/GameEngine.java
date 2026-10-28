package core;

public class GameEngine implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;
    private boolean isRunning = false;
    private final int FPS = 60;

    public GameEngine (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void start() {
        if (gameThread == null) {
            isRunning = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public void stop() {
        isRunning = false;
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (isRunning) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                gamePanel.updateLogic();
                gamePanel.repaint();
                delta--;
            }
        }
    }
}
