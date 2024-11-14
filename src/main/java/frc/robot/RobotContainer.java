// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WrapperCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants.ElevatorConstants;
import frc.robot.Constants.OperatorConstants.OIConstants;
import frc.robot.commands.Drive.DefaultDrive;
import frc.robot.commands.Elevator.ExtendElevator;
import frc.robot.commands.Elevator.HomeElevator;
import frc.robot.commands.Intake.IntakeSource;
import frc.robot.commands.Intake.Shoot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.utils.CommandSupplier;

public class RobotContainer {
        private final static DriveSubsystem m_robotDrive = new DriveSubsystem();

        private final static XboxController m_driverController = new XboxController(OIConstants.kDriverControllerPort);
        private final static GenericHID m_coDriverSwitchBoard = new GenericHID(OIConstants.kCODriverControllerPort);
        private final static GenericHID m_coDriverJoystick = new GenericHID(3);
        private final static GenericHID m_coDriverJoystick2 = new GenericHID(4);

        private final static ElevatorSubsystem m_elevator = new ElevatorSubsystem();
        private final static IntakeSubsystem m_intake = new IntakeSubsystem();
        // private final static DriveSubsystem m_driver = new DriveSubsystem();

        private SendableChooser<Command> m_autoChooser = new SendableChooser<>();

        public RobotContainer() {

                SmartDashboard.putData(m_autoChooser);


                configureButtonBindings();
                // m_autoChooser.setDefaultOption("Forward", new PathPlannerAuto("Forward"));
                // m_autoChooser.addOption("2 Note Preload", new PathPlannerAuto("2Note Preload"));
                // m_autoChooser.addOption("!!!!NOTHING!!!!!", new WaitCommand(2));
                // m_autoChooser.addOption("Shoot Only - Speaker", new PathPlannerAuto("Shoot Only - Speaker"));
                // // m_autoChooser.addOption("Shoot and Note 1 - Amp ", new PathPlannerAuto("Shoot
                // // and Note 1 - Amp"));
                // m_autoChooser.addOption("Shoot Only - Amp", new PathPlannerAuto("Shoot Only - Amp"));

                // m_autoChooser.addOption("Shoot (Source Side) and Taxi",
                //                 new PathPlannerAuto("Shoot (Source Side) and Taxi"));

                // m_autoChooser.addOption("WAIT Speaker Taxi (Amp side)",
                //                 new PathPlannerAuto("WAIT Speaker Taxi (Amp side)"));

                // // m_robotArm.setDefaultCommand(new MoveArmSpeed(m_robotArm, () ->
                // // m_testjoystick1.getRawAxis(1)*.1));

                m_robotDrive.setDefaultCommand(new DefaultDrive(m_robotDrive,
                                () -> -MathUtil.applyDeadband(m_driverController.getLeftX(),//we Changed this to X from Y
                                                OIConstants.kDriveDeadband),
                                () -> -MathUtil.applyDeadband(m_driverController.getLeftY(),//we Changed this from X to Y
                                                OIConstants.kDriveDeadband),
                                () -> -MathUtil.applyDeadband(m_driverController.getRawAxis(2) * .75,
                                                OIConstants.kDriveDeadband))
                                                );
        }

        private void configureButtonBindings() {

                new JoystickButton(m_driverController, 0).onTrue(new ExtendElevator(m_elevator, ElevatorConstants.kAmpLength));

                new JoystickButton(m_driverController, 0).onTrue(new Shoot(m_intake));

                new JoystickButton(m_driverController, 0).onTrue(new IntakeSource(m_intake));

                new JoystickButton(m_driverController, 0).onTrue(new HomeElevator(m_elevator, ElevatorConstants.kHomedLength));
        }

        public void flipGyro() {
                m_robotDrive.flipHeading();
        }

        public void alignWheels() {
                m_robotDrive.alignWheels();
        }

        public Command getAutonomousCommand() {
                // return new DriveBack(m_robotDrive);
                // try {

                //         Pose2d startingpose = PathPlannerAuto
                //                         .getStaringPoseFromAutoFile(m_autoChooser.getSelected().getName());
                //         m_robotDrive.resetOdometry(startingpose.rotateBy(new Rotation2d(Units.degreesToRadians(180))));
                //         System.out.print("====================STARTING POSE: " + startingpose +
                //                         "====================");

                //         return m_autoChooser.getSelected();
                // } catch (RuntimeException e) {
                //         System.out.print("==================" + e);
                //         System.out.print("COULD NOT FIND AUTO WITH SELECTED NAME"
                //                         + m_autoChooser.getSelected().getName());
                //         return new WaitCommand(1);
                // }


                SmartDashboard.putNumber("LeftY", m_driverController.getLeftY());
                SmartDashboard.putNumber("LeftX", m_driverController.getLeftX());
                SmartDashboard.putNumber("AXIS", m_driverController.getRawAxis(2)*.75);
                // Brandon was here
                

                return new WaitCommand(1);
                
        }

}