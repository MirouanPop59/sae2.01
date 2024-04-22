package org.uphf.sae;


public class Entrepot extends Secteur {
    private int idEntrepot;
    private int ligne;
    private int colonne;
    private String typeM;
    protected int nbM;

    public Entrepot(int idEntrepot,int ligne, int colonne,String typeM) {
        this.idEntrepot = idEntrepot;
        this.ligne=ligne;
        this.colonne = colonne;
        this.typeM=typeM;
        this.nbM=0 ;

    }



    public String TypeMineraiE() {
        return typeM;
    }

    public int getIdEntrepot() {
        return idEntrepot;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getNbM() {
        return nbM;
    }

    public String toString(){
        return "E"+getIdEntrepot()+" | "+typeM+" | "+getNbM();
    }
}