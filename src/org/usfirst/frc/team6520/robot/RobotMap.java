package org.usfirst.frc.team6520.robot;

import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	
	public final static int FRONT_RIGHT_MOTOR_PORT = 1;
	public final static int FRONT_LEFT_MOTOR_PORT = 3;
	public final static int BACK_RIGHT_MOTOR_PORT = 0;
	public final static int BACK_LEFT_MOTOR_PORT = 2;
	
	public static VictorSP FrontLeftMotor = new VictorSP(FRONT_LEFT_MOTOR_PORT);
	public static VictorSP FrontRightMotor = new VictorSP(FRONT_RIGHT_MOTOR_PORT);
	public static VictorSP BackLeftMotor = new VictorSP(BACK_LEFT_MOTOR_PORT);
	public static VictorSP BackRightMotor = new VictorSP(BACK_RIGHT_MOTOR_PORT);
	
}
