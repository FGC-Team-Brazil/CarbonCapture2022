package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class OpOne extends LinearOpMode {
    private DcMotorEx pidMotor;

    /*

    First, test MaxVelocityTest class to get the max velocity of motor, then calculate kF

    Then, kP first value is 1/10 of kF, tune it until oscilates in between positive and negative error (between 100-300 error)
    Then, kD first value is 10 times of kP, tune it until it the overshoot is gone
    Then, kI first value is around 0.1. The error must be around 0

    //https://docs.google.com/document/d/1tyWrXDfMidwYyP_5H4mZyVgaEswhOC35gvdmP-V-5hA/edit#
     */

    private static PIDFCoefficients pidfCoefficients = new PIDFCoefficients(0, 0, 0, 0);
    private PIDFCoefficients pidGains = new PIDFCoefficients(0, 0, 0, 0);
    private double integralSum = 0;
    private double lastError = 0;


    ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);

    @Override
    public void runOpMode() {
        this.pidMotor = hardwareMap.get(DcMotorEx.class, "pidMotor");
        this.pidMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double power = PIDControl(1000, pidMotor.getVelocity());
            this.pidMotor.setVelocity(power);

            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }

    public double PIDControl(double targetVelocity, double currentVelocity) {
        timer.reset();

        double error = targetVelocity - currentVelocity;

        this.integralSum += error * timer.time();

        double deltaError = error - lastError;
        double derivative = deltaError / timer.time();

        pidGains.p = pidfCoefficients.p * error;
        pidGains.i = pidfCoefficients.i * integralSum;
        pidGains.d = pidfCoefficients.d * derivative;
        pidGains.f = pidfCoefficients.f + targetVelocity;

        double output = pidGains.p + pidGains.i + pidGains.d + pidGains.f;

        telemetry.addData("Error", error);
        telemetry.update();

        return output;
    }
}

