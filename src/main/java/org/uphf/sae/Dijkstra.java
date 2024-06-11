package org.uphf.sae;

import java.util.*;


public class Robot {
    ArrayList<int[]> coord = new ArrayList<>();
    final int idRobot;
    private int colonne;
    private int ligne;
    final String typeM;
    private int nbM;
    final int capaciteRecolte;
    final int capaciteStock;

    /* Constructeur par défaut*/

    public Robot(int idRobot, int colonne, int ligne, String typeM, int capaciteRecolte, int capaciteStock) {
        this.idRobot = idRobot;
        this.colonne = colonne;
        this.ligne = ligne;
        this.typeM = typeM;
        this.nbM = 0 ;
        this.capaciteRecolte = capaciteRecolte;
        this.capaciteStock = capaciteStock;
    }
    /* création de la Methode Avancer pour que l'utilisateur puisse choisir la direction du robot à chaque tour*/

    public Monde avancer(Monde monde,String direction) {
        System.out.println("Direction selectionnée : "+direction);
        try {
            if (direction.equals("N") && monde.leMonde[this.colonne-1][this.ligne].accueilRobot() && colonne-1>=0){
                monde.leMonde[this.colonne][this.ligne].enleverRobot();
                monde.leMonde[this.colonne-1][this.ligne].robot(this.getIdRobot());
                this.colonne-=1;}
            else if(direction.equals("S") && monde.leMonde[this.colonne+1][this.ligne].accueilRobot()&& colonne+1<= monde.leMonde[0].length){
                monde.leMonde[this.colonne][this.ligne].enleverRobot();
                monde.leMonde[this.colonne+1][this.ligne].robot(this.getIdRobot());
                this.colonne+=1;}
            else if(direction.equals("O") && monde.leMonde[this.colonne][this.ligne-1].accueilRobot()&& ligne-1>=0){
                monde.leMonde[this.colonne][this.ligne].enleverRobot();
                monde.leMonde[this.colonne][this.ligne-1].robot(this.getIdRobot());
                this.ligne-=1;}
            else if(direction.equals("E") && monde.leMonde[this.colonne][this.ligne+1].accueilRobot() && ligne+1<= monde.leMonde.length){
                monde.leMonde[this.colonne][this.ligne].enleverRobot();
                monde.leMonde[this.colonne][this.ligne+1].robot(this.getIdRobot());
                this.ligne+=1;}
        } catch (Exception e) {
            System.out.println("Le robot ne peux pas y acceder veuiller reessayer");
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez une commande de déplacement (N, O, E, S), pour récolter des minerais ou en déposer taper 'recolte' ou 'depos' et 'exit' pour quitter : ");
            String command = sc.next();
            avancer(monde,command);
        }
        return monde;
    }

    public void decouvrir(Monde monde){
        if ((ligne>0) && (colonne>0)) {
            monde.leMonde[colonne][ligne+1].invers();
            monde.leMonde[colonne+1][ligne].invers();
            monde.leMonde[colonne][ligne-1].invers();
            monde.leMonde[colonne-1][ligne].invers();
        }
        else if (ligne==0) {
            if (colonne==0) {
                monde.leMonde[colonne][ligne+1].invers();
                monde.leMonde[colonne+1][ligne].invers();
            }
            else if (colonne==9){
                monde.leMonde[colonne][ligne+1].invers();
                monde.leMonde[colonne-1][ligne].invers();
            }
            else if (colonne>0 && colonne<9){
                monde.leMonde[colonne][ligne+1].invers();
                monde.leMonde[colonne-1][ligne].invers();
                monde.leMonde[colonne+1][ligne].invers();
            }
        }
        else if (ligne==9) {
            if (colonne==9) {
                monde.leMonde[colonne][ligne-1].invers();
                monde.leMonde[colonne-1][ligne].invers();
            }
            else if (colonne>0 && colonne<9){
                monde.leMonde[colonne][ligne-1].invers();
                monde.leMonde[colonne-1][ligne].invers();
                monde.leMonde[colonne+1][ligne].invers();
            }
            else if (colonne==0) {
                monde.leMonde[colonne][ligne-1].invers();
                monde.leMonde[colonne+1][ligne].invers();
            }
        }

        else if ((colonne==0) && ((ligne>0 && ligne<9))){
                monde.leMonde[colonne][ligne-1].invers();
                monde.leMonde[colonne][ligne+1].invers();
                monde.leMonde[colonne+1][ligne].invers();
        }

        else if ((colonne==9) && ((ligne>0 && ligne<9))){
                monde.leMonde[colonne][ligne-1].invers();
                monde.leMonde[colonne][ligne+1].invers();
                monde.leMonde[colonne-1][ligne].invers();
        }
    }

