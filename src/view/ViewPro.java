package view;

import bullet.ShootBullets;
import plane.Enemies;
import plane.MyPlane;
import resource.Resource;

import javax.swing.*;
import java.awt.*;

public class ViewPro extends JPanel implements Runnable {
    public static final int width = 320;
    public static final int height = 480;
    private ShootBullets bullets;
    private Enemies enemies;
    private MyPlane myPlane;

    // 背景图的循环切换
    private final int imgStep = 10;
    private int img0Y = 0;
    private int img1Y = -1 * height;

    public ViewPro() {
        bullets = new ShootBullets();
        enemies = new Enemies();
        myPlane = new MyPlane();
        setPreferredSize(new Dimension(width, height));
        // image1放在初始位置，image0放在其上方不可见位置
        new Thread(this).start();
        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // paint()不是直接调用，而通过repaint()调用
                repaint();
                update();
                bullets.shoot(myPlane);
                enemies.attack();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        // 改变两张图片位置
        if (img0Y == height) {
            img0Y = -1 * height;
        } else {
            img0Y += imgStep;
        }
        if (img1Y == height) {
            img1Y = -1 * height;
        } else {
            img1Y += imgStep;
        }
        bullets.update();
        enemies.update();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Resource.image1, 0, img1Y, this);
        g.drawImage(Resource.image0, 0, img0Y, this);
        bullets.draw(g, this);
        enemies.draw(g, this);
        myPlane.draw(g, this);
    }
}
