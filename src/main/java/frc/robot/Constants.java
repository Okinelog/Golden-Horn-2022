// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class Joystickconstants{
        // Port
        public static final int Driver = 0;
        public static final int Co = 1;
    }
    public static final class DriveTrainConstants{
        // Port
        public static final int MasterLeft = 1;
        public static final int MasterRight = 3;
        public static final int SlaveLeft = 2;
        public static final int SlaveRight = 4;
        // Axis
        public static final int Y = 2;
        public static final int X = 1;
    }
    public static final class IntakeConstants{
        // Port
        public static final int Intake = 31;
        public static final int[] Solenoid = {0,1};
        // Speed
        public static final double Speed = 0.5;
        // Invert
        public static final boolean Invert = false;
    }
    public static final class IndexerConstants{
        // Port
        public static final int Indexer = 6;
        // Speed 
        public static final double Speed = 0.5;
        // Invert
        public static final boolean Invert = false;
    }
    public static final class ShooterConstants{
        // Port
        public static final int Shooter = 9;
        public static final int beforeShooter = 5;
        // Speed
        public static final double Speed = -1;
        public static final double beforeSpeed = 0.3;
        // Time
        public static final double Time = 1.5;
    }
    public static final class ClimbConstants{
        // Port
        public static final int Climb1 = 7;
        public static final int Climb2 = 8;
        public static final int Solenoid1 = 2;
        public static final int Solenoid2 = 3;
        // Speed
        public static final double Speed = 0.7;
    }
}
