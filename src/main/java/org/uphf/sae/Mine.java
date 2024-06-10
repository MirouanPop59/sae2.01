package org.uphf.sae;
import java.util.*;

public class Mine extends Secteur {
    final int idMine;
    final int ligne;
    final int colonne;
    final String typeM;
    protected int nbMinerai;
    final int CapaInitial;

    /* constructeur par defaut pour la mine */

    public Mine (int idMine, int colonne,int ligne,  String typeM) {
        this.idMine = idMine;
        this.colonne = colonne;
        this.ligne = ligne;
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

    public String getTypeMineraiM() {
        return typeM;
    }

    public void retirerMinerai() {
        this.nbMinerai -=1;
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

    @Override
    public String toString() {
        return "M" + getIdMine()+ " | "+ getColonne()+","+ getLigne() + " | " +getTypeMineraiM()+" | "+getNbMinerai()+ '/'+ getCapaInitial() ;
    }
}

