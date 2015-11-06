package com.qualcomm.ftcrobotcontroller.opmodes.mainCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by RyanZhu on 10/20/2015.
 */
public class First extends OpMode {
    private DcMotor Left;
    private DcMotor Right;
    private Servo GripR;
    private Servo GripL;
    private Servo GripM;

    @Override
    public void init() {
      Right = hardwareMap.dcMotor.get("motor_1");
        Left = hardwareMap.dcMotor.get("motor_2");
        GripR = hardwareMap.servo.get("GripR");
        GripL = hardwareMap.servo.get("GripL");
        GripM = hardwareMap.servo.get("GripM");

        Right.setDirection(DcMotor.Direction.REVERSE);
    }


    @Override
    public void loop() {

        telemetry.addData("Hi", "Hi");
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        Left.setPower(rightY);
        Right.setPower(leftY);

        if(gamepad1.right_bumper == true) {
            GripM.setPosition(0);
        }
        if(gamepad1.left_bumper == true) {
            GripM.setPosition(255);
        }
        if(gamepad1.b == true) {
            GripR.setPosition(255);
        }
        if(gamepad1.x == true) {
            GripR.setPosition(0);
        }
        if(gamepad1.dpad_right == true) {
            GripL.setPosition(255);
        }
        if(gamepad1.dpad_left == true) {
            GripL.setPosition(0);
        }
    }
}
