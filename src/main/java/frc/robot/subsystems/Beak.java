package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.teleop.TeleBeak;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Beak extends Subsystem {
	private VictorSP m;

	public Beak() {
	}

	public void init() {
		m = new VictorSP(RobotMap.BEAK_MOTOR);
		m.setInverted(RobotMap.BEAK_MOTOR_INVERTED);
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
