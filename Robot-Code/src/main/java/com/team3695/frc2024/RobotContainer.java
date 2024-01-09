// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team3695.frc2024;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

import static com.team3695.frc2024.Constants.DriverConstants;
import static com.team3695.frc2024.Constants.OperatorConstants;

import com.team3695.frc2024.subsystems.SubsystemDrive;

public class RobotContainer {
  private static RobotContainer instance;
  private static XboxController driver, operator;

  // ----- Subsystems -----
  private static final SubsystemDrive SUB_DRIVE = SubsystemDrive.getInstance();

  private RobotContainer() {
    configureBindings();
  }

  public static RobotContainer getInstance() {
    if (instance == null)
      instance = new RobotContainer();
    return instance;
  }

  public static XboxController getDriver() {
    if (driver == null)
      driver = new XboxController(DriverConstants.PORT);
    return driver;
  }

  public static XboxController getOperator() {
    if (operator == null)
      operator = new XboxController(OperatorConstants.PORT);
    return operator;
  }

  private void configureBindings() {
    SUB_DRIVE.setDefaultCommand(Commands.run(SUB_DRIVE::arcadeDrive, SUB_DRIVE));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
