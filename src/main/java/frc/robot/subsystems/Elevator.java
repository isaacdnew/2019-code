package frc.robot.subsystems;

import frc.robot.RobotMap;
//import frc.robot.commands.teleop.TeleLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	private VictorSP m1;
	private VictorSP m2;
	private DigitalInput limitSwitchTop;
	private DigitalInput limitSwitchBottom;
	private double neutralPwr = 0.1;

	public Elevator() {
		m1 = new VictorSP(RobotMap.LIFTER_MOTOR_1);
		m2 = new VictorSP(RobotMap.LIFTER_MOTOR_2);
		m1.setInverted(RobotMap.LIFTER_INVERTED);
		m2.setInverted(RobotMap.LIFTER_INVERTED);
		limitSwitchTop = new DigitalInput(RobotMap.LIFTER_LIMIT_TOP);
		limitSwitchBottom = new DigitalInput(RobotMap.LIFTER_LIMIT_BOTTOM);
	}

	public void move(double pwr) {
		if (isAtTop() && pwr > 0) {
			m1.set(neutralPwr);
			m2.set(neutralPwr);
			System.out.println("Elevator at top; not going up.");
		} else if (isAtBottom() && pwr < 0) {
			m1.set(neutralPwr);
			m2.set(neutralPwr);
			System.out.println("Elevator at bottom; not going down.");
		} else {
			m1.set(pwr + neutralPwr);
			m2.set(pwr + neutralPwr);
		}
	}

	public void goLimp() {
		m1.stopMotor();
		m2.stopMotor();
	}

	public boolean isAtTop() {
		return !limitSwitchTop.get();
	}

	public boolean isInMiddle() {
		return !isAtTop() && !isAtBottom();
	}

	public boolean isAtBottom() {
		return !limitSwitchBottom.get();
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new TeleLift(this));
	}
}
