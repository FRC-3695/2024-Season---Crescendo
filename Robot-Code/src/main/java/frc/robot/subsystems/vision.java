package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem



public class vision extends SubsystemBase{



    static CANSparkMax leftMaster;
    static CANSparkMax leftSlave;
    static CANSparkMax rightMaster;
    static CANSparkMax rightSlave;

    RelativeEncoder leftMasterEncoder;
    RelativeEncoder leftSlaveEncoder;
    RelativeEncoder rightMasterEncoder;
    RelativeEncoder rightSlaveEncoder;



    public vision() {



        leftMaster = new CANSparkMax(Constants.IDs.drive_leftFront_motor, MotorType.kBrushless);
        leftSlave = new CANSparkMax(Constants.IDs.drive_leftRear_motor, MotorType.kBrushless);
        rightMaster = new CANSparkMax(Constants.IDs.drive_rightFront_motor, MotorType.kBrushless);
        rightSlave = new CANSparkMax(Constants.IDs.drive_rightRear_motor, MotorType.kBrushless);



        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);

    }


    public void robotInit() {

        System.out.println(leftMasterEncoder);
        System.out.println(leftSlaveEncoder);
        System.out.println(rightMasterEncoder);
        System.out.println(rightSlaveEncoder);

        }

    public void periodic() {



        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0); 
        double area = ta.getDouble(1.0);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

        leftMasterEncoder = leftMaster.getEncoder();
        leftSlaveEncoder = leftSlave.getEncoder();
        rightMasterEncoder = rightMaster.getEncoder();
        rightSlaveEncoder = rightSlave.getEncoder();


        System.out.println(leftMasterEncoder);
        System.out.println(leftSlaveEncoder);
        System.out.println(rightMasterEncoder);
        System.out.println(rightSlaveEncoder);


    

        //Basic Functionality Tests
       //this works: first number is y, second number is x
        if (SmartDashboard.getNumber("Limelightx", x) == Constants.vision.targeting_april_alignment[4][0]) {
            System.out.println("DictionaryWorks!");  


           double currentMotorPosition = leftMasterEncoder.getPosition();
                //tweak depending on how many count per rotation there is.
            double targetMotorPosition = currentMotorPosition + 6 * 3000;
            leftMaster.getPIDController().setReference(targetMotorPosition, ControlType.kPosition);




        }

        if (SmartDashboard.getNumber("Limelightx", x) <= 7 && SmartDashboard.getNumber("Limelightx", x) >= 6) {
             System.out.println("Works!");
        }
        if (SmartDashboard.getNumber("Limelightx", y) <= 7 && SmartDashboard.getNumber("Limelightx", y) >= 6) {
             System.out.println("Works!");
        }
    }
    
} 