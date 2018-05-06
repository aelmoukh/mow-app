package com.mowitmow.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mowitmow.model.Coordonnees;
import com.mowitmow.model.Pelouse;
import com.mowitmow.model.exception.FunctionnalException;
import com.mowitmow.model.tendeuse.Tendeuse;
import com.mowitmow.service.TendeuseManagerService;

public class TendeuseManagerServiceTest {
    TendeuseManagerService tendeuseManager = new TendeuseManagerService();
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testLancerNull() throws FunctionnalException {
        thrown.expect(FunctionnalException.class);
        thrown.expectMessage("input incoherent");
        tendeuseManager.executerInstructions(null);
        fail();
    }

    @Test
    public void testLancerInstr() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager
                .executerInstructions("5 5\r\n" + "1 2 N\r\n" + "GAGAGAGAA\r\n" + "3 3 E\r\n" + "AADAADADDA");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(1, 3)));
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(5, 1)));
    }

    @Test
    public void testLancerDepacementXmin() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager.executerInstructions("5 5\r\n" + "1 2 N\r\n" + "GAAAAAAAAAAAAAAAAAADAA\r\n");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(0, 4)));
    }

    @Test
    public void testLancerDepacementXmax() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager.executerInstructions("5 5\r\n" + "1 2 N\r\n" + "DAAAAAAAAAAAAAAAAAADAA\r\n");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(5, 0)));
    }

    @Test
    public void testLancerDepacementYmin() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager.executerInstructions("5 5\r\n" + "1 2 N\r\n" + "DDAAAAAAAAAAAAAAAAAADAA\r\n");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(0, 0)));
    }

    @Test
    public void testLancerDepacementYmax() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager.executerInstructions("5 5\r\n" + "1 2 N\r\n" + "AAAAAAAAAAAAAAAAAADAA\r\n");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(3, 5)));
    }

    @Test
    public void testLancerPiloterTendeuseExistente() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager
                .executerInstructions("5 5\r\n" + "1 2 N\r\n" + "GAGAGAGAA\r\n" + "1 3 N\r\n" + "AADAADADDA");
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        assertNotNull(pelouse);
        assertFalse(tendeusesDeployees.isEmpty());
        assertTrue(tendeusesDeployees.containsKey(new Coordonnees(3, 5)));
    }

    @Test
    public void testLancerInstructionInvalide() throws FunctionnalException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("instruction de rotation ne peut pas etre null");
        tendeuseManager.executerInstructions("5 5\r\n" + "1 2 N\r\n" + "TNB\r\n");
        fail();
    }

    @Test
    public void testConstruireResultatPourAffichageNull() throws FunctionnalException {
        assertEquals("", tendeuseManager.construireResultatPourAffichage(null));
    }

    @Test
    public void testConstruireResultatPourAffichage() throws FunctionnalException {
        Pelouse pelouse = tendeuseManager
                .executerInstructions("5 5\r\n" + "1 2 N\r\n" + "GAGAGAGAA\r\n" + "1 3 N\r\n" + "AADAADADDA");
        assertEquals("3 5 N\n", tendeuseManager.construireResultatPourAffichage(pelouse));
    }

    @Test
    public void testLancerInstructionEtAfficherNull() throws FunctionnalException {
        thrown.expect(FunctionnalException.class);
        thrown.expectMessage("input incoherent");
        tendeuseManager.lancerInstructionEtAfficher(null);
        fail();
    }

    @Test
    public void testLancerInstructionEtAfficherNotNull() throws FunctionnalException {
        assertEquals("1 3 N\n5 1 E\n", tendeuseManager
                .lancerInstructionEtAfficher("5 5\r\n" + "1 2 N\r\n" + "GAGAGAGAA\r\n" + "3 3 E\r\n" + "AADAADADDA"));
    }
}
