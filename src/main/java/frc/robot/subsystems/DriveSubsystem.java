package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveSubsystem extends SubsystemBase{

    private VictorSPX LDriveMaster = new VictorSPX(4); //1st Left Drive Motor
    private VictorSPX LDriveSlave = new VictorSPX(8); //2nd Left Drive Motor
    private VictorSPX RDriveMaster = new VictorSPX(7); //1st Right Drive Motor
    private VictorSPX RDriveSlave = new VictorSPX(5);
    public DriveSubsystem(){}

    @Override
    public void periodic(){}

    @Override
    public void simulationPeriodic(){}

    public void setMotors(double left, double right){
        LDriveMaster.set(ControlMode.PercentOutput, left);
        LDriveSlave.set(ControlMode.PercentOutput, left);
        RDriveMaster.set(ControlMode.PercentOutput, right);
        RDriveSlave.set(ControlMode.PercentOutput, right);
    }

}
