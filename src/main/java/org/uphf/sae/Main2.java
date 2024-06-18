package org.uphf.sae;

import java.util.List;

public class Main2 {

    public static void decouvrirMonde(Monde m) throws InterruptedException {
        boolean toutDecouvert = false;
        while (!toutDecouvert) {
            toutDecouvert = true;
            for (Robot robot : m.lstRobot) {
                if (!m.aToutDecouvert()) {
                    String aa = m.decouvert(robot);
                    robot.avancer(m, aa);
                    m.decouvmonde(robot);
                    m.affichage();
                    Thread.sleep(200);
                    toutDecouvert = false;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int cpt = 0;
        Monde m = new Monde();
        List<int[]> chemin;
        m.affichage();


        // Découverte du monde par tous les robots
        decouvrirMonde(m);
        boolean allMineVide = false;
        boolean allRobotVide = false;

        while (!allMineVide || !allRobotVide) {
            cpt++;
            allMineVide = true;
            allRobotVide = true;
            for (Robot robot : m.getLstRobot()) {
                if (robot.getNbM() > 0) {
                    allRobotVide = false;
                }
                for (Mine mine : m.getLstMine()) {
                    if (mine.getNbMinerai() > 0) {
                        allMineVide = false;
                    }
            // Récolte de minerai et transport vers l'entrepôt
                    if (mine.typeM.equals(robot.typeM) && robot.getNbM() < robot.capaciteStock && mine.getNbMinerai() > 0 && mine.accueilRobot()) {
                        chemin = m.trouverCheminPlusCourt(robot.getLigne(), robot.getColonne(), mine.getLigne(), mine.getColonne());
                        for (int[] position : chemin) {
                            System.out.println("[" + position[0] + "," + position[1] + "]");
                        }
                        for (int[] position : chemin) {
                            if (position[0] - robot.getLigne() == -1) {
                                robot.avancer(m, "O");
                            } else if (position[0] - robot.getLigne() == 1) {
                                robot.avancer(m, "E");
                            } else if (position[1] - robot.getColonne() == -1) {
                                robot.avancer(m, "N");
                            } else if (position[1] - robot.getColonne() == 1) {
                                robot.avancer(m, "S");
                            }
                            m.affichage();
                        }
                        if (robot.getLigne() == mine.getLigne() && robot.getColonne() == mine.getColonne()) {
                            while (robot.getNbM() < robot.capaciteStock && mine.getNbMinerai() > 0) {
                                robot.recolter(mine);
                            }
                        }
                    }
                }

                for (Entrepot entrepot : m.getLstEntrepot()) {
                    if (robot.getNbM() > 0 && entrepot.typeM.equals(robot.typeM) && entrepot.accueilRobot()) {
                        chemin = m.trouverCheminPlusCourt(robot.getLigne(), robot.getColonne(), entrepot.getLigne(), entrepot.getColonne());
                        for (int[] position : chemin) {
                            System.out.println("[" + position[0] + "," + position[1] + "]");
                        }
                        for (int[] position : chemin) {
                            if (position[0] - robot.getLigne() == -1) {
                                robot.avancer(m, "O");
                            } else if (position[0] - robot.getLigne() == 1) {
                                robot.avancer(m, "E");
                            } else if (position[1] - robot.getColonne() == -1) {
                                robot.avancer(m, "N");
                            } else if (position[1] - robot.getColonne() == 1) {
                                robot.avancer(m, "S");
                            }
                            m.affichage();
                        }
                        if (robot.getLigne() == entrepot.getLigne() && robot.getColonne() == entrepot.getColonne()) {
                            while (robot.getNbM() > 0) {
                                robot.deposer(entrepot);
                            }
                        }
                    }
                }
            }

            if (allMineVide) {
                System.out.println("Toutes les mines sont vides");
                m.affichage();
            } else {
                System.out.println("Les mines ne sont pas vides");
                m.affichage();
            }
            Thread.sleep(200);
        }

        System.out.println("Les mines sont vides. Jeu terminé :)");
    }
}
