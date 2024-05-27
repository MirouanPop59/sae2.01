package org.uphf.sae;

import java.util.ArrayList;
import java.util.Scanner;

public class JeuConsole {
    /*private Monde m = new Monde();

    public Robot choixrobot(ArrayList<Robot> robots){
        // Afficher les robots disponibles
        System.out.println("Entrez l'ID du robot que vous souhaitez sélectionner. Liste des robots disponibles :");
        for (Robot robot : robots) {
            System.out.println(robot);
        }
        // Choisir un robot existant
        Scanner sc = new Scanner(System.in);
        Robot selectRobot = null;
        while (selectRobot == null) {
            System.out.print("Entrez l'ID du robot que vous souhaitez sélectionner : ");
            int robotId = sc.nextInt();
            for (Robot robot : robots) {
                if (robot.getIdRobot() == robotId) {
                    selectRobot = robot;

                }
            }
            System.out.println("Robot non trouvé. Veuillez réessayer.");
        }
        return selectRobot;
    }

    public deplacementRobot(Monde m, Robot rEnJeux){
        boolean exit = false;Scanner sc = new Scanner(System.in);
        while (!exit) {
            System.out.print("Entrez une commande de déplacement (N, O, E, S) ou 'exit' pour quitter : ");
            String command = sc.next();

            if (command.equalsIgnoreCase("exit")) {
                exit = true;
            } else {m = rEnJeux.avancer(m, rEnJeux);
            }
        }
    }



    public Monde JeuConsole() {
        Monde m= new Monde();
        ArrayList<Mine> mines = m.getLstMine();
        ArrayList<Robot> robots = m.getLstRobot();
        Robot rEnJeux;

        boolean allMinevide =false;
        /*boolean quitter = false;
        m.affichage();
        while (!allMinevide) {
            allMinevide = true;
            for (Mine mine : mines) {
                if (mine.getNbMinerai() != 0) {
                    allMinevide = false;
                    // Simuler l'extraction de minerai (jouer au jeux)
                    rEnJeux = choixrobot( robots);
                    deplacementRobot(this.m,rEnJeux);
                    m.affichage();
                    mine.nbMinerai = 0; // ou une autre logique pour réduire nbMinerai
                    break;
                }
            }
            if (!allMinevide) {
                System.out.println("Il y a encore des mines avec des minerais.");
                m.affichage();
            }
        }return m;
    }*/
}