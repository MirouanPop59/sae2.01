package org.uphf.sae;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class RobotTest {
    protected Robot robot;
    protected Monde monde;

    @BeforeEach
    void setUp()  throws Exception {     // creation d'un robot et d'un monde afin de tester si tout fonctionne correctement
        monde=new Monde();
        monde.leMonde = new Secteur[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                monde.leMonde[i][j] = new Secteur();
            }
        }
        robot = new Robot(1, 5, 5, "OR", 2, 4);
        monde.leMonde[5][5].robot(robot.getIdRobot());



    }

    @AfterEach
    void tearDown()  throws Exception {
        robot=null;
        monde=null;

    }

    @Test
    void avancer_Nord() {  //nous allons verifier si notre robot se dirige bien vers le nord
        robot.avancer(monde, "N");
        assertEquals(4, robot.getColonne());
        assertEquals(5, robot.getLigne());


    }
    @Test
    void avancer_Sud() {   //nous allons verifier si notre robot se dirige bien vers le sud
        robot.avancer(monde, "S");
        assertEquals(6, robot.getColonne());
        assertEquals(5, robot.getLigne());

    }
    @Test
    void avancer_Ouest() {   //nous allons verifier si notre robot se dirige bien vers l'ouest
        robot.avancer(monde, "O");
        assertEquals(5, robot.getColonne());
        assertEquals(4, robot.getLigne());


    }
    @Test
    void avancer_Est(){    //nous allons verifier si notre robot se dirige bien vers l'est
        robot.avancer(monde, "E");
        assertEquals(5, robot.getColonne());
        assertEquals(6, robot.getLigne());

    }


}