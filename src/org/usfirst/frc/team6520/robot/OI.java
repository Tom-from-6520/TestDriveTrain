package org.usfirst.frc.team6520.robot;


import org.usfirst.frc.team6520.robot.commands.C_ClimbByTime;
import org.usfirst.frc.team6520.robot.commands.C_DriveByOneJoystick;
import org.usfirst.frc.team6520.robot.commands.C_DriveByTime;
import org.usfirst.frc.team6520.robot.commands.C_ReleaseGear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	public Joystick joystick = new Joystick(ControllerMap.DRIVE_CONTROLLER);
	
	Button button1 = new JoystickButton(joystick, 1);
	Button button2 = new JoystickButton(joystick, 2);
	Button button3 = new JoystickButton(joystick, 3);
	Button button4 = new JoystickButton(joystick, 4);
	Button button5 = new JoystickButton(joystick, 5);
	Button button6 = new JoystickButton(joystick, 6);
	
	
//	for the love of the world, only one command that requires a certain subsystem is allowed to be executed 
//	when a button be pressed
	
	public OI() {
		
		button1.whileHeld(new C_DriveByTime());
		button2.whileHeld(new C_ReleaseGear());
		button3.whileHeld(new C_DriveByOneJoystick());
		button4.whileHeld(new C_ClimbByTime());
		
	}

	
}

