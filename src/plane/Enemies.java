package plane;

import javax.swing.*;
import java.awt.*;

public class Enemies {

    // 敌机数量
    private final int numOfEnemy = 3;
    private EnemyPlane[] enemies;

    public Enemies() {
        enemies = new EnemyPlane[numOfEnemy];
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i] = new EnemyPlane();
        }
    }

    public void attack() {
        int i;
        for (i = 0; i < numOfEnemy; i++) {
            if (!enemies[i].isAlive())
                break;
        }
        if (i < numOfEnemy)
            enemies[i].show();
    }

    public void update() {
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i].update();
        }
    }

    public void draw(Graphics g, JPanel jp) {
        // 让敌机绘制自己
        for (int i = 0; i < numOfEnemy; i++) {
            enemies[i].draw(g, jp);
        }
    }
}
