
package org.usfirst.frc.team6520.robot;

import org.usfirst.frc.team6520.robot.autonomous_commands.AC_DriveThreeSecsDefaultPow;
import org.usfirst.frc.team6520.robot.autonomous_commands.AC_Example;
import org.usfirst.frc.team6520.robot.autonomous_commands.AC_Spin180Degrees;
import org.usfirst.frc.team6520.robot.oi.OI;
import org.usfirst.frc.team6520.robot.subsystems.SS_Climber;
import org.usfirst.frc.team6520.robot.subsystems.SS_DriveTrain;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static RobotDrive driver;
	
	public static OI oi;

	public static SS_DriveTrain ss_DriveTrain = new SS_DriveTrain();
	public static SS_Climber ss_Climber = new SS_Climber();
	
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro(Port.kOnboardCS0);
	
    Command autonomousCommand;
    SendableChooser<String> chooser;


    public void initCamera() {
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    	camera.setResolution(1280, 720);
    }
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
//    	initCamera();
    	
		oi = new OI();
		
		driver = new RobotDrive(RobotMap.FrontLeftMotor, RobotMap.BackLeftMotor, RobotMap.FrontRightMotor, RobotMap.BackRightMotor);
		
        chooser = new SendableChooser<String>();
        
        chooser.addDefault("spin", "spin");
        chooser.addObject("spin", "spin");
        chooser.addObject("drive", "drive");
        chooser.addObject("example", "example");
        SmartDashboard.putData("Auto mode", chooser);
        
        
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
//        autonomousCommand = (Command) chooser.getSelected();
        
		 String autoSelected = (String) chooser.getSelected();
		 SmartDashboard.putString("auto mode", autoSelected);
		 
		switch(autoSelected) {
		case "drive":
			autonomousCommand = new AC_DriveThreeSecsDefaultPow();
			break;
		case "spin":
			autonomousCommand = new AC_Spin180Degrees();
			break;
		case "example":
			autonomousCommand = new AC_Example();
			break;
		default:
			autonomousCommand = null;
			break;
		} 
    	
        
//      autonomousCommand = new AC_Example();
//    	autonomousCommand = new AC_DriveThreeSecsDefaultPow();
//    	autonomousCommand = new AC_SpinOneSecDefaultPow();
//    	autonomousCommand = new AC_Spin180Degrees();
        
        
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
        SmartDashboard.putData("Auto mode", chooser);
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
