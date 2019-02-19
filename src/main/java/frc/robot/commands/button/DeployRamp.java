package frc.robot.commands.button;

import frc.robot.OI;
import frc.robot.subsystems.RampLatches;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Switches the robot from field centric to robot centric, or vice versa.
 */
public class DeployRamp extends Command {

	private RampLatches rampLatches;
	private double startTime;

	public enum Side {
		LEFT, RIGHT, BOTH
	}

	private Side side;

	public DeployRamp(RampLatches rampLatches, Side side) {
		this.rampLatches = rampLatches;
		this.side = side;
		requires(rampLatches);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		if (OI.driveController.getTriggerAxis(Hand.kLeft) >= 0.9
				&& OI.driveController.getTriggerAxis(Hand.kRight) >= 0.9) {
			if (side == Side.LEFT) {
				rampLatches.openLeftRamp();
			} else if (side == Side.RIGHT) {
				rampLatches.openRightRamp();
			} else if (side == Side.BOTH) {
				rampLatches.openLeftRamp();
				rampLatches.openRightRamp();
			}
			OI.driveController.setRumble(RumbleType.kLeftRumble, 1.0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() >= startTime + 0.2;
	}

	// Called once after isFinished returns true
	protected void end() {
		OI.driveController.setRumble(RumbleType.kLeftRumble, 0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}