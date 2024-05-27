package org.uphf.sae;


public class Entrepot extends Secteur {
    private int idEntrepot;
    private int colonne;
    private int ligne;
    private String typeM;
    protected int nbM;


    /* constructeur entrepot par defauts */
    public Entrepot(int idEntrepot, int colonne,int ligne,String typeM) {
        this.idEntrepot = idEntrepot;
        this.colonne = colonne;
        this.ligne=ligne;
        this.typeM=typeM;
        this.nbM=0 ; /* on initialise le nombre de minerai de l'entrepot à 0 puisqu'au début de la partie il possède 0 minerai */

    }

    /* permet d'ajouter les minerais du robot dans l'entreport concerné */
    public int addMinerai(int i){
        nbM += i;
        return nbM;
    }

    /* création des getter */

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
        return "E"+getIdEntrepot()+" | "+getColonne()+" | "+getLigne()+" | "+ TypeMineraiE() +" | "+getNbM();
    }
}