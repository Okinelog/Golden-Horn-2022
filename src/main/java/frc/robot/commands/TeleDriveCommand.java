// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class TeleDriveCommand extends CommandBase {
  
  private final Joystick driverJoystick;

  private final DriveTrain driveTrain;

  public TeleDriveCommand(Joystick joy, DriveTrain dt) {
    this.driverJoystick = joy;
    this.driveTrain = dt;

    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(getSpeed(), getRotation());
  }

  private double getSpeed(){
    double speed = driverJoystick.getRawAxis(Constants.DriveTrainConstants.Y);
    return speed;
  }
  private double getRotation(){
    double rotation = driverJoystick.getRawAxis(Constants.DriveTrainConstants.X);
    return rotation;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
