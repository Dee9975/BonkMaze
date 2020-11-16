import generation.*;

import java.util.Random;

public class MainActivity {
  public static void main(String[] args) {
    MazeGenerator maze = new MazeGenerator(new Random(), 10, 10);
    MazeRenderer renderer = new MazeRenderer(maze);
    renderer.createAndDisplayMaze();
  }
}
