import java.awt.*;
import javax.swing.*;

public class Transformations2D extends JPanel {
    // A triangle (3 points)
    private int[][] shape = { {100, 100}, {200, 100}, {150, 200} };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Original Shape (Blue)
        g2d.setColor(Color.BLUE);
        drawShape(g2d, shape);

        // Translation (Red)
        g2d.setColor(Color.RED);
        int[][] translated = translate(shape, 100, 50);
        drawShape(g2d, translated);

        // Rotation (Green)
        g2d.setColor(Color.GREEN);
        int[][] rotated = rotate(shape, 45);
        drawShape(g2d, rotated);

        // Scaling (Magenta)
        g2d.setColor(Color.MAGENTA);
        int[][] scaled = scale(shape, 2, 2);
        drawShape(g2d, scaled);

        // Shearing (Orange)
        g2d.setColor(Color.ORANGE);
        int[][] sheared = shear(shape, 1, 0.5);
        drawShape(g2d, sheared);
    }

    private void drawShape(Graphics2D g2d, int[][] pts) {
        for (int i = 0; i < pts.length; i++) {
            int x1 = pts[i][0];
            int y1 = pts[i][1];
            int x2 = pts[(i + 1) % pts.length][0];
            int y2 = pts[(i + 1) % pts.length][1];
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    // Translation
    private int[][] translate(int[][] pts, int tx, int ty) {
        int[][] result = new int[pts.length][2];
        for (int i = 0; i < pts.length; i++) {
            result[i][0] = pts[i][0] + tx;
            result[i][1] = pts[i][1] + ty;
        }
        return result;
    }

    // Rotation about origin
    private int[][] rotate(int[][] pts, double angleDeg) {
        double angle = Math.toRadians(angleDeg);
        int[][] result = new int[pts.length][2];
        for (int i = 0; i < pts.length; i++) {
            int x = pts[i][0];
            int y = pts[i][1];
            result[i][0] = (int) Math.round(x * Math.cos(angle) - y * Math.sin(angle));
            result[i][1] = (int) Math.round(x * Math.sin(angle) + y * Math.cos(angle));
        }
        return result;
    }

    // Scaling
    private int[][] scale(int[][] pts, double sx, double sy) {
        int[][] result = new int[pts.length][2];
        for (int i = 0; i < pts.length; i++) {
            result[i][0] = (int) Math.round(pts[i][0] * sx);
            result[i][1] = (int) Math.round(pts[i][1] * sy);
        }
        return result;
    }

    // Shearing
    private int[][] shear(int[][] pts, double shx, double shy) {
        int[][] result = new int[pts.length][2];
        for (int i = 0; i < pts.length; i++) {
            int x = pts[i][0];
            int y = pts[i][1];
            result[i][0] = (int) Math.round(x + shx * y);
            result[i][1] = (int) Math.round(y + shy * x);
        }
        return result;
    }

    // Main method
    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Transformations");
        Transformations2D panel = new Transformations2D();
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
