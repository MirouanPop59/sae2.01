package org.uphf.sae;

import java.util.*;


public class Robot {
    private int idRobot;
    private int ligne;
    private int colonne;
    private String typeM;
    private int nbM;
    private int capaciteStock;

    /* Constructeur par défaut*/

    public Robot(int idRobot, int ligne, int colonne, String typeM, int nbM, int capaciteStock) {
        this.idRobot = idRobot;
        this.ligne = ligne;
        this.colonne = colonne;
        this.typeM = typeM;
        this.nbM = nbM;
        this.capaciteStock = capaciteStock;
    }
    /* création de la Methode Avancer pour que l'utilisateur puisse choisir la direction du robot à chaque tour*/

    public Monde Avancer(Monde monde, Robot rob) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecris une lettre (N, O, E ou S): ");
        String direction = scanner.nextLine();
        System.out.println("Direction selectionnée"+direction);
        if (direction.equals("N"))
            monde.leMonde[rob.ligne][rob.colonne] = monde.leMonde[rob.ligne-1][rob.colonne];
        else if(direction.equals("S"))
            monde.leMonde[rob.ligne][rob.colonne] = monde.leMonde[rob.ligne+1][rob.colonne];
        else if(direction.equals("O"))
            monde.leMonde[rob.ligne][rob.colonne] = monde.leMonde[rob.ligne][rob.colonne-1];
        else if(direction.equals("E"))
            monde.leMonde[rob.ligne][rob.colonne] = monde.leMonde[rob.ligne][rob.colonne+1];
        return monde;
    }


    public int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }
    /* Methode permettant que le robot recolte un nombre de minerai aleatoire entre 1 et 3 */

    public void Recolter(Mine min) {
        int nb=genererInt(1,3);
        while((this.nbM > nb) && (min.getNbMinerai()> nb)){
            this.nbM += nb;
            min.nbMinerai -= nb;
            nb=genererInt(1,3);
        }
    }

    /* Cette methode permet à un robot de deposer ses minerais dans l'entrepot correspondant */

    public void Deposer(Entrepot e) {
        if (e.TypeMineraiE().equals(this.typeM) && e.getColonne()==this.colonne && e.getLigne() == this.ligne) {
            e.nbM+=this.nbM;
            this.nbM=0;
        }
    }

    /* creation des getter et l'affichage toString */

    public String TypeMineraiR() {
        return TypeMineraiR();
    }

    public String toString(){
        return "R"+getIdRobot()+" | "+getNbM()+ " | "+getTypeM()+" | "+getCapaciteStock();
    }

    public int getIdRobot() {
        return idRobot;
    }

    public int getNbM() {
        return nbM;
    }

    public String getTypeM() {
        return typeM;
    }

    public int getCapaciteStock() {
        return capaciteStock;
    }

}