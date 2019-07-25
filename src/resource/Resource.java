package resource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
 * 读取图片
 * */
public class Resource {

    public static BufferedImage image0;
    public static BufferedImage image1;
    public static BufferedImage plane;
    public static BufferedImage bullet;
    public static BufferedImage enemy;

    static {
        try {
            image0 = ImageIO.read(new File("src/images/map0.png"));
            image1 = ImageIO.read(new File("src/images/map1.png"));
            plane = ImageIO.read(new File("src/images/Player.png"));
            bullet = ImageIO.read(new File("src/images/bullet.png"));
            enemy = ImageIO.read(new File("src/images/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
