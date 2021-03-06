package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.Constants;
import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class C_ClimbByTime extends Command {

	public C_ClimbByTime() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		
		requires(Robot.ss_RopeClimber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.joystick1.getSlider() <= -0.916) {
			RobotMap.ClimbingMotor.set(Constants.FULL_POWER);
		} else {
			RobotMap.ClimbingMotor.set(0);
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
		RobotMap.ClimbingMotor.set(0);
	}
}
