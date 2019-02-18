package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CargoClaw extends Subsystem {
	private VictorSP topMotor;
	private VictorSP bottomMotor;

	public CargoClaw() {
	}

	public void init() {
		topMotor = new VictorSP(RobotMap.CLAW_MOTOR_TOP);
		bottomMotor = new VictorSP(RobotMap.CLAW_MOTOR_BOTTOM);
		topMotor.setInverted(RobotMap.CLAW_TOP_INVERTED);
		bottomMotor.setInverted(RobotMap.CLAW_BOTTOM_INVERTED);
	}

	public void move(double pwr) {
		topMotor.set(pwr);
		bottomMotor.set(pwr);
	}

	public void stop() {
		topMotor.stopMotor();
		bottomMotor.stopMotor();
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new TeleLift(this));
	}
}
