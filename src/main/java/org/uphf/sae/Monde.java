package org.uphf.sae;

import java.util.Random;

public class Monde {
    protected Secteur leMonde[][] = new Secteur[10][10];
    private int nbMineOr;
    private int nbMineNickel;
    private int nbRobotNickel;
    private int nbRobotor;

    public Monde() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                leMonde[i][j] = new Secteur();
            }
        }
        this.leMonde = leMonde;
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
        for (int i = 0; i < 10; i++) {

            System.out.println("----------------------------------------------------------------------");
            System.out.println("||       ||    |      |      |      |      |      |");
        }
    }

    public void generationMinEntrepot() {
    }
}