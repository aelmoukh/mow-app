package com.mowitmow.unit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.mowitmow.model.Orientation;
import com.mowitmow.model.instruction.InstructionDeplacement;
import com.mowitmow.model.instruction.InstructionRotation;
import com.mowitmow.model.tendeuse.Tendeuse;
import com.mowitmow.model.tendeuse.TendeusePosition;

import junit.framework.TestCase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TendeuseTest extends TestCase {
    Tendeuse tendeuse = new Tendeuse(0, 0, Orientation.N);
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public TendeuseTest() {
        super();
    }

    @Test
    public void testTournerDroiteNord() {
        tendeuse.setOrientation(Orientation.N);
        tendeuse.tourner(InstructionRotation.D);
        assertEquals(Orientation.E, tendeuse.getOrientation());
    }

    @Test
    public void testTournerDroiteSud() {
        tendeuse.setOrientation(Orientation.S);
        tendeuse.tourner(InstructionRotation.D);
        assertEquals(Orientation.W, tendeuse.getOrientation());
    }

    @Test
    public void testTournerDroiteEst() {
        tendeuse.setOrientation(Orientation.E);
        tendeuse.tourner(InstructionRotation.D);
        assertEquals(Orientation.S, tendeuse.getOrientation());
    }

    @Test
    public void testTournerDroiteOuest() {
        tendeuse.setOrientation(Orientation.W);
        tendeuse.tourner(InstructionRotation.D);
        assertEquals(Orientation.N, tendeuse.getOrientation());
    }

    @Test
    public void testTournerGaucheNord() {
        tendeuse.setOrientation(Orientation.N);
        tendeuse.tourner(InstructionRotation.G);
        assertEquals(Orientation.W, tendeuse.getOrientation());
    }

    @Test
    public void testTournerGaucheSud() {
        tendeuse.setOrientation(Orientation.S);
        tendeuse.tourner(InstructionRotation.G);
        assertEquals(Orientation.E, tendeuse.getOrientation());
    }

    @Test
    public void testTournerGaucheEst() {
        tendeuse.setOrientation(Orientation.E);
        tendeuse.tourner(InstructionRotation.G);
        assertEquals(Orientation.N, tendeuse.getOrientation());
    }

    @Test
    public void testTournerGaucheOuest() {
        tendeuse.setOrientation(Orientation.W);
        tendeuse.tourner(InstructionRotation.G);
        assertEquals(Orientation.S, tendeuse.getOrientation());
    }

    @Test
    public void testTournerNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("instruction de rotation ne peut pas etre null");
        tendeuse.tourner(null);
        fail();
    }

    @Test
    public void testseDeplacerNord() {
        tendeuse = new Tendeuse(0, 0, Orientation.N);
        tendeuse.seDeplacer(InstructionDeplacement.A);
        assertEquals(new TendeusePosition(0, 1, Orientation.N), tendeuse.getPosition());
    }

    @Test
    public void testseDeplacerSud() {
        tendeuse = new Tendeuse(0, 0, Orientation.S);
        tendeuse.seDeplacer(InstructionDeplacement.A);
        assertEquals(new TendeusePosition(0, -1, Orientation.S), tendeuse.getPosition());
    }

    @Test
    public void testseDeplacerEst() {
        tendeuse = new Tendeuse(0, 0, Orientation.E);
        tendeuse.seDeplacer(InstructionDeplacement.A);
        assertEquals(new TendeusePosition(-1, 0, Orientation.E), tendeuse.getPosition());
    }

    @Test
    public void testseDeplacerOuest() {
        tendeuse = new Tendeuse(0, 0, Orientation.W);
        tendeuse.seDeplacer(InstructionDeplacement.A);
        assertEquals(new TendeusePosition(1, 0, Orientation.W), tendeuse.getPosition());
    }

    @Test
    public void testSeDeplacerNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("instruction de deplacement ne peut pas etre null");
        tendeuse.seDeplacer(null);
        fail();
    }
}
