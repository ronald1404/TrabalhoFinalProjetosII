package Problema2909;

public class Neto {
    private int pos;
    private int R;
    private int B;

    Neto(int R,int B){
        this.R = R;
        this.B = B;
    }

    public void setB(int b) {
        B = b;
    }
    public void setR(int r) {
        R = r;
    }
    public int getB() {
        return B;
    }
    public int getR() {
        return R;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
    public int getPos() {
        return pos;
    }

}
