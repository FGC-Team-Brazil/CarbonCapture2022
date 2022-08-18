package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.motors.RevRoboticsUltraPlanetaryHdHexMotor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class ShooterSubsystem{

    private DcMotor shooterMotor;

    public ShooterSubsystem(HardwareMap hardwareMap, String shooterName){
        setup(hardwareMap, shooterName);
    }

    public void setup( HardwareMap hardwareMap, String shooterName ) {
        shooterMotor = hardwareMap.dcMotor.get(shooterName);
    }

    public void shoot(double speed){
        shooterMotor.setPower(speed);
    }

    public void stopShooter(){
        shooterMotor.setPower(0);
    }



}
