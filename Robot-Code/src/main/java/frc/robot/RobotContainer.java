// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }
  public static DriveTrain driveTrain = DriveTrain.getInstance();
  private static CommandXboxController driver = null;
    
  //CommandXboxController controller = new CommandXboxController(0);
  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  public static CommandXboxController getDriver() {
    if (driver == null) {
      driver = new CommandXboxController(0);
    } 
    return driver;
  } 
}