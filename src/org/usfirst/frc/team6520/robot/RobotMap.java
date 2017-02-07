package org.usfirst.frc.team6520.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
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
	
	
	private final static int FRONT_RIGHT_MOTOR_PORT = 0;
	private final static int FRONT_LEFT_MOTOR_PORT = 2;
	private final static int BACK_RIGHT_MOTOR_PORT = 1;
	private final static int BACK_LEFT_MOTOR_PORT = 3;
	
	public static VictorSP FrontLeftMotor = new VictorSP(FRONT_LEFT_MOTOR_PORT);
	public static VictorSP FrontRightMotor = new VictorSP(FRONT_RIGHT_MOTOR_PORT);
//	public static VictorSP BackLeftMotor = new VictorSP(BACK_LEFT_MOTOR_PORT);
	public static Spark BackLeftMotor = new Spark(BACK_LEFT_MOTOR_PORT);
//	public static VictorSP BackRightMotor = new VictorSP(BACK_RIGHT_MOTOR_PORT);
	public static Spark BackRightMotor = new Spark(BACK_RIGHT_MOTOR_PORT);
	
	
//	private final static int CLIMBING_MOTOR = 4;
//	
//	public static VictorSP ClimbingMotor = new VictorSP(CLIMBING_MOTOR);	
	private final static int CLIMBING_MOTOR = 4;
	
	public static Spark ClimbingMotor = new Spark(CLIMBING_MOTOR);
	
	
	private final static int FORWARD_ARM_PORT = 0;
	private final static int REVERSE_ARM_PORT = 1;
	
	public static DoubleSolenoid Solenoid = new DoubleSolenoid(FORWARD_ARM_PORT, REVERSE_ARM_PORT);
	
}
