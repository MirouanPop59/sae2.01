package org.uphf.sae;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Robot choixrobot(ArrayList<Robot> robots){
        // Afficher les robots disponibles
        System.out.println("Entrez l'ID du robot que vous souhaitez sélectionner. Liste des robots disponibles :");
        for (Robot robot : robots) {
            System.out.println(robot);
        }
        // Choisir un robot existant
        Scanner sc = new Scanner(System.in);
        Robot selectRobot = null;

        System.out.print("Entrez l'ID du robot que vous souhaitez sélectionner : ");
        int robotId = sc.nextInt();
        for (Robot robot : robots) {
            if (robot.getIdRobot() == robotId) {
                selectRobot = robot;}}
        while (selectRobot == null) {
            System.out.println("Robot non trouvé. Veuillez réessayer.");
            System.out.print("Entrez l'ID du robot que vous souhaitez sélectionner : ");
            robotId = sc.nextInt();
            for (Robot r : robots) {
                if (r.getIdRobot() == robotId) {
                    selectRobot = r;
                    System.out.println(r.getIdRobot());
                    System.out.println(robotId);
                }
            }

        }
       return selectRobot;
    }

    public static void main(String[] args) {
        Monde m= new Monde();
        Robot rEnJeux;
        int cptTour = 0;

        boolean allMinevide =false;
        /*boolean quitter = false;*/
        m.affichage();
        while (!allMinevide) {
            allMinevide = true;
            for (Mine mine : m.getLstMine()) {
                if (mine.getNbMinerai() != 0) {
                    allMinevide = false;
                    // Simuler l'extraction de minerai (jouer au jeux)
                    rEnJeux = choixrobot( m.getLstRobot());
                    // Déplacer le robot
                    boolean exit = false;Scanner sc = new Scanner(System.in);
                    while (!exit) {
                        System.out.print("Entrez une commande de déplacement (N, O, E, S), pour recolter des minerais ou en deposer taper 'recolter' ou 'deposer' et 'exit' pour quitter : ");
                        String command = sc.next();
                        if (command.equalsIgnoreCase("exit")) {
                            exit = true;}
                        else if (command.equalsIgnoreCase("recolter")) {
                            for(Mine mineRbt: m.getLstMine())
                                if (mineRbt.getColonne() == rEnJeux.getColonne() && mineRbt.getLigne()==rEnJeux.getLigne() ){
                                    System.out.println(mine.getIdMine());
                                    rEnJeux.recolter(mineRbt);
                                    System.out.println("Entrez l'ID du robot que vous souhaitez sélectionner. Liste des robots disponibles :");
                                    for (Robot robot : m.getLstRobot()) {
                                        System.out.println(robot);}
                                    cptTour+=1;
                                }
                        }else if (command.equalsIgnoreCase("deposer")) {
                            for(Entrepot entrepotRbt: m.getLstEntrepot())
                                if (entrepotRbt.getColonne() == rEnJeux.getColonne() && entrepotRbt.getLigne()==rEnJeux.getLigne()){
                                    rEnJeux.deposer(entrepotRbt);
                                    cptTour+=1;
                                }

                        }
                        else if ((command.equalsIgnoreCase("N")) || (command.equalsIgnoreCase("S")) || (command.equalsIgnoreCase("O")) || (command.equalsIgnoreCase("E"))){
                            m = rEnJeux.avancer(m,command);
                            cptTour+=1;
                            m.affichage();}
                            // break;
                    }
                }
            if (!allMinevide) {
                System.out.println("Il y a encore des mines avec des minerais.");
                m.affichage();}
            }
        }
    }
}
