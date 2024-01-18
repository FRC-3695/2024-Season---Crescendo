package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase.MotorType;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;








public class DriveTrain extends SubsystemBase{

    public static CANSparkMax leftMaster;
    public static CANSparkMax leftSlave; 
    public static CANSparkMax rightMaster;
    public static CANSparkMax rightSlave;

   


    CommandXboxController controller;



    public void Drive() {


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

        
        

        double leftJoystick = controller.getLeftX();
        double steering = MathUtil.applyDeadband(leftJoystick, 0.1);



    }










}