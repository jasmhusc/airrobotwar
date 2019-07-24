package airrobotwar;

import view.ViewPro;

import javax.swing.*;

public class Game extends JFrame {
    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        setTitle("Space War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        ViewPro view = new ViewPro();
//        View view = new View();
        getContentPane().add(view);
        pack();
        // 必须让Jpanel获得focus
        view.requestFocusInWindow();
        setVisible(true);
    }
}
