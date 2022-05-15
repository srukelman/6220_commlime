package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
//import edu.wpi.first.wpilibj.shuffleboard.*;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArcadeDriveCmd extends CommandBase{

    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> leftSpeed, rightSpeed;
    
    public ArcadeDriveCmd(DriveSubsystem driveSubsystem, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed){
        this.driveSubsystem = driveSubsystem;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize(){
        System.out.println("Arcade Drive Started");
        
    }

    @Override
    public void execute(){
        double left = leftSpeed.get();
        double right = rightSpeed.get();
        driveSubsystem.setMotors(left, right);
        //SmartDashboard.putString("drive mode", "arcade drive");
    }

    @Override
    public void end(boolean interrupted){
        System.out.println("Arcade Drive Stopped");
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
