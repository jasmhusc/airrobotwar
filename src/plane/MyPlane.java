package plane;

import resource.Modual;
import resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPlane extends Modual implements KeyListener {
    public MyPlane() {
        super(40, 40, 20);
        show();
    }

    @Override
    public void show() {
        modualX = (320 - picWidth) / 2;
        modualY = 480 - picHeight;
    }

    @Override
    public void draw(Graphics g, JPanel jp) {
        g.drawImage(Resource.plane, modualX, modualY, jp);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            if (modualY != 0) {
                modualY -= modualstep;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (modualY != 480 - picHeight) {
                modualY += modualstep;
            }
        } else if (key == KeyEvent.VK_LEFT) {
            if (modualX != 0) {
                modualX -= modualstep;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (modualX != 320 - picWidth) {
                modualX += modualstep;
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
