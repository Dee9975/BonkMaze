package generation;

public class Cell {
    private boolean N;
    private boolean S;
    private boolean E;
    private boolean W;

    public Cell() {
        this.E = true;
        this.N = true;
        this.S = true;
        this.W = true;
    }

    public Cell(boolean n, boolean s, boolean e, boolean w) {
        this.W = w;
        this.S = s;
        this.N = n;
        this.E = e;
    }

    public boolean isE() {
        return E;
    }

    public boolean isN() {
        return N;
    }

    public boolean isS() {
        return S;
    }

    public boolean isW() {
        return W;
    }

    public void setE(boolean e) {
        E = e;
    }

    public void setN(boolean n) {
        N = n;
    }

    public void setS(boolean s) {
        S = s;
    }

    public void setW(boolean w) {
        W = w;
    }
}
