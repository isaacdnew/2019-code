package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampLatches extends Subsystem {
	private DoubleSolenoid lSol;
	private DoubleSolenoid rSol;

	public RampLatches() {
	}

	public void init() {
		lSol = new DoubleSolenoid(RobotMap.L_SOL_PORTS[0], RobotMap.L_SOL_PORTS[1]);
		rSol = new DoubleSolenoid(RobotMap.R_SOL_PORTS[0], RobotMap.R_SOL_PORTS[1]);
		lSol.set(Value.kForward);
		rSol.set(Value.kForward);
	}

	public void closeLeftRamp() {
		lSol.set(Value.kForward);
	}

	public void openLeftRamp() {
		lSol.set(Value.kReverse);
	}

	public void closeRightRamp() {
		rSol.set(Value.kForward);
	}

	public void openRightRamp() {
		rSol.set(Value.kReverse);
	}

	public void initDefaultCommand() {
	}
}
