package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.DifferentialDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor.Encoder;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private final DifferentialDrive m_drive;

    private final Encoder m_left, m_right;

    private final double WHEEL_DIAMETER;

    public DriveSubsystem(MotorEx leftMotor, MotorEx rightMotor, final double diameter) {
        m_left = leftMotor.encoder;
        m_right = rightMotor.encoder;

        WHEEL_DIAMETER = diameter;

        m_drive = new DifferentialDrive(leftMotor, rightMotor);
    }

    public DriveSubsystem(HardwareMap hMap, final String leftMotorName, String rightMotorName,
                          final double diameter) {
        this(new MotorEx(hMap, leftMotorName), new MotorEx(hMap, rightMotorName), diameter);
    }

    public void drive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public double getLeftEncoderVal() {
        return m_left.getPosition();
    }

    public double getLeftEncoderDistance() {
        return m_left.getRevolutions() * WHEEL_DIAMETER * Math.PI;
    }

    public double getRightEncoderVal() {
        return m_right.getPosition();
    }

    public double getRightEncoderDistance() {
        return m_right.getRevolutions() * WHEEL_DIAMETER * Math.PI;
    }

    public void resetEncoders() {
        m_left.reset();
        m_right.reset();
    }

    public double getAverageEncoderDistance() {
        return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2.0;
    }

}