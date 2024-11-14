// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkAbsoluteEncoder.Type;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private CANSparkMax m_intakeMotor;
  private DigitalInput m_IRDistanceSensor;

  public IntakeSubsystem() {
    // m_intakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    m_IRDistanceSensor = new DigitalInput(IntakeConstants.kDistanceSensorPort);
  }

  public void intake(){
    // m_intakeMotor.set(IntakeConstants.kintakeSpeed);
  }

  public void intakeStop(){
    if (m_IRDistanceSensor.get()){
      // m_intakeMotor.set(0);
    }
  }

  public void checkShoot(){
    if (m_IRDistanceSensor.get()){
      shoot();
    }
  }

  public boolean isNoteStored(){
   return m_IRDistanceSensor.get();
  }

  public void IRtest(){
    System.out.print(m_IRDistanceSensor.get());
  }

   public void shoot(){
    // m_intakeMotor.set(IntakeConstants.kShootSpeed);
  }
  // @Override
  // public void periodic() {
  //   // This method will be called once per scheduler run
  // }
}
