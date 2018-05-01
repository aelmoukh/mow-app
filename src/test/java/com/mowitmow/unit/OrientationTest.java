package com.mowitmow.unit;

import com.mowitmow.model.Orientation;

import junit.framework.TestCase;

public class OrientationTest extends TestCase {

	Orientation orientation;

	public OrientationTest(String testName) {
		super(testName);
	}

	public void testGetNextNord() {
		orientation = Orientation.N;
		assertEquals(Orientation.E, orientation.getNext());
	}

	public void testGetNextSud() {
		orientation = Orientation.S;
		assertEquals(Orientation.W, orientation.getNext());
	}

	public void testGetNextEst() {
		orientation = Orientation.E;
		assertEquals(Orientation.S, orientation.getNext());
	}

	public void testGetNextOuest() {
		orientation = Orientation.W;
		assertEquals(Orientation.N, orientation.getNext());
	}

	public void testGetPreviousNord() {
		orientation = Orientation.N;
		assertEquals(Orientation.W, orientation.getPrevious());
	}

	public void testGetPreviousSud() {
		orientation = Orientation.S;
		assertEquals(Orientation.E, orientation.getPrevious());
	}

	public void testGetPreviousEst() {
		orientation = Orientation.E;
		assertEquals(Orientation.N, orientation.getPrevious());
	}

	public void testGetPreviousOuest() {
		orientation = Orientation.W;
		assertEquals(Orientation.S, orientation.getPrevious());
	}
}
