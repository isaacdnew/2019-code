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
	private VictorSP leftMotor;
	private VictorSP rightMotor;
	private DigitalInput limitSwitchTop;
	private DigitalInput limitSwitchBottom;
	private final double neutralPwr = 0.1;

	public Elevator() {
	}

	public void init() {
		leftMotor = new VictorSP(RobotMap.ELEVATOR_LEFT_MOTOR);
		rightMotor = new VictorSP(RobotMap.ELEVATOR_RIGHT_MOTOR);
		leftMotor.setInverted(RobotMap.ELEVATOR_LEFT_INVERTED);
		rightMotor.setInverted(RobotMap.ELEVATOR_RIGHT_INVERTED);
		limitSwitchTop = new DigitalInput(RobotMap.ELEVATOR_LIMIT_TOP);
		limitSwitchBottom = new DigitalInput(RobotMap.ELEVATOR_LIMIT_BOTTOM);
	}

	public void move(double pwr) {
		if (isAtTop() && pwr > 0) {
			leftMotor.set(neutralPwr);
			rightMotor.set(neutralPwr);
			System.out.println("Elevator at top; not going up.");
		} else if (isAtBottom() && pwr < 0) {
			leftMotor.set(neutralPwr);
			rightMotor.set(neutralPwr);
			System.out.println("Elevator at bottom; not going down.");
		} else {
			leftMotor.set(pwr + neutralPwr);
			rightMotor.set(pwr + neutralPwr);
		}
	}

	public void goLimp() {
		leftMotor.stopMotor();
		rightMotor.stopMotor();
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
