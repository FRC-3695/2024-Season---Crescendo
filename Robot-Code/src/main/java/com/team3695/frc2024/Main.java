// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.team3695.frc2024;

import edu.wpi.first.wpilibj.RobotBase;

public final class Main {
  // Suppress default constructor for noninstantiability
  private Main() {
    throw new AssertionError();
  }

  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