    public void recolter(Mine min) {
        int capatampon= this.capaciteRecolte;
        System.out.println(capatampon);
        System.out.println(this.capaciteRecolte);
        if (Objects.equals(min.getTypeMineraiM(), this.typeM)){
            while ((capatampon>0) && this.capaciteStock>this.nbM){
                if ((min.getNbMinerai()>0)){
                    this.nbM += 1;
                    min.retirerMinerai();
                    }
                    capatampon-=1;}
            if (capatampon == 0){ System.out.println("La capacité de récolte du robot est atteinte "); }
            else if (this.capaciteStock==this.nbM){ System.out.println("La capacité de stockage du robot est atteinte "); }
            else if (min.getNbMinerai() == 0){System.out.println("Mine vide ");}
            }
        else{System.out.println("Le robot n'est pas adapter a ce type de minerai.");}
        }



    /* Cette methode permet à un robot de deposer ses minerais dans l'entrepot correspondant */

    public void deposer(Entrepot e) {
        if (e.TypeMineraiE().equals(this.typeM) && e.getColonne()==this.colonne && e.getLigne() == this.ligne) {
            e.nbM+=this.nbM;
            this.nbM=0;
        }else{System.out.println("L'entrepot n'est pas adapter a ce type de minerai.");}
    }

    /* creation des getter et l'affichage toString */

    public String TypeMineraiR() {
        return TypeMineraiR();
    }

