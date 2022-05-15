package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class UpdateVisionCmd extends CommandBase{
    private double x = 0;
    private double y = 0;
    private double area = 0;
    private final VisionSubsystem visionSubsystem;

    public UpdateVisionCmd(VisionSubsystem visionSubsystem){
        this.visionSubsystem = visionSubsystem;   
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tv = table.getEntry("tv");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        //read values periodically
        if(tv.getDouble(0d) == 1d){
            this.x = tx.getDouble(0.0);
            this.y = ty.getDouble(0.0);
            this.area = ta.getDouble(0.0);
        }
        else{
            this.x = 0d;
            this.y = 0d;
            this.area = -1d;
        }
        visionSubsystem.setNetworkValues(tv.getDouble(0d), x, y, area);
        

        
    }

    public double getTX(){
        return this.x;
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
    
}
