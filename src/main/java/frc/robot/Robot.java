// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructArrayPublisher;
import edu.wpi.first.networktables.StructPublisher;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {}

  private final StructPublisher<Pose2d> simPosePublisher = 
      NetworkTableInstance.getDefault()
          .getStructTopic("SimPose", Pose2d.struct)
          .publish();
  
    private final StructArrayPublisher<Pose3d> componentPosesPublisher =
    NetworkTableInstance.getDefault()
        .getStructArrayTopic("ComponentPoses", Pose3d.struct)
        .publish();

  

  @Override
  public void robotPeriodic() {
    Pose2d pose = new Pose2d();
    Pose3d hoodPose = new Pose3d(
      new Translation3d(0.16, -0.085, 0.4),
      // roll -25 to 5
      new Rotation3d(Math.toRadians(5),Math. toRadians(0), Math.toRadians(0))
    );
    Pose3d intakePose = new Pose3d();
    simPosePublisher.set(pose);
    componentPosesPublisher.set(new Pose3d[] {hoodPose, intakePose});
  }

  @Override
  public void autonomousInit() {}
  

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
