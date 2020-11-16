package generation;

public class Wall {
    private int row;
    private int col;

    private char orientation;

    public Wall(int r, int c, char orient) {
        this.row = r;
        this.col = c;
        this.orientation = orient;
    }

    public int getRow() {
        return row;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getCol() {
        return col;
    }
}
