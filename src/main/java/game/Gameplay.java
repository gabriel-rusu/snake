package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];
    private int[] appleXpos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
            475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
    private int[] appleYpos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
            525, 550, 575, 600, 625 };
    private int lengthOfSnake = 3;
    private int score = 0;
    private int moves = 0;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon titleImage;
    private ImageIcon snakeImage;
    private ImageIcon rightMouth;
    private ImageIcon upMouth;
    private ImageIcon downMouth;
    private ImageIcon leftMouth;
    private ImageIcon appleIcon;

    private Timer timer;
    private int delay = 100;
    private Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakeXLength[2] = 50;
            snakeXLength[1] = 75;
            snakeXLength[0] = 100;

            snakeYLength[2] = 100;
            snakeYLength[1] = 100;
            snakeYLength[0] = 100;
        }

        // draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        // draw title image
        titleImage = new ImageIcon(getClass().getResource("../images/TitluSnake.png").getPath());
        titleImage.paintIcon(this, g, 25, 11);

        // draw border for gameplay
        g.setColor(Color.white);
        g.drawRect(24, 74, 851, 577);

        // draw background for the gameplay
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        // draw scores
        g.setColor(Color.white);
        g.setFont(new Font("Clibri", Font.PLAIN, 14));
        g.drawString("Scores:" + score, 780, 30);

        // draw length
        g.setColor(Color.white);
        g.setFont(new Font("Clibri", Font.PLAIN, 14));
        g.drawString("Length:" + lengthOfSnake, 780, 50);

        rightMouth = new ImageIcon(getResourceFullPath("../images/RightMouth.png"));
        rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);

        for (int i = 0; i < lengthOfSnake; i++) {
            if (i == 0 && right) {
                rightMouth = new ImageIcon(getResourceFullPath("../images/RightMouth.png"));
                rightMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && left) {
                leftMouth = new ImageIcon(getResourceFullPath("../images/LeftMouth.png"));
                leftMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && up) {
                upMouth = new ImageIcon(getResourceFullPath("../images/UpMouth.png"));
                upMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i == 0 && down) {
                downMouth = new ImageIcon(getResourceFullPath("../images/DownMouth.png"));
                downMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if (i != 0) {
                snakeImage = new ImageIcon(getResourceFullPath("../images/SnakeImage.png"));
                snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
        }

        appleIcon = new ImageIcon(getResourceFullPath("../images/Apple.png"));

        if ((appleXpos[xpos] == snakeXLength[0] && appleYpos[ypos] == snakeYLength[0])) {
            score++;
            lengthOfSnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        appleIcon.paintIcon(this, g, appleXpos[xpos], appleYpos[ypos]);

        for (int i = 1; i < lengthOfSnake; i++) {
            if (snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0]) {
                left = false;
                up = false;
                right = false;
                down = false;

                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Space to RESTART", 350, 340);
            }
        }
        g.dispose();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            moves = 0;
            score = 0;
            lengthOfSnake = 3;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                right = true;
                left = false;
            }
            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                down = true;
                up = false;
            }
            left = false;
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public boolean keyDown(Event evt, int key) {
        return super.keyDown(evt, key);
    }

    @Override
    public boolean keyUp(Event evt, int key) {
        return super.keyUp(evt, key);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (right) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYLength[i + 1] = snakeYLength[i];
                if (i == 0) {
                    snakeXLength[i] = snakeXLength[i] + 25;
                } else {
                    snakeXLength[i] = snakeXLength[i - 1];
                }
                if (snakeXLength[i] > 850) {
                    snakeXLength[i] = 25;
                }
            }
            repaint();
        }
        if (left) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeYLength[i + 1] = snakeYLength[i];
                if (i == 0) {
                    snakeXLength[i] = snakeXLength[i] - 25;
                } else {
                    snakeXLength[i] = snakeXLength[i - 1];
                }
                if (snakeXLength[i] < 25) {
                    snakeXLength[i] = 850;
                }
            }
            repaint();
        }
        if (up) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXLength[i + 1] = snakeXLength[i];
                if (i == 0) {
                    snakeYLength[i] = snakeYLength[i] - 25;
                } else {
                    snakeYLength[i] = snakeYLength[i - 1];
                }
                if (snakeYLength[i] < 75) {
                    snakeYLength[i] = 625;
                }
            }
            repaint();
        }
        if (down) {
            for (int i = lengthOfSnake - 1; i >= 0; i--) {
                snakeXLength[i + 1] = snakeXLength[i];
                if (i == 0) {
                    snakeYLength[i] = snakeYLength[i] + 25;
                } else {
                    snakeYLength[i] = snakeYLength[i - 1];
                }
                if (snakeYLength[i] > 625) {
                    snakeYLength[i] = 75;
                }
            }
            repaint();
        }
    }

    private String getResourceFullPath(String relativePath) {
        return getClass().getResource(relativePath).getPath();
    }

}