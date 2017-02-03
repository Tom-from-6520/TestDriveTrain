package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.ControllerMap;
import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.RobotConstants;

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

		leftInput = (-Robot.oi.joystick.getRawAxis(ControllerMap.LY_AXIS))
				* (RobotConstants.DEFAULT_POWER + (RobotConstants.FULL_POWER - RobotConstants.DEFAULT_POWER)
						* Robot.oi.joystick.getRawAxis(ControllerMap.L_TRIGGER));

		rightInput = (-Robot.oi.joystick.getRawAxis(ControllerMap.RY_AXIS))
				* (RobotConstants.DEFAULT_POWER + (RobotConstants.FULL_POWER - RobotConstants.DEFAULT_POWER)
						* Robot.oi.joystick.getRawAxis(ControllerMap.R_TRIGGER));

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
		isFinished = true;
//		Robot.ss_DriveTrain.drive(0, 0);
	}
}
