package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class C_TurnByTime extends Command {

    public C_TurnByTime() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ss_DriveTrain.drive(RobotConstants.DEFAULT_POWER, (-RobotConstants.DEFAULT_POWER));
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
    	Robot.ss_DriveTrain.drive(0, 0);
    }
}
