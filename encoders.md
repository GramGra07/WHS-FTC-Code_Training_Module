## Encoders <a name="encode"></a>
Encoders are very accurate measurement systems that rely on the wheel movements to measure distances.

### How do they work? <a name="eWork"></a>
![encoder demo](https://user-images.githubusercontent.com/101433010/204153129-1034463b-cef9-4044-8814-035f8cbce675.png)

Most of them work by having a light on one side of the encoder disk. On the other side of the disk there is usually a receiver. On the encoder disk there are a bunch of holes, this is the encoder ticks per revolution and you should be able to find this where you ordered the motor you are using. Most of the motors available for FTC have encoders built into them.

![encoder](https://user-images.githubusercontent.com/101433010/204154390-d6a49351-b7ba-4319-a151-6f3f3db761b1.gif)

### How do you use them? <a name="eUse"></a>
```
static final double COUNTS_PER_MOTOR_REV = your specific encoder counts per revolution;
static final double WHEEL_DIAMETER_MM = your wheel diameter in mm;
static final double WHEEL_DIAMETER_INCHES = WHEEL_DIAMETER_MM * 0.0393701;     // For figuring circumference
static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * your gear ratio) /
            (WHEEL_DIAMETER_INCHES * 3.1415);//gets the overall counts per inch to help with encoders
```
These calculations are the exact calculations that you should use to calculate the counts per inch of the encoder.
```.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);```
This run mode will stop and reset the encoder to 0 ticks.
```.setMode(DcMotor.RunMode.RUN_USING_ENCODER);```
This run mode will make it start to track the encoder position.
```newLeftTarget = motorBackLeft.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);```
This sets a new target by setting a target position based on the current position.
```.setTargetPosition(newLeftTarget);```
```.setMode(DcMotor.RunMode.RUN_TO_POSITION);```
This sets the target position of the motor to the target we just got above. It will also run the motor to the position.
After that use the method ```.setPower(1);``` to set the power of the motor.
```
while (opModeIsActive() &&
   (runtime.seconds() < timeout) &&  //timeout is used to make sure it doesn't run for too long 
   (motor.isBusy())) {

   // Display it for the driver.
   telemetry.addData("Running to", -newLeftTarget);
   telemetry.addData("Currently at", motor.getCurrentPosition());
   telemetry.update();
}
```
This will make sure it doesn't stop before going the distance it needs to. After this ```.setPower(0);``` will make the robot and wheels stop.
You need to do ```.setMode(DcMotor.RunMode.RUN_USING_ENCODER);``` again to make turn off run to position.

### Why should you use them? <a name="eyUse"></a>
You should use them because they are very helpful to go to an exact distance. Using the opMode found [here][eDemo].


[rhc]: https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
[ftcpage]: https://github.com/FIRST-Tech-Challenge
[user]: https://github.com/GramGra07
[team]: https://github.com/WindsorHSRobotics/Team_Resources
[rev]: https://www.revrobotics.com/
[clineuser]: https://github.com/stcline
[aslink]: https://developer.android.com/studio
[ggl]: https://www.google.com/
[lop]: https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/BasicOpMode_Linear.java
[cuser]: https://github.com/ctimmons25
[juser]: https://github.com/JohnMayfield
[buser]: https://github.com/sangerb19
[gm0]: https://gm0.org/en/latest/
[lib]: https://www.firstinspires.org/resource-library/ftc/game-and-season-info
[web]: https://gist.github.com/jagrosh/5b1761213e33fc5b54ec7f6379034a22
[mlguide]: https://ftc-docs.firstinspires.org/ftc_ml/
[ml]: https://ftc-ml.firstinspires.org/
[mlset]: https://ftc-docs.firstinspires.org/ftc_ml/logging_on/logging-on.html#adding-students-to-your-teams-ftc-ml-workspace
[tfodweb]: https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/ConceptTensorFlowObjectDetectionWebcam.java
[vu]: https://developer.vuforia.com/license-manager
[3D]: https://docs.google.com/presentation/d/1MeLkA9mCI4vZMiejlqMZpAhZvbV2ThvSf6oZBzhQGdo/edit?usp=sharing
[qm]: https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
[qt]: https://docs.revrobotics.com/kickoff-concepts/freight-frenzy-2021-2022/programming-teleoperated
[bb]: https://www.firstinspires.org/sites/default/files/uploads/resource_library/ftc/blocks-programming-guide.pdf
[page]: https://gramgra07.github.io/WHS-FTC-GramGra07-Code_Training_Module/
[repo]: https://github.com/GramGra07/WHS-FTC-GramGra07-Code_Training_Module/blob/main/README.md
[feed]: https://gramgra07.github.io/CTMWeb/

[fork]: /images/fork.png
[gitcommit]: /images/gitCommit.png
[commit]: /images/commit.png
[push]: /images/push.png
[pull]: /images/pull.png
[run]: /images/run.png
[setting]: /images/settings.png
[beTele]: /examples/exampleTeleOpBlank
[feTele]: /examples/exampleTeleOpFull
[beAuto]: /examples/exampleAutoBlank.java
[feAuto]: /examples/exampleAutoFull.java
[code]: /images/code.png
[zip]: /images/zip.png
[vcs]: /images/vcs.png
[at]: /images/at.png
[step1]: /images/step1.png
[step2]: /images/step2.png
[step3]: /images/step3.png
[step4]: /images/step4.png
[step5]: /images/step5.png
[step6]: /images/step6.png
[file]: /images/file.png
[open]: /images/open.png
[new]: /images/new.png
[import]: /examples/import.txt
[eDemo]: /examples/RobotAutoDriveByEncoder_Linear.java
[color]: /examples/SensorColor.java
[IMU]: /examples/SensorBNO055IMU.java