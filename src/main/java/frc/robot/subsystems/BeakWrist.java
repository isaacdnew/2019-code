package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BeakWrist extends Subsystem {
	private VictorSP m;

	public BeakWrist() {
	}

	public void init() {
		m = new VictorSP(RobotMap.BEAK_WRIST_MOTOR);
		m.setInverted(RobotMap.BEAK_WRIST_MOTOR_INVERTED);
	}

	public void move(double pwr) {
		m.set(pwr);
	}

	public void stop() {
		m.stopMotor();
	}

	public void initDefaultCommand() {
	}
}
