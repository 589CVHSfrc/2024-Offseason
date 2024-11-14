// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class HomeElevator extends Command {
  /** Creates a new HomeElevator. */

  ElevatorSubsystem m_homer;
  double m_desiredLength;

  public HomeElevator(ElevatorSubsystem homer, double desiredLength) {
    m_homer = homer;
    m_desiredLength = desiredLength;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_homer.extendElevator(m_desiredLength);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_homer.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_homer.lengthReached(m_desiredLength);
  }
}
