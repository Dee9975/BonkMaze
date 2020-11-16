package generation;

import javax.swing.*;
import java.awt.*;

public class MazeRenderer extends JFrame {
    //Fix checkstyle warning
    private static final long serialVersionUID = 1L;
    private static final int INITAL_SIZE = 500;

    private MazeGenerator maze;
    //Init Frame
    private GridLayout grid;

    public MazeRenderer(MazeGenerator theMaze) {
        super("Labirints");
        this.maze = theMaze;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(INITAL_SIZE, INITAL_SIZE);
        this.grid = new GridLayout(this.maze.getNumRows(),
                this.maze.getNumCols());
        this.setLayout(this.grid);
    }

    //Place generation.tiles
    public void createAndDisplayMaze() {
        for (int row = 0; row < this.maze.getNumRows(); row++) {
            for (int col = 0; col < this.maze.getNumCols(); col++) {
                this.add(new MyJLabel(this.findCorrectTilePath(
                        this.maze.getCellAt(row, col))));
            }
        }
        this.setVisible(true);
    }

    private String findCorrectTilePath(Cell cell) {

        String code = "";
        if (!cell.isN())
            code += "n";

        if (!cell.isS())
            code += "s";

        if (!cell.isE())
            code += "e";

        if (!cell.isW())
            code += "w";

        if (code.equals(""))
            code = "0";
        return "tiles/maze_" + code + ".png";
    }


    private class MyJLabel extends JLabel {
        private static final long serialVersionUID = 1L;

        ImageIcon imageIcon;

        public MyJLabel(String path) {
            super();
            this.imageIcon = new ImageIcon(path);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.imageIcon.getImage(), 0, 0,
                    getWidth(), getHeight(), this);
        }
    }
}
