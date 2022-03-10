package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.ShooterConstants;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ShooterTimed;
import frc.robot.commands.TeleDriveCommand;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;


public class RobotContainer {
	
	private DriveTrain driveTrain = new DriveTrain();
	private Intake intake = new Intake();
	private Indexer indexer = new Indexer();
	private Shooter shooter = new Shooter();
	private Climb climb = new Climb();
	private Joystick driver = new Joystick(Constants.Joystickconstants.Driver);
	private Joystick co = new Joystick(Constants.Joystickconstants.Co);

	public RobotContainer() {
		//driveTrain.setDefaultCommand(new TeleDriveCommand(driver, driveTrain));
		//configureButtonBindings();
		ClimbButtons();
		ShooterButtons();
		IndexerButtons();
		IntakeButtons();
	}

	private void configureButtonBindings() {
		
	}

	public Command getAutonomousCommand() {
		// An ExampleCommand will run in autonomous
		return null;
	}

	private void ClimbButtons(){
		new JoystickButton(co, 4)
			.whenPressed(
				new ClimbCommand(climb, true)
			);
		new JoystickButton(co, 1)
			.whenPressed(
				new ClimbCommand(climb, false)
			);
		new JoystickButton(co, 3)
			.whenPressed(
				() -> climb.PumpClimb()
			);
		new JoystickButton(co, 2)
			.whenPressed(
				() -> climb.NoPumpClimb()
			);
	}

	private void ShooterButtons(){
		new JoystickButton(driver, 3)
			.whenHeld(
				new ShooterTimed(shooter)
				);
	}

	private void IndexerButtons(){
		new JoystickButton(driver, 2)
			.whenPressed(() -> indexer.toggleIndexer());
	}

	private void IntakeButtons(){
		new JoystickButton(driver, 4)
			.whenPressed(() -> intake.toggleIntake());
		new JoystickButton(driver, 1)
			.whenPressed(() -> intake.toggleSolenoid());
	}

}
