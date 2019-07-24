package plane;

import resource.Modual;
import resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyPlane extends Modual {

    public EnemyPlane() {
        super(40, 40, 20);
    }

    @Override
    public void show() {
        alive = true;
        modualX = new Random().nextInt(320 - picWidth);
        modualY = -1 * (40 + new Random().nextInt(480 - picHeight));
    }

    @Override
    public void update() {
        if (isAlive()) {
            modualY += modualstep;
            if (modualY > 480) {
                alive = false;
            }
        }
    }

    @Override
    public void draw(Graphics g, JPanel jp) {
        if (isAlive()) {
            g.drawImage(Resource.enemy, modualX, modualY, jp);
        }
    }
}
