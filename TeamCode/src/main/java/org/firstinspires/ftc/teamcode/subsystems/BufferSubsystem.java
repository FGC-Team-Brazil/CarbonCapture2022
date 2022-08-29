package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BufferSubsystem {
    private DcMotor motor;

    public BufferSubsystem(HardwareMap hardwareMap, String name) {
        setup(hardwareMap, name);
    }

    public void setup(HardwareMap hardwareMap, String name) {
        motor = hardwareMap.dcMotor.get(name);
    }

    public void set(double speed) {
        motor.setPower(speed);
    }

    public void stop(){
        motor.setPower(0);
    }



}