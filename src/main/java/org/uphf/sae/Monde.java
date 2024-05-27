package org.uphf.sae;

import java.util.ArrayList;
import java.util.Random;

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

    public int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }
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

    public ArrayList<Robot> getLstRobot() {
        return lstRobot;
    }

    public ArrayList<Mine> getLstMine() {
        return lstMine;
    }

    public ArrayList<Entrepot> getLstEntrepot() {
        return lstEntrepot;
    }

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
            this.lstcoo.add(new ArrayList<>(l));
        }
    }

    public Monde() {
        this.leMonde = leMonde;
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
    public String lstElements(){
        System.out.println(this.getLstEntrepot());
        System.out.println(this.getLstMine());
        System.out.println(this.getLstRobot());
        return " ";
    }

    public void affichage() {
        for (Secteur[] secteurs : leMonde) {
            for (Secteur secteur : secteurs) {
                secteur.afficherligne(0);
            }
            System.out.println();
            for (Secteur secteur : secteurs) {
                secteur.afficherligne(1);
            }
            System.out.println();
            }
        System.out.println(lstElements());
        }
}


