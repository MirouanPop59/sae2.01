package org.uphf.sae;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    // Constructeur du monde

public class Monde {
    protected Secteur[][] leMonde = new Secteur[10][10];
    private int tampon;
    private int cx;
    private int cy;
    ArrayList<Integer> l = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> lstPtEau = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> lstcoo = new ArrayList<ArrayList<Integer>>();
    ArrayList<Entrepot> lstEntrepot  = new ArrayList<Entrepot>();
    ArrayList<Mine> lstMine = new ArrayList<Mine>();
    ArrayList<Robot> lstRobot = new ArrayList<Robot>();

    // fonction générant un nombre aléatoire

    public int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }

    // fonction qui retourne le chemin le plus court

    public List<int[]> trouverCheminPlusCourt(int startX, int startY, int endX, int endY) {
        Dijkstra dijkstra = new Dijkstra(this);
        return dijkstra.cheminPlusCourt(startX, startY, endX, endY);
    }

    public Secteur[][] getLesSecteurs() {
        return leMonde;
    }

    /* Methode permettant de definir des parties d'eau pour la creation du monde */

    public void genererPtEau(){
        this.tampon = genererInt(1, 10);
        for (int i = 0; i<= tampon;i++) {
            l.clear();
            cx = genererInt(0,leMonde[0].length );
            cy = genererInt(0,leMonde.length);
            l.add(cx);
            l.add(cy);
            while (!leMonde[cx][cy].vierge()){
                l.clear();
                cx = genererInt(0,leMonde[0].length );
                cy = genererInt(0,leMonde.length);
                l.add(cx);
                l.add(cy);
            }
            this.leMonde[cx][cy].CreePtEau();
            this.lstPtEau.add(new ArrayList<>(l));
        }
    }

    // Renvoie différentes listes

    public ArrayList<Robot> getLstRobot() {
        return lstRobot;
    }

    public ArrayList<Mine> getLstMine() {
        return lstMine;
    }

    public ArrayList<Entrepot> getLstEntrepot() {
        return lstEntrepot;
    }

    /* Methode permettant de definir des mines pour la creation du monde */

    public void genererMine(){
        this.tampon = genererInt(2, 4);
        for (int nbr = 1; nbr <= tampon; nbr++) {
            l.clear();
            this.cx = genererInt(0,leMonde[0].length );
            this.cy = genererInt(0,leMonde.length);
            l.add(cx);
            l.add(cy);
            while (!leMonde[cx][cy].accueilBatiment()) {
                l.clear();
                this.cx = genererInt(0,leMonde[0].length );
                this.cy = genererInt(0,leMonde.length);
                l.add(cx);
                l.add(cy);
            }
            this.leMonde[cx][cy].CreeMine(nbr);
            if (nbr%2!=0){
                this.lstMine.add(new Mine(nbr, cx, cy, "NI"));
            }else{
                this.lstMine.add(new Mine(nbr, cx, cy, "OR"));
            }
            this.lstcoo.add(new ArrayList<>(l));
        }
    }

    /* Methode permettant de definir des entrtepots pour la creation du monde */

    public void genererEntrepot(){
        for (int nbr = 1; nbr <=2; nbr++) {
            l.clear();
            this.cx = genererInt(0,leMonde[0].length );
            this.cy = genererInt(0,leMonde.length);
            l.add(cx);
            l.add(cy);
            while (!leMonde[cx][cy].accueilBatiment()) {
                l.clear();
                this.cx = genererInt(0,leMonde[0].length );
                this.cy = genererInt(0,leMonde.length);
                l.add(cx);
                l.add(cy);
            }
            this.leMonde[cx][cy].CreeEntrepot(nbr);
            if (nbr==1){
                this.lstEntrepot.add(new Entrepot(nbr, cx, cy, "NI"));}
            else {
                this.lstEntrepot.add(new Entrepot(nbr, cx, cy, "OR"));
            }
            this.lstcoo.add(new ArrayList<>(l));
        }
    }

    // découvre le secteur actuel et les quatre secteurs adjacents

    public void decouverteMonde() {
        int maxX = leMonde.length;
        int maxY = leMonde[0].length;
        if (cx >= 0 && cx < maxX && cy >= 0 && cy < maxY) {
            this.leMonde[cx][cy].decouvrir();}
        if (cx + 1 >= 0 && cx + 1 < maxX && cy >= 0 && cy < maxY) {
            this.leMonde[cx + 1][cy].decouvrir();}
        if (cx >= 0 && cx < maxX && cy + 1 >= 0 && cy + 1 < maxY) {
            this.leMonde[cx][cy + 1].decouvrir();}
        if (cx - 1 >= 0 && cx - 1 < maxX && cy >= 0 && cy < maxY) {
            this.leMonde[cx - 1][cy].decouvrir();}
        if (cx >= 0 && cx < maxX && cy - 1 >= 0 && cy - 1 < maxY) {
            this.leMonde[cx][cy - 1].decouvrir();}
    }

    /* Methode permettant de generer un certain nombre de robot avec un type de minerai precis  */

    public void genererRobot(){
        this.tampon = genererInt(2,5);
        for (int nbr = 1; nbr <=tampon; nbr++) {
            l.clear();
            this.cx = genererInt(0,leMonde[0].length );
            this.cy = genererInt(0,leMonde.length);
            l.add(cx);
            l.add(cy);
            while (!leMonde[cx][cy].accueilRobot()) {
                l.clear();
                this.cx = genererInt(0,leMonde[0].length );
                this.cy = genererInt(0,leMonde.length);
                l.add(cx);
                l.add(cy);
            }
            int capaExtraction = genererInt(1,3);
            int capaStock = genererInt(5,9);
            if (nbr%2!=0){
                this.lstRobot.add(new Robot(nbr, cx, cy, "NI",capaExtraction,capaStock));
            }else{
                this.lstRobot.add(new Robot(nbr, cx, cy, "OR",capaExtraction,capaStock));
            }
            this.leMonde[cx][cy].robot(nbr);
            decouverteMonde();
            this.lstcoo.add(new ArrayList<>(l));
        }
    }

    // création du monde

    public Monde() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.leMonde[i][j] = new Secteur();
            }
        }
        this.lstcoo.clear();
        this.lstPtEau.clear();
        genererPtEau();
        genererMine();
        genererEntrepot();
        genererRobot();
    }

    // affichage des différents éléments

    public String lstElements(){
        System.out.println(this.getLstEntrepot());
        System.out.println(this.getLstMine());
        System.out.println(this.getLstRobot());
        return " ";
    }

    /* Methode permettant de crrer l'affichage en version console du monde   */

    public void affichage() {
        System.out.println("  0     1     2     3     4     5     6     7     8     9");
        for (Secteur[] secteurs : leMonde) {
            for (Secteur secteur : secteurs) {
                secteur.afficherligne(0);
            }
            System.out.println();
            for (Secteur secteur : secteurs) {
                secteur.afficherligne(1);
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------");
        }
        System.out.println(lstElements());
    }

    // fonction qui fait découvrir le monde aux robots en les faisant se déplacer vers les secteur non visible

    public String decouvert(Robot r) {
        int x = r.getColonne();
        int y = r.getLigne();
        System.out.println("x: " + x + " y: " + y);
        if (x > 0) {
            if (leMonde[x - 1][y].accueilRobot()) {
                if ((x > 1 && y > 0 && y < 9 && (!leMonde[x - 2][y].visible || !leMonde[x - 1][y - 1].visible || !leMonde[x - 1][y + 1].visible))
                        || (x > 1 && y > 1 && !leMonde[x - 2][y].visible)
                        || (x > 1 && y < 9 && !leMonde[x - 2][y].visible)
                        || (x == 1 && y > 0 && y < 9 && (!leMonde[x - 1][y + 1].visible || !leMonde[x - 1][y - 1].visible))) {
                    return "N";
                }
            }
        }
        if (x < 9) {
            if (leMonde[x + 1][y].accueilRobot()) {
                if ((x < 8 && y > 0 && y < 9 && (!leMonde[x + 2][y].visible || !leMonde[x + 1][y + 1].visible || !leMonde[x + 1][y - 1].visible))
                        || (x < 8 && y > 1 && !leMonde[x + 2][y].visible)
                        || (x < 8 && y < 9 && !leMonde[x + 2][y].visible)
                        || (x == 8 && y > 0 && y < 9 && (!leMonde[x + 1][y + 1].visible || !leMonde[x + 1][y - 1].visible))) {
                    return "S";
                }
            }
        }

        if (y<9) {
            if (leMonde[x][y+1].accueilRobot()) {
                if ((y<8 && x>0 && x< 9 && (!leMonde[x][y+2].visible || !leMonde[x+1][y+1].visible || !leMonde[x-1][y+1].visible))
                        || (y<8 && x<8 && !leMonde[x][y+2].visible)
                        || (y<8 && x>0 && !leMonde[x][y+2].visible)
                        || (y== 8 && x>0 && x<9 && (!leMonde[x+1][y+1].visible || !leMonde[x-1][y+1].visible))) {
                    return "E";
                }
            }
        }
        if (y > 0) {
            if (leMonde[x][y - 1].accueilRobot()) {
                if ((y > 1 && x > 0 && x < 9 && (!leMonde[x][y - 2].visible || !leMonde[x - 1][y - 1].visible || !leMonde[x + 1][y - 1].visible))
                        || (y > 1 && x < 10 && !leMonde[x][y - 2].visible)
                        || (y > 1 && !leMonde[x][y - 2].visible)
                        || (y == 1 && x > 0 && x < 9 && (!leMonde[x + 1][y - 1].visible || !leMonde[x - 1][y - 1].visible))) {
                    return "O";
                }
            }
        }
        int z = genererInt(1, 4);
        System.out.println("z = "+z);
        if (z==1) {
            if (x>0 && leMonde[x-1][y].accueilRobot()) {return "N";}
        } else if (z==2) {
            if (y < 9 && leMonde[x][y+1].accueilRobot()) {return "E";}
        } else if (z==3){
            if (x<9 && leMonde[x+1][y].accueilRobot()) {return "S";}
        }else if (z==4){
            if (y>0 && leMonde[x][y-1].accueilRobot()) {return "O";}
        }
        if (y>0 && leMonde[x][y-1].accueilRobot()) {return "O";}
        if (x<9 && leMonde[x+1][y].accueilRobot()) {return "S";}
        return "H";
    }

    /* Methode permettant de gerer les differentes bordures du plateau pour ne pas decouvrir des cases qui n'existent pas   */

    public void decouvmonde(Robot r){
        if (r.getColonne()>0){leMonde[r.getColonne()-1][r.getLigne()].decouvrir();}
        if (r.getColonne()<9){leMonde[r.getColonne()+1][r.getLigne()].decouvrir();}
        if (r.getLigne()<9){leMonde[r.getColonne()][r.getLigne()+1].decouvrir();}
        if (r.getLigne()>0) {leMonde[r.getColonne()][r.getLigne()-1].decouvrir();}
    }

    // vérifie si tout les secteurs ont été découvert

    public boolean aToutDecouvert() {
        for (int i = 0; i < leMonde.length; i++) {
            for (int j = 0; j < leMonde[i].length; j++) {
                if (!leMonde[i][j].visible) {
                    return false;
                }
            }
        }
        return true;
    }

    // Méthode pour obtenir les voisins d'un secteur

    public ArrayList<int[]> getVoisins(int x, int y) {
        ArrayList<int[]> voisins = new ArrayList<>();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < leMonde.length && ny >= 0 && ny < leMonde[0].length) {
                voisins.add(new int[]{nx, ny});
            }
        }
        return voisins;
    }

    // Méthode pour calculer le coût de déplacement

    public int getCout(int x1, int y1, int x2, int y2) {
        // Implémentez ici la logique de calcul du coût entre les secteurs (peut varier selon les types de terrains, etc.)
        return 1; // Exemple simple avec coût constant
    }
}