package org.uphf.sae;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;


class RobotTest {
    protected Robot robot;
    protected Monde monde;
    protected Mine mine;
    protected Entrepot entrepot;


    @BeforeEach
    void setUp() throws Exception {
        // Création d'un robot et d'un monde afin de tester si tout fonctionne correctement
        monde = new Monde();
        monde.leMonde = new Secteur[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                monde.leMonde[i][j] = new Secteur();
            }
        }
        robot = new Robot(1, 5, 5, "OR", 0, 3); // CapaciteStock initiale est 0, maxStock est 2
        monde.leMonde[5][5].robot(robot.getIdRobot());
        mine = new Mine(1, 5, 6, "OR");
        entrepot = new Entrepot(1, 5, 4, "OR");
        monde.leMonde[5][5].robot(entrepot.getIdEntrepot());
        monde.leMonde[5][5].robot(mine.getIdMine());
    }


    @AfterEach
    void tearDown() throws Exception {
        robot = null;
        monde = null;
        mine = null;
        entrepot = null;
    }


    @Test
    void avancerNord() { // Vérifie si notre robot se dirige bien vers le nord
        robot.avancer(monde, "N");
        assertEquals(4, robot.getColonne());
        assertEquals(5, robot.getLigne());
    }


    @Test
    void avancerSud() { // Vérifie si notre robot se dirige bien vers le sud
        robot.avancer(monde, "S");
        assertEquals(6, robot.getColonne());
        assertEquals(5, robot.getLigne());
    }


    @Test
    void avancerOuest() { // Vérifie si notre robot se dirige bien vers l'ouest
        robot.avancer(monde, "O");
        assertEquals(5, robot.getColonne());
        assertEquals(4, robot.getLigne());
    }


    @Test
    void avancerEst() { // Vérifie si notre robot se dirige bien vers l'est
        robot.avancer(monde, "E");
        assertEquals(5, robot.getColonne());
        assertEquals(6, robot.getLigne());
    }

    @Test
    void avancerHorsLimiteNord() {
        robot.setColonne(0); // Positionner le robot à la limite nord
        robot.avancer(monde, "N");
        assertEquals(0, robot.getColonne()); // Le robot ne doit pas sortir de la grille
    }

    @Test
    void avancerHorsLimiteSud() {
        robot.setColonne(9); // Positionner le robot à la limite sud
        robot.avancer(monde, "S");
        assertEquals(9, robot.getColonne()); // Le robot ne doit pas sortir de la grille
    }

    @Test
    void avancerHorsLimiteOuest() {
        robot.setLigne(0); // Positionner le robot à la limite ouest
        robot.avancer(monde, "O");
        assertEquals(0, robot.getLigne()); // Le robot ne doit pas sortir de la grille
    }

    @Test
    void avancerHorsLimiteEst() {
        robot.setLigne(9); // Positionner le robot à la limite est
        robot.avancer(monde, "E");
        assertEquals(9, robot.getLigne()); // Le robot ne doit pas sortir de la grille
    }

    @Test
    void collecter() {
        robot.setColonne(5);
        robot.setLigne(5);
        mine = new Mine(1, 5, 6, "OR"); // Ajout d'une mine avec des minerais
        robot.recolter(this.mine);
        assertEquals(2, robot.getNbM());
    }

    @Test
    void deposer() {
        robot.setColonne(5);
        robot.setLigne(4);
        robot.deposer(entrepot);
        assertEquals(0, robot.getNbM()); // Le robot doit avoir déposé tous ses minerais


    }
}