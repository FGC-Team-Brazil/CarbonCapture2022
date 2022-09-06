package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp

public class op1 extends LinearOpMode {
    private Gyroscope imu;
    //private ColorSensor test_color;
    private DcMotor test_motor;
    private Servo test_servo;
    private DigitalChannel test_touch;


    @Override
    public void runOpMode() {
       // imu = hardwareMap.get(Gyroscope.class, "imu");
        //test_color = hardwareMap.get(ColorSensor.class, "test_color");
        test_motor = hardwareMap.get(DcMotor.class, "test_motor");
        //test_servo = hardwareMap.get(Servo.class, "test_servo");
        //test_touch = hardwareMap.get(DigitalChannel.class, "test_touch");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        double motorPower = 0;
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            motorPower = - this.gamepad1.left_stick_y;
            test_motor.setPower(motorPower);

            telemetry.addData("Encoder Value", test_motor.getCurrentPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();


        }
    }
}

