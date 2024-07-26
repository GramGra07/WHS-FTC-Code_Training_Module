---
description: https://www.sparkfun.com/products/24904
---

# Spark Fun OTOS Sensor

## What is it?

The SparkFun Optical Tracking Odometry Sensor is an incredibly useful tool created for FTC by Spark Fun, there is a lot of support through the community on this project

## How does it work?

It is basically a computer mouse! It also includes a very nice 6-axis IMU, which allows it to have more knowledge than a computer mouse would. This allows you to get heading as well from the sensor.

## How do I code it?

Here is an example opMode to make the OTOS Sensor work, it is fairly self explanatory:

```java
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class OTOS extends LinearOpMode {
    SparkFunOTOS sparkFunOTOS;
    @Override
    public void runOpMode() {
        hardwareMap.get(SparkFunOTOS.class, "spark");
        sparkFunOTOS.setLinearUnit(DistanceUnit.INCH);
        sparkFunOTOS.setAngularUnit(AngleUnit.DEGREES);
        //For example, if
        // the sensor is mounted 5 inches to the left (negative X) and 10 inches
        // forward (positive Y) of the center of the robot, and mounted 90 degrees
        // clockwise (negative rotation) from the robot's orientation, the offset
        // would be {-5, 10, -90}. These can be any value, even the angle can be
        // tweaked slightly to compensate for imperfect mounting (eg. 1.3 degrees).
        sparkFunOTOS.setOffset(new SparkFunOTOS.Pose2D(0.0,0.0,0.0));
        //For example, if you move the robot 100 inches and
        // the sensor reports 103 inches, set the linear scalar to 100/103 = 0.971
        sparkFunOTOS.setLinearScalar(1.0);
        sparkFunOTOS.setAngularScalar(1.0);
        sparkFunOTOS.calibrateImu();

        sparkFunOTOS.resetTracking();

        sparkFunOTOS.setPosition(new SparkFunOTOS.Pose2D(0.0,0.0,0.0));
        
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("X: ", sparkFunOTOS.getPosition().x);
            telemetry.addData("Y: ", sparkFunOTOS.getPosition().y);
            telemetry.addData("H: ", sparkFunOTOS.getPosition().h);
            telemetry.update();
        }
    }
}
```

## How do I make it work better?

You can make it work better by cleaning it frequently, making sure you have the correct mounting position, and making sure it is on the exact center of the robot to allow for it to track every movement correctly.
