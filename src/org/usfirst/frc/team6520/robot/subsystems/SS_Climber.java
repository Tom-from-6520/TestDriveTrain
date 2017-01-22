package org.usfirst.frc.team6520.robot.subsystems;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void Climb(double power) {
		RobotMap.ClimbingMotor.set(power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

