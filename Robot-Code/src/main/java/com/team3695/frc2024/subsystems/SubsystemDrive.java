// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team3695.frc2024.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.team3695.frc2024.RobotContainer;

import static com.team3695.frc2024.Constants.SubsystemDriveConstants.*;

public class SubsystemDrive extends SubsystemBase {
  /** Subsystem singleton instance */
  private static SubsystemDrive instance;

  private DifferentialDrive drivetrain;
  private CANSparkMax leftMaster, leftSlave;
  private CANSparkMax rightMaster, rightSlave;

  /** Creates a new Drive. */
  private SubsystemDrive() {
    // Initialize all relevent motor controllers
    leftMaster = new CANSparkMax(LEFT_MASTER_ID, MotorType.kBrushless);
    leftSlave = new CANSparkMax(LEFT_SLAVE_ID, MotorType.kBrushless);
    rightMaster = new CANSparkMax(RIGHT_MASTER_ID, MotorType.kBrushless);
    rightSlave = new CANSparkMax(RIGHT_SLAVE_ID, MotorType.kBrushless);

    // Initialize differential drivetrain (KISS)
    this.drivetrain = new DifferentialDrive(leftMaster, rightMaster);

    // Initialize drivetrain defaults
    initializeDefaults();
  }

  public static SubsystemDrive getInstance() {
    if (instance == null)
      instance = new SubsystemDrive();
    return instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive() {
    XboxController driver = RobotContainer.getDriver();
    double xSpeed = driver.getRightTriggerAxis() - driver.getLeftTriggerAxis();
    double zRotation = driver.getLeftX(); // Similar to Rocket League controls
    drivetrain.arcadeDrive(xSpeed, zRotation);
  }

  public void initializeDefaults() {
    setCurrentLimits(CURRENT_LIMIT);
    setIdleModes(IDLE_MODE);
    setRampRates(RAMP_RATE);

    // Link the motors into a motor group
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    // Update the necessary inverts for motor controllers
    leftMaster.setInverted(LEFT_MASTER_INVERT);
    leftSlave.setInverted(LEFT_SLAVE_INVERT);
    rightMaster.setInverted(RIGHT_MASTER_INVERT);
    rightSlave.setInverted(RIGHT_SLAVE_INVERT);
  }

  /** Sets the current limit in Amps. */
  private void setCurrentLimits(int limit) {
    leftMaster.setSmartCurrentLimit(limit);
    leftSlave.setSmartCurrentLimit(limit);
    rightMaster.setSmartCurrentLimit(limit);
    rightSlave.setSmartCurrentLimit(limit);
  }

  /** Sets the idle mode setting for the drivetrain. */
  private void setIdleModes(IdleMode mode) {
    leftMaster.setIdleMode(mode);
    leftSlave.setIdleMode(mode);
    rightMaster.setIdleMode(mode);
    rightSlave.setIdleMode(mode);
  }

  /** Sets the ramp rate for open loop control modes. */
  private void setRampRates(double rate) {
    leftMaster.setOpenLoopRampRate(rate);
    leftSlave.setOpenLoopRampRate(rate);
    rightMaster.setOpenLoopRampRate(rate);
    rightSlave.setOpenLoopRampRate(rate);
  }
}
