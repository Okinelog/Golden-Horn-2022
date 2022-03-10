// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
	private WPI_TalonSRX intake;
	private Solenoid Solenoid1;
	private Solenoid Solenoid2;

	boolean toggleIntake = false;
	boolean toggleSolenoids = false;
	public Intake() {
		Solenoid1 = new Solenoid(
			PneumaticsModuleType.CTREPCM,
			Constants.IntakeConstants.Solenoid[0]
			);
		Solenoid2 =  new Solenoid(
			PneumaticsModuleType.CTREPCM,
			Constants.IntakeConstants.Solenoid[1]
			);
		intake = new WPI_TalonSRX(Constants.IntakeConstants.Intake);
		intake.setInverted(Constants.IntakeConstants.Invert);
	}

	@Override
	public void periodic() {
		if(toggleIntake){activeIntake();}else{disabledIntake();}
		if(toggleSolenoids){activeSolenoid();}else{disabledSolenoid();}
	}
	
	public void toggleSolenoid(){
		toggleSolenoids = !toggleSolenoids;
	}

	public void activeSolenoid(){
		Solenoid1.set(true);
		Solenoid2.set(false);
	}

	public void disabledSolenoid(){
		Solenoid1.set(false);
		Solenoid2.set(true);
	}

	public void toggleIntake(){
		toggleIntake = !toggleIntake;
	}

	public void activeIntake(){
		intake.set(ControlMode.PercentOutput, Constants.IntakeConstants.Speed);
	}
	public void disabledIntake(){
		intake.stopMotor();
	}
}
