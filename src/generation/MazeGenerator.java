package generation;

import java.util.Random;

public class MazeGenerator {
    private final Cell[][] maze;
    private final Random random;
    private final Wall[] walls;

    public MazeGenerator(Random gen, int rows, int cols) {
        int numWalls = 2 * rows * cols - rows - cols;

        this.maze = new Cell[rows][cols];
        this.walls = new Wall[numWalls];
        this.random = gen;

        int num = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.maze[i][j] = new Cell();
                if (i < rows - 1) {
                    this.walls[num++] = new Wall(i, j, 'h');
                }
                if (j < cols - 1) {
                    this.walls[num++] = new Wall(i, j, 'v');
                }
            }
        }
    }

    public void generateMaze() {
        int rows = this.getNumRows();
        int cols = this.getNumCols();

        this.maze[0][0].setW(false);
        this.maze[rows - 1][cols - 1].setE(false);

        int numCells = rows * cols;

        FindMerge allMerges = new FindMerge(numCells);

        while (allMerges.getNoSubsets() > 1) {
            Wall randWall = this.walls[this.random.nextInt(this.walls.length)];

            int row = randWall.getRow();
            int col = randWall.getCol();
            int aCell = row * cols + col;

            if (randWall.getOrientation() == 'h') {
                int bCell = (row + 1) * cols + col;

                if (allMerges.find(aCell) != allMerges.find(bCell)) {
                    this.maze[row][col].setS(false);
                    this.maze[row + 1][col].setN(false);
                    allMerges.merge(aCell, bCell);
                }
            } else {
                int bCell = row * cols + col + 1;

                if (allMerges.find(aCell) != allMerges.find(bCell)) {
                    this.maze[row][col].setE(false);
                    this.maze[row][col + 1].setW(false);
                    allMerges.merge(aCell, bCell);
                }
            }
        }
    }

    public Cell getCellAt(int r, int c) {
        return this.maze[r][c];
    }

    public void setCellAt(int r, int c, Cell cell) {
        this.maze[r][c] = cell;
    }

    public int getNumCols() {
        return this.maze[0].length;
    }

    public int getNumRows() {
        return this.maze.length;
    }
}