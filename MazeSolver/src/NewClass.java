import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class NewClass extends JFrame {

    private int maze[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},   // creating maze
                            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                            {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                            {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    public List<Integer> path = new ArrayList<>();    // arraylist to store path

    public NewClass() {
        setTitle("Maze Solver");    // setting title and size for our game window
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchPath(maze, 1, 1, path);     // calling the search function
    }

    public void paint(Graphics g) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);  //  creating compartments and filling color
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }

        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);

            System.out.println("XCordinates:" + pathx);  // printing path co ordinates
            System.out.println("YCordinates:" + pathy);

            g.setColor(Color.green);
            g.fillRect(pathx * 30, pathy * 30, 25, 25); // filling color to the path
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}