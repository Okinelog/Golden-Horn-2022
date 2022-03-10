// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
	
	VictorSPX beforeShooter;
	TalonFX shooter;

	public Shooter() {
		beforeShooter = new VictorSPX(Constants.ShooterConstants.beforeShooter);
		shooter = new TalonFX(Constants.ShooterConstants.Shooter);
	}
	public void activeBefore(){
		beforeShooter.set(
			ControlMode.PercentOutput, 
			Constants.ShooterConstants.beforeSpeed
			);
	}
	public void disableBefore(){
		beforeShooter.set(ControlMode.Disabled, 0);
	}
	public void activeShooter(){
		shooter.set(
			ControlMode.PercentOutput,
			Constants.ShooterConstants.Speed
			);
	}
	public void disableShooter(){
		shooter.set(ControlMode.Disabled,0);
	}
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
