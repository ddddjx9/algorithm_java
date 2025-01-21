package otherTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class HeartAnimation extends JPanel {
    private final int WIDTH = 800;  // 面板的宽度
    private final int HEIGHT = 800; // 面板的高度
    private double scale = 1.0;  // 用于缩放心形的比例
    private final double MIN_SCALE = 0.8;  // 最小缩放比例
    private final double MAX_SCALE = 1.2;  // 最大缩放比例
    private final double SCALE_STEP = 0.01;  // 缩放步长
    private boolean growing = true;  // 用于控制缩放的方向

    public HeartAnimation() {
        Timer timer = new Timer(30, e -> {
            // 每 30 毫秒更新一次缩放比例
            updateScale();
            repaint();
        });
        timer.start();
    }

    private void updateScale() {
        if (growing) {
            scale += SCALE_STEP;
            if (scale >= MAX_SCALE) {
                growing = false;
            }
        } else {
            scale -= SCALE_STEP;
            if (scale <= MIN_SCALE) {
                growing = true;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 透明背景，实现若隐若现的效果
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (Math.random() * 0.5 + 0.3)));
        // 平移到面板中心
        g2d.translate(WIDTH / 2, HEIGHT / 2);
        // 缩放
        g2d.scale(scale, scale);
        // 绘制心形
        Path2D.Double heart = new Path2D.Double();
        heart.moveTo(0, -30);
        for (double theta = 0; theta <= 2 * Math.PI; theta += 0.01) {
            double r = 16 * Math.pow(Math.sin(theta), 3);
            double x = 13 * Math.cos(theta) - 5 * Math.cos(2 * theta) - 2 * Math.cos(3 * theta) - Math.cos(4 * theta);
            double y = 13 * Math.sin(theta) - 5 * Math.sin(2 * theta) - 2 * Math.sin(3 * theta) - Math.sin(4 * theta);
            heart.lineTo(x, -y);
        }
        heart.closePath();
        g2d.setColor(Color.RED);
        g2d.fill(heart);
        // 重置变换
        g2d.scale(1 / scale, 1 / scale);
        g2d.translate(-WIDTH / 2, -HEIGHT / 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.add(new HeartAnimation());
        frame.setVisible(true);
    }
}