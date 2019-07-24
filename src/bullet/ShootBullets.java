package bullet;

import plane.MyPlane;

import javax.swing.*;
import java.awt.*;

public class ShootBullets {
    public final int numOfBullets = 15;
    public Bullet[] bullets;
    private int shootInterval = 400;

    public ShootBullets() {
        bullets = new Bullet[numOfBullets];
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i] = new Bullet();
        }
    }

    public void shoot(MyPlane p) {
        // 每隔400ms让所有子弹中已经出边界的重新发射一颗
        if (shootInterval == 400) {
            int i;
            for (i = 0; i < numOfBullets; i++) {
                if (!bullets[i].isAlive())
                    break;
            }
            bullets[i].show(p.getModualX(), p.getModualY());
            shootInterval = 0;
        } else {
            shootInterval += 200;
        }
    }

    public void update() {
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i].update();
        }
    }

    public void draw(Graphics g, JPanel jp) {
        // 让子弹吧自己画出来
        for (int i = 0; i < numOfBullets; i++) {
            bullets[i].draw(g, jp);
        }
    }
}
