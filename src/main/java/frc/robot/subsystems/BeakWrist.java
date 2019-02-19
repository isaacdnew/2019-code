package frc.robot.subsystems;

import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BeakWrist extends Subsystem {
	private WPI_TalonSRX m;

	public BeakWrist() {
	}

	public void init() {
		m = new WPI_TalonSRX(RobotMap.BEAK_WRIST_MOTOR);
		m.setInverted(RobotMap.BEAK_WRIST_MOTOR_INVERTED);
		m.configOpenloopRamp(0.5);
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
