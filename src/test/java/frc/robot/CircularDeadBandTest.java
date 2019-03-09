package frc.robot;

import org.junit.*;

import frc.robot.OI;
import frc.robot.Robot;

public class CircularDeadBandTest {

	public CircularDeadBandTest() {

	}

	@Test
	public void testQuadrants() {
		double xIn = 0.5;
		double yIn = 0.5;
		double xOut = 0.375;
		double yOut = 0.375;
		testXY(xIn, yIn, xOut, yOut); // q1
		testXY(-xIn, yIn, -xOut, yOut); // q2
		testXY(-xIn, -yIn, -xOut, -yOut); // q3
		testXY(xIn, -yIn, xOut, -yOut); // q4
	}

	@Test
	public void testVertical() {
		testXY(0, 0.5, 0, 0.264);
		testXY(0, -0.5, 0, -0.264);
	}

	@Test
	public void testVerticalWithinDeadBand() {
		testXY(0, 0.1, 0, 0);
		testXY(0, -0.1, 0, 0);
	}

	@Test
	public void testQuadrantsWithinDeadBand() {
		double xIn = 0.09;
		double yIn = 0.09;
		double xOut = 0;
		double yOut = 0;
		testXY(xIn, yIn, xOut, yOut); // q1
		testXY(-xIn, yIn, -xOut, yOut); // q2
		testXY(-xIn, -yIn, -xOut, -yOut); // q3
		testXY(xIn, -yIn, xOut, -yOut); // q4
	}

	public void testXY(double xInput, double yInput, double expectedX, double expectedY) {
		double actualX = (double) Math.round(OI.circularExpDeadBand(xInput, yInput)[0] * 1000.0) / 1000.0;
		double actualY = (double) Math.round(OI.circularExpDeadBand(xInput, yInput)[1] * 1000.0) / 1000.0;
		assert (expectedX == actualX) : ("X output should equal " + expectedX + ", but is actually " + actualX);
		assert (expectedY == actualY) : ("Y output should equal " + expectedY + ", but is actually " + actualY);
	}
}