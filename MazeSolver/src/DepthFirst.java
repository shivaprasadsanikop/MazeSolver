import java.util.*;

public class DepthFirst {
    // implementing DFS for traversal to find destination path
    public static boolean searchPath(int [][] maze, int x, int y, List<Integer> path){
        if(maze[y][x]==9){
            path.add(x);
            path.add(y);
            return true;
        }

        if(maze[y][x]==0){
            maze[y][x] = 2;
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x+dx, y+dy,path)){  // to traverse upwards
                path.add(x);
                path.add(y);
                return true;
            }

            dx=1;
            dy=0;
            if(searchPath(maze,x+dx,y+dy,path)){   // to traverse downwards
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if(searchPath(maze, x+dx, y+dy, path)){       // to traverse right
                path.add(x);
                path.add(y);
                return true;
            }

            dx=0;
            dy = -1;
            if(searchPath(maze, x+dx, y+dy, path)){  // to traverse left
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}