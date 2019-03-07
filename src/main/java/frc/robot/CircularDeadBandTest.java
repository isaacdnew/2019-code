package frc.robot;

import org.junit.*;

import frc.robot.OI;
import frc.robot.Robot;

public class CircularDeadBandTest {
	private OI oi = new OI(new Robot());

	@Before
	private void init() {
		System.out.println("Hello World (from init())");
	}

	@Test
	private void test() {
		System.out.println("Hello World (from test())");
		assert (1 == 2) : "1 does not equal 2";
	}
}