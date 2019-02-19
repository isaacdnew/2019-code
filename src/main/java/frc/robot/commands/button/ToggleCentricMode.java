package frc.robot.commands.button;

import frc.robot.subsystems.Drivetrain;
import org.usfirst.frc4048.swerve.math.CentricMode;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Switches the robot from field centric to robot centric, or vice versa.
 */
public class ToggleCentricMode extends Command {

	private Drivetrain drivetrain;
	private XboxController controller;

	public ToggleCentricMode(Drivetrain drivetrain, XboxController controller) {
		this.drivetrain = drivetrain;
		this.controller = controller;
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		if (drivetrain.getCentricMode() == CentricMode.ROBOT) {
			drivetrain.setCentricMode(CentricMode.FIELD);
			controller.setRumble(RumbleType.kRightRumble, 1.0);
			Timer.delay(0.2);
			controller.setRumble(RumbleType.kRightRumble, 0.0);
		} else if (drivetrain.getCentricMode() == CentricMode.FIELD) {
			drivetrain.setCentricMode(CentricMode.ROBOT);
			controller.setRumble(RumbleType.kLeftRumble, 1.0);
			Timer.delay(0.2);
			controller.setRumble(RumbleType.kLeftRumble, 0.0);
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}