    public int getIdRobot() {
        return idRobot;
    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public String getTypeM() {
        return typeM;
    }

    public int getNbM() {
        return nbM;
    }

    public int getCapaciteStock() {
        return capaciteStock;
    }

    public String toString() {
        return "R" + getIdRobot()+ " | "+ getColonne()+","+ getLigne() + " | " +getTypeM()+" | "+ getNbM()+ '/'+ getCapaciteStock() ;
    }

    public void deplacementAuto(Monde monde){
        for (int i=0;i<10;i++) {
            for (int j=0;j<10;j++) {
                if (!monde.leMonde[i][j].decouvert) {
                    int[] coCase=new int[]{j,i};
                    coord.add(coCase);
                }
            }
        }

//        String[] direction = new String[]{"N","E","S","O"};
//        int[] nbl = new int[]{0,4};
//        int col = colonne;
//        int lig = ligne;
//        if (col > 2 && lig > 2 && lig < 8 && col < 8) {
//            if ((!monde.leMonde[col-1][lig-1].decouvert) || (!monde.leMonde[col][lig-2].decouvert) || (!monde.leMonde[col+1][lig-1].decouvert)) {
//                if (!monde.leMonde[col][lig-1].verifEau()) {
//                    avancer(monde, "N");
//                }
//            }
//            else if ((!monde.leMonde[col+1][lig].decouvert) || (!monde.leMonde[col+1][lig+1].decouvert)) {
//                if (!monde.leMonde[col+1][lig].verifEau()) {
//                    avancer(monde, "E");
//                }
//            }
//            else if ((!monde.leMonde[col][lig+2].decouvert) || (!monde.leMonde[col-1][lig+1].decouvert)) {
//                if (!monde.leMonde[col][lig+1].verifEau()) {
//                    avancer(monde, "S");
//                }
//            }
//            else if (!monde.leMonde[col-2][lig].decouvert) {
//                if (!monde.leMonde[col-1][lig].verifEau()) {
//                    avancer(monde, "O");
//                }
//            }
//            else {
//                int nb = monde.genererInt(0,4);
//                if (direction[nb].equals("N")){
//                    if (!monde.leMonde[col][lig-1].verifEau()) {
//                        avancer(monde, "N");
//                    }
//                }
//                else if (direction[nb].equals("E")){
//                    if (!monde.leMonde[col+1][lig].verifEau()) {
//                        avancer(monde, "E");
//                    }
//                }
//                else if (direction[nb].equals("S")){
//                    if (!monde.leMonde[col][lig+1].verifEau()) {
//                        avancer(monde, "S");
//                    }
//                }
//                else{
//                    if (!monde.leMonde[col-1][lig].verifEau()) {
//                        avancer(monde, "O");
//                    }
//                }
//            }
//        }
//        if (col==0) {
//            if (lig ==0) {
//                if ((!monde.leMonde[col+2][lig].decouvert) || (!monde.leMonde[col+1][lig+1].decouvert)) {
//                    if (!monde.leMonde[col+1][lig].verifEau()) {
//                        avancer(monde, "E");
//                    }
//                }
//                else if (!monde.leMonde[col][lig+2].decouvert) {
//                    if (!monde.leMonde[col][lig+1].verifEau()) {
//                        avancer(monde, "S");
//                    }
//                }
//                else  {
//                    int nb = monde.genererInt(1,3);
//                    if (direction[nb].equals("E")){
//                        if (!monde.leMonde[col+1][lig].verifEau()) {
//                            avancer(monde, "E");
//                        }
//                    }
//                    else {
//                        if (!monde.leMonde[col][lig+1].verifEau()) {
//                            avancer(monde, "S");
//                        }
//                    }
//                }
//            }
//            else if (lig==9) {
//                if ((!monde.leMonde[col][lig+2].decouvert) || (!monde.leMonde[col+1][lig+1].decouvert)) {
//                    if (!monde.leMonde[col][lig-1].verifEau()) {
//                        avancer(monde, "N");
//                    }
//                }
//                else if (!monde.leMonde[col+2][lig].decouvert){
//                    if (!monde.leMonde[col+1][lig].verifEau()) {
//                        avancer(monde, "E");
//                    }
//                }
//                else  {
//                    int nb = monde.genererInt(0,2);
//                    if (direction[nb].equals("N")){
//                        if (!monde.leMonde[col][lig-1].verifEau()) {
//                            avancer(monde, "N");
//                        }
//                    }
//                    else {
//                        if (!monde.leMonde[col+1][lig].verifEau()) {
//                            avancer(monde, "E");
//                        }
//                    }
//                }
//            }
//        }
//        if (col==9){
//            if (lig ==0) {
//                if ((!monde.leMonde[col][lig+2].decouvert) || (!monde.leMonde[col-1][lig+1].decouvert)) {
//                    if (!monde.leMonde[col][lig+1].verifEau()) {
//                        avancer(monde, "S");
//                    }
//                }
//                else if (!monde.leMonde[col-2][lig].decouvert) {
//                    if (!monde.leMonde[col-1][lig].verifEau()) {
//                        avancer(monde, "O");
//                    }
//                }
//                else  {
//                    int nb = monde.genererInt(2,4);
//                    if (direction[nb].equals("S")){
//                        if (!monde.leMonde[col-1][lig].verifEau()) {
//                            avancer(monde, "S");
//                        }
//                    }
//                    else {
//                        if (!monde.leMonde[col][lig+1].verifEau()) {
//                            avancer(monde, "O");
//                        }
//                    }
//                }
//            }
//            if (lig ==9) {
//                if ((!monde.leMonde[col-2][lig].decouvert) || (!monde.leMonde[col-1][lig-1].decouvert)) {
//                    if (!monde.leMonde[col][lig-1].verifEau()) {
//                        avancer(monde, "O");
//                    }
//                }
//                else if (!monde.leMonde[col][lig-2].decouvert) {
//                    if (!monde.leMonde[col][lig-1].verifEau()) {
//                        avancer(monde, "N");
//                    }
//                }
//                else  {
//                    int nb = monde.genererInt(0,2);
//                    if (direction[nb].equals("O")){
//                        if (!monde.leMonde[col-1][lig].verifEau()) {
//                            avancer(monde, "O");
//                        }
//                    }
//                    else {
//                        if (!monde.leMonde[col][lig+1].verifEau()) {
//                            avancer(monde, "N");
//                        }
//                    }
//                }
//            }
//        }
    }
}
