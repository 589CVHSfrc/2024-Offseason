// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DigitalInput;

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
    public static final int kLeftElevatorMotorCanID = 42;
    public static final int kRightElevatorMotorCanID = 32;
    public static final double kAmpLength = 0; //finnler
    public static final double kExtendingSpeed = 0; //finler
    public static final double kMaxLength = 0; //filenr
    public static final double kHomedLength = 0; //filnerr
    public static final double kElevatorDeadZone = 0; //filnera
    public static final double kSourceHeight = 0; //fihlern
  }

  //================================INTAKE CONSTANTS===================================================================

  public static final class IntakeConstants{
    public static final double kintakeSpeed = 0; //ffo;aer
    public static final double kintakeExtendHeight = 0; //filaer
    public static final int kDistanceSensorPort = 9; //
    public static final double kShootSpeed = 0;   
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kCODriverControllerPort = 1;
    public static final double kDriveDeadband = 0.1;
  }

  //================================SHOOTER CONSTANTS==================================================================

  // public static final class ShooterConstants{
  //   public static final double kshooterSpeed = 0; //filpern
  //   public static final double kstopShoot = 0; //f1llmn
  // }

  //================================NEO MOTOR CONSTANTS================================================================

  public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
  }

  //================================AUTO CONSTANTS=====================================================================

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 4.45;// 4.45;// 1
    public static final double kMaxAccelerationMetersPerSecondSquared = 5;// 2
    public static final double kMaxAngularSpeedRadiansPerSecond = 10.37;// pi
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI * 5;// pi

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profiled robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }

  //================================MODULE CONSTANTS===================================================================

  public static final class ModuleConstants {
    // The MAXSwerve module can be configured with one of three pinion gears: 12T,
    // 13T, or 14T.
    // This changes the drive speed of the module (a pinion gear with more teeth
    // will result in a
    // robot that drives faster).
    public static final int kDrivingMotorPinionTeeth = 13;// 12;

    // Invert the turning encoder, since the output shaft rotates in the opposite
    // direction of
    // the steering motor in the MAXSwerve Module.
    public static final boolean kTurningEncoderInverted = true;

    // Calculations required for driving motor conversion factors and feed forward
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    public static final double kWheelDiameterMeters = 0.075797771765;// 0.0762;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
    // teeth on the bevel pinion
    public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;

    public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction; // meters
    public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction) / 60.0; // meters per second

    public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
    public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second

    public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians

    // public static final double kDrivingP = 0.00006;// 0.04;\
    public static final double kDrivingP = 0.04;// 0.04;
    public static final double kDrivingI = 0; // 0.0001;
    public static final double kDrivingD = 0;
    public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
    public static final double kDrivingMinOutput = -1;
    public static final double kDrivingMaxOutput = 1;

    // public static final double kTurningP = 0.55;// 0.5;
    public static final double kTurningP = 1.0;// 0.6;// 0.5(manufacture example) //1.1(9 inches)//1(2102 example)
    public static final double kTurningI = 0.0;
    public static final double kTurningD = 0.0;
    public static final double kTurningFF = 0;
    public static final double kTurningMinOutput = -1;
    public static final double kTurningMaxOutput = 1;

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

    public static final int kDrivingMotorCurrentLimit = 50; // amps
    public static final int kTurningMotorCurrentLimit = 20; // amps
  }

  //================================DRIVE CONSTANTS====================================================================

    public static final class DriveConstants {

    public static final Pose2d kShootingPoseSpeakerRED = new Pose2d(14, 2, new Rotation2d(0));
    public static final Pose2d kShootingPoseSpeakerBLUE = new Pose2d(15.5, 2.6,
        new Rotation2d(Units.degreesToRadians(180)));

    public static final Pose2d kIntakeSourceRED = new Pose2d(.57, 1.18, new Rotation2d(Units.degreesToRadians(-120)));
    public static final Pose2d kIntakeSourceBLUE = new Pose2d(15.98, 1.18,
        new Rotation2d(Units.degreesToRadians(-60)));

    public static final Pose2d kShootingPoseAmpRED = new Pose2d(14.70, 7.86,
        new Rotation2d(Units.degreesToRadians(90)));
    public static final Pose2d kShootingPoseAmpBLUE = new Pose2d(1.84, 7.86,
        new Rotation2d(Units.degreesToRadians(90)));
    // Y = 7.83
    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds
    public static final double kMaxSpeedMetersPerSecond = 4.45;// ---> CHANGE 4.45 hello! 5
    public static final double kMaxAngularSpeed = 10.37; // --> CHANGE 10.32 hello!

    public static final double kDirectionSlewRate = 10; // 1.2 radians per second
    public static final double kMagnitudeSlewRate = 10; // 1.8 // percent per second (1 = 100%)
    public static final double kRotationalSlewRate = 10; // 2.0 percent per second (1 = 100%)

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(25.5);// 29
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(25.5);// 29
    // Distance between front and back wheels on robot
    public static final double kDrivePlatformRadius = Math.sqrt(2.0 * Math.pow(kWheelBase / 2.0, 2));
    // Distance from the robot center to the center of a swerve module
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
    public static final double kFrontRightChassisAngularOffset = 0;
    public static final double kBackLeftChassisAngularOffset = Math.PI;
    public static final double kBackRightChassisAngularOffset = Math.PI / 2;

    public static final int kFrontLeftDrivingCanId = 40;
    public static final int kRearLeftDrivingCanId = 20;
    public static final int kFrontRightDrivingCanId = 30;
    public static final int kRearRightDrivingCanId = 10; // 

    public static final int kFrontLeftTurningCanId = 41;
    public static final int kRearLeftTurningCanId = 21;
    public static final int kFrontRightTurningCanId = 31;
    public static final int kRearRightTurningCanId = 11;

    public static final double kAutoTimeDtSecondsAdjust = 0.02; // ?????????????????????

    public static final int kPigeon2CanId = 60;

    public static final boolean kGyroReversed = false;// false;
  }
  }
}
