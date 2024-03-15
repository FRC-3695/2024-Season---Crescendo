package frc.robot.systems;
import frc.robot.Robot;                                 // Core Robot
import frc.robot.Constants;                             // Cross Robot Varriables Centralized
import frc.robot.utils;                                 // utils to simplify FRC Programming life

public class power {
    static Boolean[] powerHub_activePorts;
    public static void setup() {
        Robot.power_hub.clearStickyFaults();
        Robot.power_hub.resetTotalEnergy();
        hubInitChannels();
    }
    public static void controlPeriodic(){
        driveCheck();
        lifterCheck();
        manipulatorCheck();
        shooterCheck();
        surgeCurrentCheck();
    }
    static boolean driveCheck_fail = false;
    static double drive_power_tolerance = 0.095;
    static double drive_current_tolerance = 0.10;
    private static void driveCheck(){
        // Checks for Voltage Drop to Drive Motors & Difference between the two
        if (Robot.power_hub.getCurrent(Constants.IDs.drive_leftRear_powerBus)/Robot.power_hub.getCurrent(Constants.IDs.drive_leftFront_powerBus)+drive_current_tolerance < 1) {
            utils.Logging(5, "Left Drive Master Loss");
            driveCheck_fail = true;
        } else if (Robot.drive_leftMaster.getBusVoltage()/Robot.power_hub.getVoltage()+drive_power_tolerance < 1) {
            utils.Logging(4, "Left Drive Master \"Bad Power Connection\"");
            driveCheck_fail = true;
        }
        if (Robot.power_hub.getCurrent(Constants.IDs.drive_leftFront_powerBus)/Robot.power_hub.getCurrent(Constants.IDs.drive_leftRear_powerBus)+drive_power_tolerance < 1) {
            utils.Logging(5, "Left Drive Follower Loss");
            driveCheck_fail = true;
        } else if (Robot.drive_leftSlave.getBusVoltage()/Robot.power_hub.getVoltage()+drive_power_tolerance < 1) {
            utils.Logging(4, "Left Drive Follower \"Bad Power Connection\"");
            driveCheck_fail = true;
        }
        if (Robot.power_hub.getCurrent(Constants.IDs.drive_rightRear_powerBus)/Robot.power_hub.getCurrent(Constants.IDs.drive_rightFront_powerBus)+drive_current_tolerance < 1) {
            utils.Logging(5, "Right Drive Master Loss");
            driveCheck_fail = true;
        } else if (Robot.drive_rightMaster.getBusVoltage()/Robot.power_hub.getVoltage()+drive_power_tolerance < 1) {
            utils.Logging(4, "Right Drive Master \"Bad Power Connection\"");
            driveCheck_fail = true;
        }
        if (Robot.power_hub.getCurrent(Constants.IDs.drive_rightFront_powerBus)/Robot.power_hub.getCurrent(Constants.IDs.drive_rightRear_powerBus)+drive_current_tolerance < 1) {
            utils.Logging(5, "Right Drive Follower Loss");
            driveCheck_fail = true;
        } else if (Robot.drive_rightSlave.getBusVoltage()/Robot.power_hub.getVoltage()+drive_power_tolerance < 1) {
            utils.Logging(4, "Right Drive Follower \"Bad Power Connection\"");
            driveCheck_fail = true;
        }
    }
    static boolean lifterCheck_fail = false;
    private static void lifterCheck(){

    }
    static boolean manipulatorCheck_fail = false;
    private static void manipulatorCheck(){

    }
    static boolean shooterCheck_fail = false;
    private static void shooterCheck(){

    }
    static int surgeCurrentLevel = 40;
    private static void surgeCurrentCheck(){
        for(int channel = 0; channel < powerHub_activePorts.length; channel++) {
            if (Robot.power_hub.getCurrent(channel) > surgeCurrentLevel) {
                utils.Logging(4, "Surge Current on PowerHub port : "+channel);
            }
        }
    }
    private static void hubInitChannels(){
        powerHub_activePorts = new Boolean[Robot.power_hub.getNumChannels()];
        for(int channel = 0; channel < powerHub_activePorts.length; channel++) {
            if (Robot.power_hub.getCurrent(channel) > 0) {
                powerHub_activePorts[channel] = true;
                utils.Logging(1, "Device at PowerHub port : "+channel);
            } else {
                powerHub_activePorts[channel] = false;
            }
        }
    }
}
