package org.uphf.sae;


public class Secteur {
    private int sect[][];

    public Secteur() {
        int[][] sect = {{0, 0}, {0, 0}};
    }

    public void CreePtEau() {
        this.sect[0][0] = 9;
        this.sect[0][1] = 9;
        this.sect[1][0] = 9;
        this.sect[1][1] = 9;
    }

    public void CreeEntrepot(int nb) {
        this.sect[0][0] = 1;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;

    }

    public void CreeMine(int nb) {
        this.sect[0][0] = 2;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public void robot(int nb) {
        this.sect[1][0] = 3;
        this.sect[1][1] = nb;
    }
}