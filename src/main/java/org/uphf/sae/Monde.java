package org.uphf.sae;

import java.util.Arrays;
import java.util.Random;

public class Monde {
    protected int[][][][] leMonde = new int[10][10][2][2];
    private int nbMineOr;
    private int nbMineNickel;
    private int nbRobotNickel;
    private int nbRobotor;

    public Monde() {
        this.leMonde = leMonde;
        for (int i = 0; i < leMonde.length; i++) {
            for (int j = 0; j < leMonde[i].length; j++) {
                for (int k = 0; k < leMonde[i][j].length; k++) {
                    for (int l = 0; l < leMonde[i][j][k].length; l++) {
                        leMonde[i][j][k][l] = 0;
                    }
                }
            }
        }
        this.nbRobotNickel = genererInt(1, 5);
        this.nbMineNickel = genererInt(1, 2);
        this.nbMineOr = genererInt(1, 2);
        this.nbRobotor = genererInt(1, 5);

    }

    public int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }

    public void Affichage() {
        for (int i = 0; i < leMonde.length; i++) {
            for (int k=0;k<2;k++) {
                for (int j=0;j<leMonde[i].length;j++) {
                    for (int l=0;l<2;l++) {
                        System.out.print(leMonde[i][j][k][l] + " ");
                    }
                    if (j<leMonde[i].length-1){
                        System.out.print("| ");
                    }
                }
                System.out.println();
            }
            if (i<leMonde.length-1){
                for (int j = 0; j<leMonde[i].length*5+leMonde[i].length-1;j++){
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }

    public void generationMinEntrepot() {
    }
}