package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  

  }

  
  
  public static DriveTrain drive = DriveTrain.getInstance();
  private static CommandXboxController driver  = null;

  


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
