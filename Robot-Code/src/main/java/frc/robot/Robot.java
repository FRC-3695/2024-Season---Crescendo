// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants;
import frc.robot.BuildConstants;
import frc.robot.subsystems.driveSys;
import frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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
  private Command drivePeriodic;
  private RobotContainer m_robotContainer;
  private driveSys robot_code_drive;
  private vision vision_code;

  @Override
  public void robotInit() {
    // Prints codes GIT commit version, date, and build date
    System.out.println("|");
    System.out.println("****************************************************");
    System.out.println("Build Branch: "+ BuildConstants.MAVEN_NAME);
    System.out.println("GIT Revision: "+ BuildConstants.GIT_REVISION);
    System.out.println("Built on: "+ BuildConstants.BUILD_DATE + " @ " + BuildConstants.BUILD_UNIX_TIME);
    System.out.println("GIT_SHA: "+ BuildConstants.GIT_SHA);
    if(BuildConstants.DIRTY != 0) { // Warning of uncommited changes in deployed build
      System.out.println("|");
      System.out.println("****************************************************");
      System.out.println("    ********** Fruit of the Poisonous Tree *************");
    }
    System.out.println("****************************************************");
    System.out.println("|");
    // Loads Choices into SmartDashboard Autonomous Chooser
    dash_autoOptions.setDefaultOption("Speaker Shoot and Wait", dash_auto_1);
    dash_autoOptions.addOption("Amp Dump and Wait", dash_auto_2);
    dash_autoOptions.addOption("Speaker Shoot and Move Over", dash_auto_3);
    dash_autoOptions.addOption("Amp Dump and Move Over", dash_auto_4);
    SmartDashboard.putData("Auto choices", dash_autoOptions);

    m_robotContainer = new RobotContainer();
    // Decleration of robot functions
    robot_code_drive = new driveSys();
    vision_code = new vision();

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
    dash_autoSelected = dash_autoOptions.getSelected(); //Gets Selected Auto Command from DriverStation
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    switch(dash_autoSelected){
      case dash_auto_1:
        // Shoot into Speaker
        break;
      case dash_auto_2:
        // Dump note into amp
        break;
      case dash_auto_3:
        // Shoot into Speaker and Move out of the way
        break;
      case dash_auto_4:
        // Dump note into amp and Move out of the way
        break;
      default:
        // Action Taken with no action or nothing matches
        break;
    }
  }

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
    /*if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }*/
  }

  @Override
  public void teleopPeriodic() {
  }

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
