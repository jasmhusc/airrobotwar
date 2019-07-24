package bullet;

import resource.Modual;
import resource.Resource;

import javax.swing.*;
import java.awt.*;

public class Bullet extends Modual {
    public Bullet() {
        super(30, 28, 20);
    }

    @Override
    public void show(int planex, int planey) {
        alive = true;
        modualX = planex;
        modualY = planey - picHeight;
    }

    @Override
    public void update() {
        if (alive) {
            modualY -= modualstep;
            if (modualY < 0) {
                alive = false;
            }
        }
    }

    @Override
    public void draw(Graphics g, JPanel jp) {
        if (alive) {
            g.drawImage(Resource.bullet, modualX, modualY, jp);
        }
    }
}


