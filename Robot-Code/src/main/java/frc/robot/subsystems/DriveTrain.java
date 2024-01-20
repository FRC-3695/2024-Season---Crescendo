package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import com.revrobotics.RelativeEncoder;


//Encoders
//Motors
//contols
//speed and steering
//



public class DriveTrain extends SubsystemBase{

// set up encoders for when we need to access them (currently unused)
    public static RelativeEncoder leftMasterEncoder;
    public static RelativeEncoder leftSlaveEncoder;
    public static RelativeEncoder rightMasterEncoder;
    public static RelativeEncoder rightSlaveEncoder;

    CommandXboxController controller;
    double rightTrigger;
    double leftTrigger;

    // replace these later when we have a constants file to place these variables in.
    double turnSpeedInhibitor = 0.3;
    double speedInhibitor = 0.3;


    public static CANSparkMax leftMaster;
    public static CANSparkMax leftSlave; 
    public static CANSparkMax rightMaster;
    public static CANSparkMax rightSlave;


    public void Drive() {

   //getting encoder values: 
    leftMasterEncoder = leftMaster.getEncoder();
    leftSlaveEncoder = leftMaster.getEncoder();
    rightMasterEncoder = rightMaster.getEncoder();
    rightSlaveEncoder = rightSlave.getEncoder();



    double leftSpeed = 0.3;
    double rightSpeed = 0.3;

    leftSpeed = MathUtil.clamp(leftSpeed, -1, 1);
    rightSpeed = MathUtil.clamp(rightSpeed, -1, 1);

    leftMaster.set(leftSpeed);
    leftSlave.set(leftSpeed);
    rightMaster.set(rightSpeed);
    rightSlave.set(rightSpeed);

    leftMaster = new CANSparkMax(1, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    leftSlave = new CANSparkMax(2, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    rightMaster = new CANSparkMax(3, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    rightSlave = new CANSparkMax(4, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);


    }

    public void periodic() {

        boolean useJoystick;
        double leftJoyStick = controller.getLeftX();
        double speed = MathUtil.applyDeadband(rightTrigger - leftTrigger, 0.1);
        double steering = MathUtil.applyDeadband(leftJoyStick, 0.1); 
    
        leftTrigger = controller.getLeftTriggerAxis();
        rightTrigger = controller.getRightTriggerAxis();
        
        // will add "constants." infront of turn and speed inhibitor once it's set up in constants  
        steering *= turnSpeedInhibitor;
        speed *= speedInhibitor;

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