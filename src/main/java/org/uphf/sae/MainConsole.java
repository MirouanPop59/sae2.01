package org.uphf.sae;
import java.util.ArrayList;
import java.util.Scanner;


public class MainConsole {
    public static Robot choixrobot(ArrayList<Robot> robots) {
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
                selectRobot = robot;
            }
        }
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
        Scanner scanner = new Scanner(System.in);
        String mode = "";

            int cpt = 0;
            boolean sortie;
            Monde m = new Monde();
            ArrayList<Robot> rlstTampon = new ArrayList<>();
            Robot rEnJeux;
            boolean allMinevide = false;
            /*boolean quitter = false;*/
            m.affichage();
            while (!allMinevide) {
                rlstTampon.addAll(m.getLstRobot());
                while (!rlstTampon.isEmpty()) {
                    cpt += 1;
                    System.out.println("Tour numéro : " + cpt);
                    for (Mine mine : m.getLstMine()) {
                        if (mine.getNbMinerai() != 0) {
                            allMinevide = false;
                        } else allMinevide = true;
                        // Simuler l'extraction de minerai (jouer au jeux)
                        rEnJeux = choixrobot(rlstTampon);
                        sortie = false;
                        // Déplacer le robot
                        while (!sortie) {
                            Scanner sc = new Scanner(System.in);
                            System.out.print("Entrez une commande de déplacement (N, O, E, S), pour recolter des minerais ou en deposer taper 'recolter' ou 'deposer' et 'exit' pour passer le tour : ");
                            String command = sc.next();
                            rlstTampon.remove(rEnJeux);
                            if (command.equals("exit")) {
                                sortie = true;
                            } else if (command.equalsIgnoreCase("recolter")) {
                                for (Mine mineRbt : m.getLstMine()) {
                                    if (mineRbt.getColonne() == rEnJeux.getColonne() && mineRbt.getLigne() == rEnJeux.getLigne()) {
                                        System.out.println(mine.getIdMine());
                                        rEnJeux.recolter(mineRbt);
                                        m.affichage();
                                        System.out.println("Liste des robots disponibles :");
                                        for (Robot robot : m.getLstRobot()) {
                                            System.out.println(robot);
                                        }
                                        System.out.println();
                                    }
                                }
                                sortie = true;
                            } else if (command.equalsIgnoreCase("deposer")) {
                                for (Entrepot entrepotRbt : m.getLstEntrepot())
                                    if (entrepotRbt.getColonne() == rEnJeux.getColonne() && entrepotRbt.getLigne() == rEnJeux.getLigne()) {
                                        rEnJeux.deposer(entrepotRbt);
                                        m.affichage();
                                    }
                                sortie = true;
                            } else if ((command.equalsIgnoreCase("N")) || (command.equalsIgnoreCase("S")) || (command.equalsIgnoreCase("O")) || (command.equalsIgnoreCase("E"))) {
                                m = rEnJeux.avancer(m, command);
                                m.affichage();
                                sortie = true;
                            } else sortie = false;
                        }
                    }
                }
                if (!allMinevide) {
                    System.out.println("Il y a encore des mines avec des minerais.");
                    m.affichage();
                }
            }
        }


}
