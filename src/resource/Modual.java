package resource;

import javax.swing.*;
import java.awt.*;

public abstract class Modual {
    // 是否在屏幕中
    protected boolean alive = false;
    // 位置坐标，运动步数
    protected int modualX = 0;
    protected int modualY = 0;
    protected int modualstep;
    // 模型所用图片大小
    protected int picWidth;
    protected int picHeight;

    public Modual(int picw, int picH, int step) {
        picWidth = picw;
        picHeight = picH;
        modualstep = step;
    }

    public int getModualX() {
        return modualX;
    }

    public int getModualY() {
        return modualY;
    }

    public boolean isAlive() {
        return alive;
    }

    public void show() {
    }

    public void show(int x, int y) {
    }

    public void update() {
    }

    public void draw(Graphics g, JPanel jp) {
    }
}
