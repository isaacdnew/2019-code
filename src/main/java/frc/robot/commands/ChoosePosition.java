package frc.robot.commands;

import frc.robot.subsystems.ClawWrist;
import frc.robot.subsystems.ClawWrist.ClawWristPosition;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Switches the robot from field centric to robot centric, or vice versa.
 */
public class ChoosePosition extends Command {

	private ClawWrist clawWrist;

	public ChoosePosition(ClawWrist clawWrist) {
		this.clawWrist = clawWrist;
		requires(clawWrist);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (SmartDashboard.getBoolean("Beak is front", false)) {
			clawWrist.setPosition(ClawWristPosition.STOWED);
			System.out.println("beak is front; stowing");
		} else {
			if (clawWrist.getPosition() == ClawWristPosition.LEVEL
					&& SmartDashboard.getBoolean("Elevator at bottom", false)) {
				clawWrist.setPosition(ClawWristPosition.DOWN);
			} else if (clawWrist.getPosition() == ClawWristPosition.DOWN
					&& !SmartDashboard.getBoolean("Elevator at bottom", false)) {
				clawWrist.setPosition(ClawWristPosition.LEVEL);
			}
			System.out.println("beak is not front; normal");
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}