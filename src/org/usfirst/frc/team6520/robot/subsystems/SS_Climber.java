package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Climber extends Subsystem {


	public void Climb(double power) {
		RobotMap.ClimbingMotor.set(power);
	}
	
    public void initDefaultCommand() {
    }
}

