package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ChoosePosition;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawWrist extends Subsystem {
	private WPI_TalonSRX m;

	private final double P = 4.0;
	private final double I = 0.0;
	private final double D = 0.0;
	private final double F = 0.0;

	private final double revsPerTick = 1.0 / 1024.0;
	private final double beltRatio = 15.0 / 24.0;

	public enum ClawWristPosition {
		STOWED, LEVEL, DOWN
	}

	private ClawWristPosition position;

	public ClawWrist() {
	}

	public void init() {
		m = new WPI_TalonSRX(RobotMap.CLAW_WRIST_MOTOR);
		m.setInverted(RobotMap.CLAW_WRIST_MOTOR_INVERTED);
		m.configSelectedFeedbackSensor(FeedbackDevice.Analog);
		m.selectProfileSlot(0, 0);
		m.config_kP(0, P);
		m.config_kI(0, I);
		m.config_kD(0, D);
		m.config_kF(0, F);
		m.configMaxIntegralAccumulator(0, 8);
		m.setSelectedSensorPosition(0);
		setPosition(ClawWristPosition.STOWED);
	}

	public void setPosition(ClawWristPosition position) {
		switch (position) {
		case STOWED:
			setPosition(0);
			position = ClawWristPosition.STOWED;
			break;
		case LEVEL:
			setPosition(60);
			position = ClawWristPosition.LEVEL;
			break;
		case DOWN:
			setPosition(90);
			position = ClawWristPosition.DOWN;
			break;
		}
	}

	private void setPosition(double degreesFromStowed) {
		// convert angle into encoder ticks
		double pulleyAngle = degreesFromStowed / beltRatio;
		double pulleyRevs = pulleyAngle / 360.0;
		double ticks = pulleyRevs / revsPerTick;

		// set motor setpoint
		m.set(ControlMode.Position, ticks);
	}

	public ClawWristPosition getPosition() {
		return position;
	}

	public double getPositionTicks() {
		return m.getSelectedSensorPosition();
	}

	public double getPositionRevs() {
		return m.getSelectedSensorPosition() * revsPerTick * beltRatio;
	}

	public double getPositionDegrees() {
		return m.getSelectedSensorPosition() * revsPerTick * beltRatio * 360.0;
	}

	public void goLimp() {
		m.stopMotor();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ChoosePosition(this));
	}
}
