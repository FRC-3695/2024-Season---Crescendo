package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotContainer;
import com.revrobotics.RelativeEncoder;


public class DriveTrain extends SubsystemBase {

    




      
// set up encoders for when we need to access them (currently unused)
    CommandXboxController controller;





    public static CANSparkMax leftMaster;
    public static CANSparkMax leftSlave; 
    public static CANSparkMax rightMaster;
    public static CANSparkMax rightSlave;

    public static RelativeEncoder leftMasterEncoder;
    public static RelativeEncoder leftSlaveEncoder;
    public static RelativeEncoder rightMasterEncoder;
    public static RelativeEncoder rightSlaveEncoder;

    double rightTrigger;
    double leftTrigger;

    private static DriveTrain instance = null;

    public static DriveTrain getInstance() {
        if(instance == null)
          instance = new DriveTrain();
       
          return instance;
      }

    // replace these later when we have a constants file to place these variables in.
    
    public DriveTrain() {

    //controller = new CommandXboxController(0);
   //getting encoder values: 
    
    
    

    

   controller = RobotContainer.getDriver();

   
    leftMaster = new CANSparkMax(1, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    leftSlave = new CANSparkMax(2, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    rightMaster = new CANSparkMax(3, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    rightSlave = new CANSparkMax(4, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);


    leftMaster.restoreFactoryDefaults();
    rightMaster.restoreFactoryDefaults();

    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

   


    }
    public void periodic() {

        leftTrigger = controller.getLeftTriggerAxis();
        rightTrigger = controller.getRightTriggerAxis();
        
        double leftJoyStick = controller.getLeftX();
        double steering = MathUtil.applyDeadband(rightTrigger - leftTrigger, 0.1);
        double speed = MathUtil.applyDeadband(leftJoyStick, 0.1); 

        SlewRateLimiter filter = new SlewRateLimiter(1);
        filter.calculate(leftJoyStick);

        steering *= Constants.turnSpeedInhibitor;
        speed *= Constants.speedInhibitor;



       double leftSpeed = speed - steering;
       double rightSpeed = speed + steering;
      
    
        
        
        // will add "constants." infront of turn and speed inhibitor once it's set up in constants  
       
        leftSpeed = MathUtil.clamp(leftSpeed, -1, 1);
        rightSpeed = MathUtil.clamp(rightSpeed, -1, 1);

            

        rightMaster.set(rightSpeed);
        //rightSlave.set(rightSpeed);

        leftMaster.set(leftSpeed);
        //leftSlave.set(leftSpeed);

    }
    // call this function to stop drive train 

    public void stopDriveTrain() {

        leftMaster.set(0);
        leftSlave.set(0);
        rightMaster.set(0);
        rightSlave.set(0);
    }
    //call this function to zero encoders

    public void zeroEncoders() {

        leftMasterEncoder.setPosition(0);
        leftSlaveEncoder.setPosition(0);
        rightMasterEncoder.setPosition(0);
        rightSlaveEncoder.setPosition(0);
    }
}