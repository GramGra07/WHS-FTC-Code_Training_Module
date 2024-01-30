# PIDF Controller

## What is it? <a name="what"></a>

A PIDF controller is a way of controlling the robot's movement using a PIDF loop.
This means that it will use the error of a motors position to calculate where it should move to next.
It calculates the power of the motor using the error (figured by the encoder) and the tuned PIDF constants.
The PIDF constants, being Position, Integral, Derivative, and FeedForward, are used to tune the PIDF loop to make it more accurate.

P: The value multiplied by the error to get the power of the motor. This is the main value that is tuned to make the motor more accurate.

I: The value multiplied by the integral of the error to get the power of the motor. This is used to make sure that the motor is not stuck at a certain position.

D: The value that determines how to react to the change in current errors.

F: This is the value that helps stabilize it against gravity and other forces.

## How do I use it? <a name="use"></a>

Simply create the PIDFController class and then use the ```calculate``` function to calculate the power of the motor.

```public static PIDFController pidfController = new PIDFController(0, 0, 0, 0);```

Those constants will then be changed to tune the PIDF loop.

```pidfController.calculate(currentPosition, targetPosition);```

Then apply power to the motor you would like to power.

```motor.setPower(pidfController.calculate(currentPosition, targetPosition));```

This will allow it to automatically calculate the power of the motor.

## How do I tune it? <a name="tune"></a>

To tune this, I would recommend using FTC Dashboard, found [here](https://acmerobotics.github.io/ftc-dashboard/). This will allow you to see the values of the PIDF loop and change them in real time.

Specifically with FTC Dash, it makes it way easier because you can log the values being outputted by the encoder on your motor, and tune the PIDF loop in real time.

Once you get the values you want, you can then put them into your code.

### FTC Dashboard Setup

After you add it to the project, put ```@Config``` before ```@TeleOp``` or ```@Autonomous```.

Then add the following code to your code:

```public static PIDFCoefficients PIDFCo = new PIDFCoefficients(0, 0, 0, 0);```

```PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);```

**Note that this is a little more complex and not needed to tune it, just makes it easier/quicker**

### Tuning steps

1. Set all values to 0
2. Slowly increase P until it starts to stop oscillating back and forth on the target position
3. Slowly increase F until it stops oscillating and gravity is not affecting it

You can then tune I and D to make it more accurate but I will not cover that in this guide.

## How do I implement it? <a name="implement"></a>

### TeleOp

```
if (gamepad2.right_stick_y < 0 && usePIDF) {
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    Power = Range.clip(PIDF.calculate(motor.getCurrentPosition(), maxTicks), -1, 1);
} else if (gamepad2.right_stick_y > 0 && usePIDF) {
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    Power = Range.clip(PIDF.calculate(motor.getCurrentPosition(), minTicks), -1, 1);
} else {
    Power = 0;
}
if (gamepad2.cross) {
    usePIDF = false;
}
```

In this code, we tell it that if the right stick is pushed up, it will use the PIDF loop to calculate the power of the motor as well as if it is pushed down, the only difference is the target values.

We also have a boolean that will allow us to turn off the PIDF loop if we need to.

### Autonomous

During autonomous usage, you can also use PIDF loops fairly easy with a while loop, or if you are using Road Runner or something else that doesn't allow while loops, State Machines.

#### While loop

```
while (opModeIsActive()){
    PIDF.setPIDF(PIDFCo.p, PIDFCo.i, PIDFCo.d, PIDFCo.f);
    motor.setPower(PIDF.calculate(motor.getCurrentPosition(), targetPosition));
}
```

You can also switch the target position to a variable that is changed throughout the program.

#### State Machine

More information on State Machines can be found [here](/autonomous/StateMachine.md).

In this example, we would set the target as a variable and set that differently throughout the program.

## Resources <a name="resources"></a>

https://youtu.be/E6H6Nqe6qJo?si=luVu2EeaFapRfCl3

https://cookbook.dairy.foundation/integrating_a_custom_PIDF_controller.html

[rhc]:https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
[ftcpage]: https://github.com/FIRST-Tech-Challenge/FtcRobotController
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
[eocv]: https://github.com/OpenFTC/EasyOpenCV
[hsv]: https://i.stack.imgur.com/gyuw4.png
[lrr]: https://learnroadrunner.com/#frequently-asked-questions
[dash]: http://192.168.43.1:8080/dash

[fork]: /images/fork.png
[gitcommit]: /images/gitCommit.png
[commit]: /images/commit.png
[push]: /images/push.png
[pull]: /images/pull.png
[run]: /images/run.png
[setting]: /images/settings.png
[beTele]: /examples/exampleTeleOpBlank
[feTele]: /examples/exampleTeleOpFull
[beAuto]: /examples/exampleAutoBlank.txt
[feAuto]: /examples/exampleAutoFull.txt
[code]: /images/code.png
[zip]: /images/zip.png
[vcs]: /images/vcs.png
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
[eDemo]: /examples/RobotAutoDriveByEncoder_Linear.txt
[color]: /examples/SensorColor.txt
[IMU]: /examples/SensorBNO055IMU.txt

[cP]: /coding.md
[mlP]: /autonomous/machineLearning.md
[gbP]: /basics/githubBasics.md
[laP]: /.etc/linksAndAcknowledgements.md
[eP]: /autonomous/encoders.md
[hP]: /README.md
[rr]: /autonomous/roadRunner.md
[cv]: /autonomous/openCV.md
[pidf]: /advanced/PIDF.md
[sm]: /autonomous/StateMachine.md