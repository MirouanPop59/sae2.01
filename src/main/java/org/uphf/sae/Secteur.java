package org.uphf.sae;

public class Secteur {
    private int[][] sect = {{0,0},{0,0}};
    boolean visible = false;


    public void decouvrir(){ this.visible = true;} // rend visible les secteurs

    public void CreePtEau() {
        this.sect[0][0] = 9;
        this.sect[0][1] = 9;
        this.sect[1][0] = 9;
        this.sect[1][1] = 9;
    }

    // Crée les différents éléments du monde

    public void CreeEntrepot(int nb) {
        this.sect[0][0] = 8;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public void CreeMine(int nb) {
        this.sect[0][0] = 7;
        this.sect[0][1] = nb;
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public void robot(int nb) {
        this.sect[1][0] = 6;
        this.sect[1][1] = nb;
    }

    // Vérifie de quelle types est le secteurs (vide, robot etc..)
    public boolean vierge(){
        if (this.sect[0][0] == 0 && this.sect[0][1] == 0 && this.sect[1][0] == 0 && this.sect[1][1] == 0) {
            return true;}
        else {return false;}
    }
    public boolean accueilBatiment() {
        if (this.sect[1][0] == 0 && this.sect[1][1] == 0) {
            return true;}
        else {return false;}
    }
    public boolean accueilRobot() {
        if (this.sect[1][0] == 0 && this.sect[1][1] == 0) {
            return true;}
        else {return false;}
    }
    public void enleverRobot() {
        this.sect[1][0] = 0;
        this.sect[1][1] = 0;
    }

    public int getidBatiement(){
        return this.sect[0][1];
    }
    public int getidRobot(){
        return this.sect[1][1];
    }
    public String getTypeMineraiE(){
        if (this.sect[0][1]==1){
            return "NI";
        }else{
            return "OR";}
    }
    public boolean secteurMine(){
        if(this.sect[0][0] == 7) {return true;}else {return false;}}

    public boolean secteurEntrepot(){
        if(this.sect[0][0] == 8) {return true;}else {return false;}}


    public boolean secteurEau(){
        if(this.sect[0][0] == 9 && this.sect[0][1] == 9 && this.sect[1][0] == 9 && this.sect[1][1] == 9) {
            return true;
        }else {return false;}
    }

    public void afficherligne(int ligne) {
        if (visible){
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
            default -> ' ';};
        if (num==9){String ligneHaut = "|X|X| ";
            System.out.print(ligneHaut);}
        else if (num!=0) {String ligneHaut = "|%s|%d| ".formatted(cr, num);
            System.out.print(ligneHaut);}
        else {String ligneHaut = "|%s| | ".formatted(cr);
            System.out.print(ligneHaut);}
    }else{
            String ligneHaut = "|?|?| ";
            System.out.print(ligneHaut);}
    }
}
