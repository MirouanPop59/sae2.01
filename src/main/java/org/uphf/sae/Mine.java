package org.uphf.sae;
import java.util.*;

public class Mine extends Secteur {
    private int idMine;
    private int ligne;
    private int colonne;
    private String typeM;
    protected int nbMinerai;
    private int CapaInitial;

    /* constructeur par defaut pour la mine */

    public Mine(int idMine, int ligne, int colonne, String typeM) {
        this.idMine = idMine;
        this.ligne = ligne;
        this.colonne = colonne;
        this.typeM = typeM;
        this.CapaInitial = genererInt(50,100);   /* la capacité de la mine est calculé avec un random entre 50 et 100 pour sa capacité */
        this.nbMinerai = this.CapaInitial ;

    }

    public int genererInt(int borneInf,int borneSup){
        Random random=new Random();
        int nb;
        nb=borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

    /* creation de getter de chaque attributs */

    public String TypeMineraiM() {
        return typeM;
    }

    public int getIdMine() {
        return idMine;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getCapaInitial() {
        return CapaInitial;
    }

    public int getNbMinerai() {
        return this.nbMinerai;
    }
}

