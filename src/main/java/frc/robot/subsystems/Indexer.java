// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
	CANSparkMax indexer;
	Boolean ToggleIndexer = false;
	public Indexer() {
		indexer = new CANSparkMax(
			Constants.IndexerConstants.Indexer,
			MotorType.kBrushless
		);

		indexer.setInverted(Constants.IndexerConstants.Invert);
	}

	public void toggleIndexer(){
		ToggleIndexer = !ToggleIndexer;
	}

	public void ActiveIndexer(){
		indexer.set(Constants.IndexerConstants.Speed);
	}

	public void DisableIndexer(){
		indexer.stopMotor();
	}

	@Override
	public void periodic() {
		if(ToggleIndexer){
			ActiveIndexer();
		}
		else{
			DisableIndexer();
		}
	}
}
