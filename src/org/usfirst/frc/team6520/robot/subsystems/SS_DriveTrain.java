
package org.usfirst.frc.team6520.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SS_DriveTrain extends Subsystem {

	final int FRONT_RIGHT_MOTOR_PORT = 1;
	final int FRONT_LEFT_MOTOR_PORT = 4;
	final int BACK_RIGHT_MOTOR_PORT = 0;
	final int BACK_LEFT_MOTOR_PORT = 3;
	
	VictorSP FrontLeftMotor = new VictorSP(FRONT_LEFT_MOTOR_PORT);
	VictorSP FrontRightMotor = new VictorSP(FRONT_RIGHT_MOTOR_PORT);
	VictorSP BackLeftMotor = new VictorSP(BACK_LEFT_MOTOR_PORT);
	VictorSP BackRightMotor = new VictorSP(BACK_RIGHT_MOTOR_PORT);

	public void driveByJoystick(double power) {
		FrontLeftMotor.set(power);
    	BackLeftMotor.set(power);
    	
		FrontRightMotor.set(-power);
		BackRightMotor.set(-power);
    }
	
    public void initDefaultCommand() {
    }
}

