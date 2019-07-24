package view;

import bullet.Bullet;
import plane.EnemyPlane;
import resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 Jpanel里要放2张图片：
    一张image1默认显示为初始背景，一张image0放在背景上方
    两张图片循环更替，表示飞机在前进
  */
public class View extends JPanel implements Runnable, KeyListener {
    // Jpanel大小
    private int width = 320;
    private int height = 480;
    // 背景图的循环切换
    private final int imgStep = 10;
    private int img0Y = 0;
    private int img1Y = -1 * height;
    // 飞机的摆放
    private final int planeStep = 20;
    private int picWidth = 40;
    private int picHeidht = 40;
    private int planeX = (width - picWidth) / 2;
    private int planeY = height - picHeidht;
    // 子弹数量
    private final int numOfBullets = 15;
    private Bullet[] bullets;
    private int shootInterval = 400;
    // 敌机数量
    private final int numOfEnemy = 6;
    private EnemyPlane[] enemies;

    public View() {
        // 子弹初始化
        bullets = new Bullet[numOfBullets];
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i] = new Bullet();
        }
        // 敌机初始化
        enemies = new EnemyPlane[numOfEnemy];
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i] = new EnemyPlane();
        }
        setPreferredSize(new Dimension(width, height));
        // image1放在初始位置，image0放在其上方不可见位置
        new Thread(this).start();
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // paint()不是直接调用，而通过repaint()调用
                repaint();
                step();
                shootBullets();
                updateEnemy();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void step() {
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

        // 让子弹update一下
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i].update();
        }
        // 让敌机update一下
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i].update();
        }
    }

    private void shootBullets() {
        // 每隔400ms让所有子弹中已经出边界的重新发射一颗
        if (shootInterval == 400) {
            int i;
            for (i = 0; i < numOfBullets; i++) {
                if (!bullets[i].isAlive())
                    break;
            }
            bullets[i].show(planeX, planeY);
            shootInterval = 0;
        } else {
            shootInterval += 200;
        }
    }

    private void updateEnemy() {
        // 敌机不在屏幕内表示死亡
        int i;
        for (i = 0; i < numOfEnemy; i++) {
            if (!enemies[i].isAlive())
                break;
        }
        if (i < numOfEnemy)
            enemies[i].show();
    }

    @Override
    public void paint(Graphics g) {
        // 先画背景，在画其他组件
        g.drawImage(Resource.image1, 0, img1Y, this);
        g.drawImage(Resource.image0, 0, img0Y, this);
        g.drawImage(Resource.plane, planeX, planeY, this);
        // 让子弹吧自己画出来
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i].draw(g, this);
        }
        // 让敌机绘制自己
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i].draw(g, this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            if (planeY != 0) {
                planeY -= planeStep;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (planeY != height - picHeidht) {
                planeY += planeStep;
            }
        } else if (key == KeyEvent.VK_LEFT) {
            if (planeX != 0) {
                planeX -= planeStep;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (planeX != width - picWidth) {
                planeX += planeStep;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
