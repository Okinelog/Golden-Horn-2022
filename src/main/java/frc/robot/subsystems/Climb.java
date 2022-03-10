// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
	CANSparkMax climb1;
	CANSparkMax climb2;

	Solenoid sol1;
	Solenoid sol2;
	public Climb() {
		climb1 = new CANSparkMax(
			Constants.ClimbConstants.Climb1,
			MotorType.kBrushless
			);
		climb2 = new CANSparkMax(
			Constants.ClimbConstants.Climb2,
			MotorType.kBrushless
		);
		climb2.follow(climb1);

		sol1 = new Solenoid(
			PneumaticsModuleType.CTREPCM,
			Constants.ClimbConstants.Solenoid1
			);
		sol2 = new Solenoid(
			PneumaticsModuleType.CTREPCM,
			Constants.ClimbConstants.Solenoid2
			);
	}

	public void ActiveClimb(){
		climb1.set(Constants.ClimbConstants.Speed);
	}
	public void ReverseClimb(){
		climb1.set(-Constants.ClimbConstants.Speed);
	}
	public void DisableClimb(){
		climb1.stopMotor();
	}
	public void PumpClimb(){
		sol1.set(true);
		sol2.set(false);
	}
	public void NoPumpClimb(){
		sol1.set(false);
		sol2.set(true);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
