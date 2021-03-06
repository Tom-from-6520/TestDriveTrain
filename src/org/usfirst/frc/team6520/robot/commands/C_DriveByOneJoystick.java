package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.Constants;
import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.sensors.S_Display;

import edu.wpi.first.wpilibj.command.Command;


public class C_DriveByOneJoystick extends Command {

	double leftInput;
	double rightInput;
	boolean isFinished = false;

	public C_DriveByOneJoystick() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

//		 the input is the sum of the default speed provided by the stick and
//		 the ramping speed added by the trigger

		leftInput = (Robot.oi.gamepad0.getLeftX()
				- Robot.oi.gamepad0.getLeftY())
				* (Constants.DEFAULT_POWER + Robot.oi.gamepad0.getRightTrigger()
						* (Constants.FULL_POWER - Constants.DEFAULT_POWER));
		
		rightInput = (-Robot.oi.gamepad0.getLeftX()
				- Robot.oi.gamepad0.getLeftY())
				* (Constants.DEFAULT_POWER + Robot.oi.gamepad0.getRightTrigger()
						* (Constants.FULL_POWER - Constants.DEFAULT_POWER));
		
		Robot.ss_DriveTrain.drive(leftInput, rightInput);

    	S_Display.DisplayNumbers();
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
//		Robot.ss_DriveTrain.drive(0, 0);
		isFinished = true;
	}
}
