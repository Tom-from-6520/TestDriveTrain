package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.RobotMap;
import org.usfirst.frc.team6520.robot.commands.C_DriveByTwoJoysticks;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public SS_DriveTrain() {
	}
	
	public void drive(double leftInput, double rightInput) {

		RobotMap.FrontLeftMotor.set(leftInput);
		RobotMap.BackLeftMotor.set(leftInput);
		
		RobotMap.FrontRightMotor.set(-rightInput);
		RobotMap.BackRightMotor.set(-rightInput);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new C_DriveByTwoJoysticks());
    }
}

