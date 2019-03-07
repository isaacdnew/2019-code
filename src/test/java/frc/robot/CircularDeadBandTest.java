package frc.robot;

import org.junit.*;

import frc.robot.OI;
import frc.robot.Robot;

public class CircularDeadBandTest {
	private OI oi = new OI(new Robot());

	public CircularDeadBandTest() {

	}

	@Before
	public void initOrSomething() {
		// System.out.println("Hello World (from init())");
	}

	@Test
	public void testXYPositive() {
		double x = 0.15;
		double y = 0.15;
		assert (oi.circularDeadBand(x, y)[0] == x);
		assert (oi.circularDeadBand(x, y)[0] == y);
	}
}