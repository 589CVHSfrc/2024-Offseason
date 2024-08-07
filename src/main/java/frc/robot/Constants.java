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
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;


  //================================ELEVATOR CONSTANTS===================================================================

  public static final class ElevatorConstants{
    public static final double AmpLength = 1.0; //finnler
    public static final double ExtendingSpeed = 1.0; //finler
    public static final double MaxLength = 1.0; //filenr
    public static final double HomedLength = 1.0; //filnerr
  }

  //================================INTAKE CONSTANTS===================================================================

  public static final class IntakeConstants{
    public static final double TopRollerSpeed = 1.0; //ffo;aer
    public static final double BottomRollerSpeed = 1.0; //filer
  }

  //================================DRIVE CONSTANTS====================================================================

  public static final class DriveConstants{
    
  }
  }
}
