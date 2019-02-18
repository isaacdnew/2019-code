package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.teleop.TeleBeak;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Beak extends Subsystem {
	private WPI_TalonSRX m;

	public Beak() {
	}

	public void init() {
		m = new WPI_TalonSRX(RobotMap.BEAK_MOTOR);
		m.setInverted(RobotMap.BEAK_MOTOR_INVERTED);
		m.configOpenloopRamp(0);
	}

	public void move(double pwr) {
		m.set(pwr);
	}

	public void stop() {
		m.stopMotor();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TeleBeak(this));
	}
}
