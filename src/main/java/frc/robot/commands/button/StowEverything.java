package frc.robot.commands.button;

import frc.robot.OI;
import frc.robot.subsystems.BeakWrist;
import frc.robot.subsystems.ClawWrist;
import frc.robot.subsystems.ClawWrist.ClawWristPosition;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Switches the robot from field centric to robot centric, or vice versa.
 */
public class StowEverything extends Command {

	private ClawWrist clawWrist;
	private BeakWrist beakWrist;
	private double startTime;
	private final double duration = 0.5;

	public StowEverything(ClawWrist clawWrist, BeakWrist beakWrist) {
		this.clawWrist = clawWrist;
		this.beakWrist = beakWrist;
		requires(clawWrist);
		requires(beakWrist);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		clawWrist.setPosition(ClawWristPosition.STOWED);
		beakWrist.move(-1);
		OI.liftController.setRumble(RumbleType.kLeftRumble, 1.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() >= startTime + duration;
	}

	// Called once after isFinished returns true
	protected void end() {
		OI.liftController.setRumble(RumbleType.kLeftRumble, 0.0);
		beakWrist.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}