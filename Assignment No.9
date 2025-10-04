import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CohenSutherland extends Frame {

    // Clipping rectangle boundaries
    final int x_min = 100, y_min = 100, x_max = 400, y_max = 300;

    // Original line endpoints
    int x1 = 50, y1 = 50, x2 = 450, y2 = 350;

    // Region codes
    final int INSIDE = 0; // 0000
    final int LEFT = 1;   // 0001
    final int RIGHT = 2;  // 0010
    final int BOTTOM = 4; // 0100
    final int TOP = 8;    // 1000

    public CohenSutherland() {
        setTitle("Cohen-Sutherland Line Clipping Demo");
        setSize(600, 500);
        setVisible(true);

        // Close window properly
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Compute region code for a point (x, y)
    int computeCode(int x, int y) {
        int code = INSIDE;

        if (x < x_min) code |= LEFT;
        else if (x > x_max) code |= RIGHT;

        if (y < y_min) code |= BOTTOM;
        else if (y > y_max) code |= TOP;

        return code;
    }

    // Cohen-Sutherland line clipping algorithm
    int[] cohenSutherlandClip(int x1, int y1, int x2, int y2) {
        int code1 = computeCode(x1, y1);
        int code2 = computeCode(x2, y2);

        while (true) {
            if ((code1 | code2) == 0) {
                // Both inside
                return new int[]{x1, y1, x2, y2};
            } else if ((code1 & code2) != 0) {
                // Both share outside region — reject
                return null;
            } else {
                int codeOut;
                int x = 0, y = 0;

                codeOut = (code1 != 0) ? code1 : code2;

                if ((codeOut & TOP) != 0) {
                    x = x1 + (x2 - x1) * (y_max - y1) / (y2 - y1);
                    y = y_max;
                } else if ((codeOut & BOTTOM) != 0) {
                    x = x1 + (x2 - x1) * (y_min - y1) / (y2 - y1);
                    y = y_min;
                } else if ((codeOut & RIGHT) != 0) {
                    y = y1 + (y2 - y1) * (x_max - x1) / (x2 - x1);
                    x = x_max;
                } else if ((codeOut & LEFT) != 0) {
                    y = y1 + (y2 - y1) * (x_min - x1) / (x2 - x1);
                    x = x_min;
                }

                if (codeOut == code1) {
                    x1 = x;
                    y1 = y;
                    code1 = computeCode(x1, y1);
                } else {
                    x2 = x;
                    y2 = y;
                    code2 = computeCode(x2, y2);
                }
            }
        }
    }

    public void paint(Graphics g) {
        // Draw clipping rectangle in black
        g.setColor(Color.BLACK);
        g.drawRect(x_min, y_min, x_max - x_min, y_max - y_min);

        // Draw original line in red
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);

        // Compute clipped line
        int[] clippedLine = cohenSutherlandClip(x1, y1, x2, y2);

        if (clippedLine != null) {
            // Draw clipped line in green
            g.setColor(Color.GREEN);
            g.drawLine(clippedLine[0], clippedLine[1], clippedLine[2], clippedLine[3]);
        } else {
            // No visible clipped line
            g.setColor(Color.BLUE);
            g.drawString("Line rejected (completely outside)", 50, 450);
        }
    }

    public static void main(String[] args) {
        new CohenSutherland();
    }
}
