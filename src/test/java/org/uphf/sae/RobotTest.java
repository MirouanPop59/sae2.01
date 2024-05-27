package org.uphf.sae;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    protected Robot robot;
    protected

    @BeforeEach
    void setUp()  throws Exception {
        robot=new Robot();
    }

    @AfterEach
    void tearDown()  throws Exception {
        robot=null;
    }

    @Test
    void avancer() {
        assertEquals('N',robot.avancer(monde,'N'));
    }

    @Test
    void recolter() {
    }

    @Test
    void deposer() {
    }
}