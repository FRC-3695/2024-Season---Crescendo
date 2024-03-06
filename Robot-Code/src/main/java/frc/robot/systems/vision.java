package frc.robot.systems;
import frc.robot.Robot;                                 // Core Robot
import frc.robot.Constants;                             // Cross Robot Varriables Centralized
// REVLib

// WPILib  Libraries
import edu.wpi.first.networktables.NetworkTable;        // Support for Network Tables
import edu.wpi.first.networktables.NetworkTableEntry;   // Ability to add entries in Network Table
import edu.wpi.first.networktables.NetworkTableInstance;// Registers instances with Network Table
// Adds Smart Dashboard Capabilities
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class vision {
    static double x;
    static double y;
    static double area;

    private vision() {}
    public static final void startup() {

    }
    public static final void periodic() {
        dashboard_renew();
    }
    private static void target_identify() {

    }
    private static void target_align() {

    }
    private static void dashboard_setup() {
        
    }
    private static void dashboard_renew() {
        NetworkTable vision_fw_table = NetworkTableInstance.getDefault().getTable(Constants.vision.frontCamera);
        NetworkTableEntry tx = vision_fw_table.getEntry("tx");
        NetworkTableEntry ty = vision_fw_table.getEntry("ty");
        NetworkTableEntry ta = vision_fw_table.getEntry("ta");
        x = tx.getDouble(0.0);
        y = ty.getDouble(0.0); 
        area = ta.getDouble(1.0);
        SmartDashboard.putNumber("Vision X", x);
        SmartDashboard.putNumber("Vision Y", y);
        SmartDashboard.putNumber("Vision Area", area);
    }
    // -----------------------  Test periodics and code  -----------------------
    public static void testPeriodic() {
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
