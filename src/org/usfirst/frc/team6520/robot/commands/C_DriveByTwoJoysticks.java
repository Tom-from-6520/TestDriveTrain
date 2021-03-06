package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.Constants;
import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.oi.OI_Gamepad;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class C_DriveByTwoJoysticks extends Command {

	boolean isFinished = false;
	double leftInput;
	double rightInput;

	public C_DriveByTwoJoysticks() {
		requires(Robot.ss_DriveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		// each input is the sum of the default speed provided by the stick and
		// the ramping speed added by the trigger

		leftInput = (-Robot.oi.gamepad0.getRawAxis(OI_Gamepad.LY_AXIS))
				* (Constants.DEFAULT_POWER + (Constants.FULL_POWER - Constants.DEFAULT_POWER)
						* Robot.oi.gamepad0.getRawAxis(OI_Gamepad.L_TRIGGER));

		rightInput = (-Robot.oi.gamepad0.getRawAxis(OI_Gamepad.RY_AXIS))
				* (Constants.DEFAULT_POWER + (Constants.FULL_POWER - Constants.DEFAULT_POWER)
						* Robot.oi.gamepad0.getRawAxis(OI_Gamepad.R_TRIGGER));

		Robot.ss_DriveTrain.drive(leftInput, rightInput);

    	SmartDashboard.putNumber("angle", Robot.gyro.getAngle());
    	SmartDashboard.putNumber("rate of rotation", Robot.gyro.getRate());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
//		isFinished = true;
		Robot.ss_DriveTrain.drive(0, 0);
	}
}
