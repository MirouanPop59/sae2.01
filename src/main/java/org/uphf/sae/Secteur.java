package org.uphf.sae;


public class Secteur{
    final int[][] sect = {{0,0},{0,0}};
    private boolean decouvert;

    public void CreePtEau() {
        decouvert = false;
        this.sect[0][0] = 9;
        this.sect[0][1] = 9;
        this.sect[1][0] = 9;
        this.sect[1][1] = 9;
    }

    public void CreeEntrepot(int nb) {
        decouvert = false;
        this.sect[0][0] = 8;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public void CreeMine(int nb) {
        decouvert = false;
        this.sect[0][0] = 7;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public void infini() {
        decouvert = false;
        double posInf = Double.POSITIVE_INFINITY;
        this.sect[0][0] = (int)posInf;
        this.sect[0][1] = (int)posInf;
        this.sect[0][0] = (int)posInf;
        this.sect[0][1] = (int)posInf;
    }

    public void robot(int nb) {
        this.sect[1][0] = 6;
        this.sect[1][1] = nb;
    }
    public boolean vierge(){
        if (this.sect[0][0] == 0 && this.sect[0][1] == 0 && this.sect[1][0] == 0 && this.sect[1][1] == 0) return true;
        else {return false;}
    }
    public boolean accueilBatiment() {
        if (this.sect[0][0] == 0 && this.sect[0][1] == 0) {
            return true;}
        else {return false;}
    }
    public boolean accueilRobot() {
        if (this.sect[1][0] == 0 && this.sect[1][1] == 0) return true;
        else {return false;}
    }
    public void enleverRobot() {
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public boolean verifEau() {
        return this.sect[1][0] == 9;
        }


    public void afficherligne(int ligne) {
        // le type de l'element occupant le haut du secteur
        int type = this.sect[ligne][0];

        // son numéro
        int num = this.sect[ligne][1];

        Character cr = switch (type) {
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 8 -> 'E';
            case 9 -> 'X';
            case 7 -> 'M';
            case 6 -> 'R';
            default -> ' ';
        };
        if (num==9){String ligneHaut = "|X|X|";
            System.out.print(ligneHaut);}
        else if (num!=0) {String ligneHaut = "|%s|%d| ".formatted(cr, num);
            System.out.print(ligneHaut);}
        else {String ligneHaut = "|%s| | ".formatted(cr);
            System.out.print(ligneHaut);}
    }
}
