// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class ExtendElevator extends Command {
  /** Creates a new ExtendElevator. */
  ElevatorSubsystem m_elevator;
  double m_desiredLength;

  public ExtendElevator(ElevatorSubsystem elevator, double desiredLength) {
    m_elevator = elevator;
    m_desiredLength = desiredLength;
    addRequirements(m_elevator);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_elevator.extendElevator(m_desiredLength);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevator.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_elevator.lengthReached(m_desiredLength);
  }
}
