package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionSubsystem extends SubsystemBase{
    private double limelightAngle = 3.14/4;
    private double horizAngle = 0;
    private double vertAngle = 0;
    private boolean m_LimelightHasValidTarget = false;
    private double distanceToRim = 0.0;
    private double limelightHeight = 24;//height of limelight in inches
    private double upperHubHeight = 104; //height of upper hub in inches (8ft 8 inches)
    private double hPrime = upperHubHeight - limelightHeight;//difference in heigh between upper hub and limelight

    public VisionSubsystem() {
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic(){}
    
    public void setNetworkValues(double tv, double tx, double ty, double ta){
        m_LimelightHasValidTarget = (tv == 1d);
        horizAngle = tx;
        vertAngle = (ty * 3.14)/180;
        distanceToRim = hPrime/Math.tan(vertAngle+limelightAngle);
    }
    public void setHorizontalAngle(double horizontal){
        this.horizAngle = horizontal;
    }
    public double getHorizontalAngle(){
        return horizAngle;
    }
    public boolean hasTarget(){
        return m_LimelightHasValidTarget;
    }

}
