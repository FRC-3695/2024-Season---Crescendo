// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team3695.frc2024;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  @SuppressWarnings("unused") // Constructor registers subsystems wihin CommandScheduler
  private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    robotContainer = RobotContainer.getInstance();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
