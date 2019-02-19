/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// DRIVETRAIN
	public static final int DRIVETRAIN_DRIVE_1 = 3;
	public static final int DRIVETRAIN_DRIVE_2 = 2;
	public static final int DRIVETRAIN_DRIVE_3 = 6;
	public static final int DRIVETRAIN_DRIVE_4 = 7;

	public static final boolean DRIVETRAIN_DRIVE_1_INV = true;
	public static final boolean DRIVETRAIN_DRIVE_2_INV = false;
	public static final boolean DRIVETRAIN_DRIVE_3_INV = false;
	public static final boolean DRIVETRAIN_DRIVE_4_INV = true;

	public static final int DRIVETRAIN_STEER_1 = 4;
	public static final int DRIVETRAIN_STEER_2 = 1;
	public static final int DRIVETRAIN_STEER_3 = 5;
	public static final int DRIVETRAIN_STEER_4 = 8;

	public static final boolean DRIVETRAIN_STEER_1_INV = false;
	public static final boolean DRIVETRAIN_STEER_2_INV = false;
	public static final boolean DRIVETRAIN_STEER_3_INV = false;
	public static final boolean DRIVETRAIN_STEER_4_INV = false;

	// ELEVATOR
	public static final int ELEVATOR_LEFT_MOTOR = 0; // Victor SP
	public static final int ELEVATOR_RIGHT_MOTOR = 1; // Victor SP
	public static final int ELEVATOR_LIMIT_TOP = 0;
	public static final int ELEVATOR_LIMIT_BOTTOM = 1;
	public static final boolean ELEVATOR_LEFT_INVERTED = true;
	public static final boolean ELEVATOR_RIGHT_INVERTED = false;

	// CLAW
	public static final int CLAW_MOTOR_TOP = 3; // Victor SP
	public static final int CLAW_MOTOR_BOTTOM = 2; // Victor SP
	public static final boolean CLAW_TOP_INVERTED = true;
	public static final boolean CLAW_BOTTOM_INVERTED = false;

	// CLAW WRIST
	public static final int CLAW_WRIST_MOTOR = 10; // Talon SRX
	public static final boolean CLAW_WRIST_MOTOR_INVERTED = false;

	// BEAK
	public static final int BEAK_MOTOR = 9; // Victor SP
	public static final boolean BEAK_MOTOR_INVERTED = true;

	// BEAK WRIST
	public static final int BEAK_WRIST_MOTOR = 9; // Talon SRX
	public static final boolean BEAK_WRIST_MOTOR_INVERTED = false;

	// RAMPS
	public static final int[] L_SOL_PORTS = { 6, 7 };
	public static final int[] R_SOL_PORTS = { 1, 0 };
}