package frc.robot.commands;

import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootCmd extends CommandBase{
    private final DriveSubsystem driveSubsystem;
    private final VisionSubsystem visionSubsystem;
    private final double xSetpoint = 0;

    public ShootCmd(VisionSubsystem visionSubsystem, DriveSubsystem driveSubsystem){
        this.visionSubsystem = visionSubsystem;
        this.driveSubsystem = driveSubsystem;
    }

    @Override
    public void initialize(){
        System.out.println("shooting lol");
    }

    @Override
    public void execute(){
        if(visionSubsystem.hasTarget()){
            double x = visionSubsystem.getHorizontalAngle();
        }
    }

    @Override
    public void end(boolean interrupted){}

    @Override
    public boolean isFinished(){
        return false;
    }
}
