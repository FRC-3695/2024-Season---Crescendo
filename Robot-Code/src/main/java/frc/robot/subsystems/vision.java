package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

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
    

        //Basic Functionality Tests
       //this works: first number is y, second number is x
        if (SmartDashboard.getNumber("Limelightx", x) == Constants.vision.targeting_april_alignment[4][0]) {
            System.out.println("DictionaryWorks!");        
        }

        if (SmartDashboard.getNumber("Limelightx", x) <= 7 && SmartDashboard.getNumber("Limelightx", x) >= 6) {
             System.out.println("Works!");
        }
        if (SmartDashboard.getNumber("Limelightx", y) <= 7 && SmartDashboard.getNumber("Limelightx", y) >= 6) {
             System.out.println("Works!");
        }
    }

      
        
    
} 