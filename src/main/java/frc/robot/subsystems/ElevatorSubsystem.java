// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAbsoluteEncoder.Type;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkLimitSwitch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants.ElevatorConstants;



public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new Elevator. */
  private double m_desiredLength;
  private CANSparkMax m_leftElevatorMotor;
  private CANSparkMax m_rightElevatorMotor;
  private SparkLimitSwitch m_bottomLimitSwitch;
  private SparkLimitSwitch m_topLimitSwitch;
  private AbsoluteEncoder m_elevatorEncoder;

  
// NEED TO ADD STUFF FOR RIGHT ELEVATOR MOTOR!! IMPORTANT
  public ElevatorSubsystem() {
    m_leftElevatorMotor = new CANSparkMax(ElevatorConstants.kLeftElevatorMotorCanID, MotorType.kBrushless);
    m_rightElevatorMotor = new CANSparkMax(ElevatorConstants.kRightElevatorMotorCanID, MotorType.kBrushless);
    m_desiredLength = 0;

    m_bottomLimitSwitch = m_leftElevatorMotor.getReverseLimitSwitch(com.revrobotics.SparkLimitSwitch.Type.kNormallyClosed);
    m_topLimitSwitch = m_leftElevatorMotor.getForwardLimitSwitch(com.revrobotics.SparkLimitSwitch.Type.kNormallyOpen);
    m_elevatorEncoder = m_leftElevatorMotor.getAbsoluteEncoder(Type.kDutyCycle);
  }

  public void extendElevator(double desiredLength){
    m_desiredLength = desiredLength;
    if (desiredLength > getAbsoluteLength()){
      m_leftElevatorMotor.set(ElevatorConstants.kExtendingSpeed);
    }
    else{
      m_leftElevatorMotor.set((ElevatorConstants.kExtendingSpeed) * -1);
    }
  }

  public void setSpeed(double desiredSpeed) {
    m_leftElevatorMotor.set(desiredSpeed);
  }

  public double getAbsoluteLength(){
    return m_elevatorEncoder.getPosition();
  }

  public boolean isTopLimitReached(){
    return m_topLimitSwitch.isPressed();
  }

  public boolean isBottomLimitReached(){
    return m_bottomLimitSwitch.isPressed();
  }

  public boolean lengthReached (double m_desiredLength){
    if(getAbsoluteLength() + ElevatorConstants.kElevatorDeadZone >= m_desiredLength && 
       getAbsoluteLength() - ElevatorConstants.kElevatorDeadZone <= m_desiredLength){
      return true;
    }
    return false;
  }
  // @Override
  // public void periodic() {
  //   // This method will be called once per scheduler run
  // }
}
