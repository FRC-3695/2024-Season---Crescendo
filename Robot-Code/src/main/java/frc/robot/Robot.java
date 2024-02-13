// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants;
import frc.robot.BuildConstants;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// Adds Smart Dashboard Capabilities for Autonomous chooser
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  // Creation of Autonomous functions IDs and Varriables
  private static final String dash_auto_1 = "SpeakerShot";
  private static final String dash_auto_2 = "AmpDump";
  private static final String dash_auto_3 = "SpeakerAnScram";
  private static final String dash_auto_4 = "AmpDumpAnScram";
  private String dash_autoSelected;
  private final SendableChooser<String> dash_autoOptions = new SendableChooser<>();

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    // Prints codes GIT commit version, date, and build date
    System.out.println("Build Branch: "+ BuildConstants.MAVEN_NAME);
    System.out.println("GIT Revision: "+ BuildConstants.GIT_REVISION);
    System.out.println("Built on: "+ BuildConstants.BUILD_DATE + " @ " + BuildConstants.BUILD_UNIX_TIME);
    System.out.println("GIT_SHA: "+ BuildConstants.GIT_SHA);
    // Loads Choices into SmartDashboard Autonomous Chooser
    dash_autoOptions.setDefaultOption("Speaker Shoot and Wait", dash_auto_1);
    dash_autoOptions.addOption("Amp Dump and Wait", dash_auto_2);
    dash_autoOptions.addOption("Speaker Shoot and Move Over", dash_auto_3);
    dash_autoOptions.addOption("Amp Dump and Move Over", dash_auto_4);
    SmartDashboard.putData("Auto choices", dash_autoOptions);

    m_robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
