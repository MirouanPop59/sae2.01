package org.uphf.sae;

import java.util.*;


public class Robot {
    private int idRobot;
    private int colonne;
    private int ligne;
    private String typeM;
    private int nbM;
    private int capaciteRecolte;
    private int capaciteStock;

    /* Constructeur par défaut*/

    public Robot(int idRobot, int colonne, int ligne, String typeM, int capaciteRecolte, int capaciteStock) {
        this.idRobot = idRobot;
        this.colonne = colonne;
        this.ligne = ligne;
        this.typeM = typeM;
        this.nbM = 0;
        this.capaciteRecolte = capaciteRecolte;
        this.capaciteStock = capaciteStock;
    }
    /* création de la Methode Avancer pour que l'utilisateur puisse choisir la direction du robot à chaque tour*/

    public Monde avancer(Monde monde,String direction) {
        System.out.println("Direction selectionnée"+direction);
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

    public int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }
    /* Methode permettant que le robot recolte un nombre de minerai aleatoire entre 1 et 3 */

    public void recolter(Mine min) {
        int capatampon=this.capaciteRecolte;
        System.out.println(capatampon);
        System.out.println(this.capaciteRecolte);
        if (Objects.equals(min.getTypeMineraiM(), this.typeM)){
            while ((min.getNbMinerai()>0) || (this.capaciteStock>this.nbM) || capatampon>0){
                if (capatampon == 0){ System.out.println("La capacité de récolte du robot est atteinte "); break;}
                else if (this.capaciteStock==this.nbM){ System.out.println("La capacité de stockage du robot est atteinte "); break;}
                else if (min.getNbMinerai() == 0){System.out.println("Mine vide ");break;}
                else{
                this.nbM += 1;
                capatampon-=1;
                min.retirerMinerai();
                break;}
            }
        }else{System.out.println("Le robot n'est pas adapter a ce type de minerai.");}
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
        return "R" + getIdRobot()+ " | "+ getColonne()+ getLigne() + " | " +getTypeM()+" | "+ getNbM()+ '/'+ getCapaciteStock() ;
    }
}