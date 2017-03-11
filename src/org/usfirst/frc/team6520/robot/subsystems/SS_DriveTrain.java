package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.Constants;
import org.usfirst.frc.team6520.robot.MathStuff;
import org.usfirst.frc.team6520.robot.Robot;
import org.usfirst.frc.team6520.robot.RobotMap;
import org.usfirst.frc.team6520.robot.sensors.S_Display;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_DriveTrain extends Subsystem {

	
	public SS_DriveTrain() {
	}
	
	public void drive(double leftInput, double rightInput) {

		RobotMap.FrontLeftMotor.set(leftInput);
		RobotMap.BackLeftMotor.set(leftInput);
		
		RobotMap.FrontRightMotor.set(-rightInput);
		RobotMap.BackRightMotor.set(-rightInput);
	}
	
	public void spin(double angle) {
		double power;
		double currentAngle;
		double slowingPoint = angle * 0.65;
		
		Robot.gyro.reset();
    	currentAngle = 0;
    	while ((currentAngle = Math.abs(Robot.gyro.getAngle())) < angle) {
    	
    		power = MathStuff.DeceleratingTowardsTop(currentAngle, slowingPoint, angle, Constants.DEFAULT_POWER);
    		Robot.ss_DriveTrain.drive(-power, power);
    		
    		S_Display.DisplayNumbers();
    		
    		Timer.delay(Constants.MIN_DELAY_TIME);
    	}
    	
    	Robot.ss_DriveTrain.drive(0, 0);
	}
	
	public void driveByTwoJoysticks() {
		
    	double leftInput = 0;
		double rightInput = 0;
		
		if (Math.abs(Robot.oi.gamepad0.getLeftY()) > 0.0916 || Math.abs(Robot.oi.gamepad0.getRightY()) > 0.0916) {

//			 each input is the sum of the default speed provided by the stick and
//			 the ramping speed added by the trigger
			
			leftInput = (-Robot.oi.gamepad0.getLeftY()) * (Constants.DEFAULT_POWER
					+ (Constants.FULL_POWER - Constants.DEFAULT_POWER) * Robot.oi.gamepad0.getLeftTrigger());

			rightInput = (-Robot.oi.gamepad0.getRightY()) * (Constants.DEFAULT_POWER
					+ (Constants.FULL_POWER - Constants.DEFAULT_POWER) * Robot.oi.gamepad0.getRightTrigger());
		} 
		
		Robot.ss_DriveTrain.drive(leftInput, rightInput);    	
	}
	
    public void initDefaultCommand() {
    }
}

