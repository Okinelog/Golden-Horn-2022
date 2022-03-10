package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
	private WPI_VictorSPX leftMaster;
	private WPI_VictorSPX leftSlave;
	private WPI_VictorSPX rightMaster;
	private WPI_VictorSPX rightSlave;

	private DifferentialDrive drive;

	public DriveTrain() {
		leftMaster = new WPI_VictorSPX(Constants.DriveTrainConstants.MasterLeft);
		leftSlave = new WPI_VictorSPX(Constants.DriveTrainConstants.SlaveLeft);
		rightMaster = new WPI_VictorSPX(Constants.DriveTrainConstants.MasterRight);
		rightSlave = new WPI_VictorSPX(Constants.DriveTrainConstants.SlaveRight);

		leftSlave.follow(leftMaster);
		rightSlave.follow(rightMaster);

		drive = new DifferentialDrive(leftMaster, rightMaster);

		drive.setSafetyEnabled(false);

	}
	boolean isSlowMode = false;
	public void arcadeDrive(double speed, double rotation){
		double xSpeed = speed;
		double zRotation = rotation;

		if(isSlowMode){
			xSpeed *= 0.3;
			zRotation *= 0.6;
		}

		leftMaster.set(ControlMode.PercentOutput, xSpeed, DemandType.ArbitraryFeedForward, +zRotation);
		rightMaster.set(ControlMode.PercentOutput, xSpeed, DemandType.ArbitraryFeedForward, -zRotation);
	}

	double Deadband(double i){
		return ((i >= +0.09) ? i : ((i <= -0.09) ? i : 0));
	}
		
	public void changeSlowMode(){
		if (isSlowMode){
			isSlowMode = false;
		}else{
			isSlowMode = true;
		}
	}
	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
