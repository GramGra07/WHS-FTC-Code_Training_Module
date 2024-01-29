### Road Runner

Road Runner is a very convenient, easy to use software to make your robot follow a path you create.

[Learn Road Runner][lrr] is one of the best sites I have found to learn how to use Road Runner.
It walks through all of the steps from start to finish but I have found some specific things that I have found to be slightly different for my robot, using Rev Ultra-planetary Motors with a gearboxes.

I went through all of Learn Road Runner in around two hours after I was able to make my Drive Constants file work correctly.

Drive Constants is where your robot's specifications are stored and accessed and it is vital these are correct

#### Note: this is what worked for me, it may not work for you

In Drive Constants I have set MaxRpm to whatever the manual says (6000 in my case) multiplied by 1/ gear ratio. So in my case, using the Rev Ultra-planetary motor with a 15:1 gearbox was 400.

I have Gear Ratio set to 1/ gear ratio. So in my case 1/15.

TicksPerRev can be set to your ticks per revolution of your motor as found on the specifications. For me it was 28.

Wheel Radius is the radius of your wheel in inches.

You will need to set your USB facing dir and logo facing dir to the correct direction for your robot. This is the direction the logo on the motor is facing and the direction the USB is facing. Mine are as follows: 

```
public static final RevHubOrientationOnRobot.UsbFacingDirection USB_FACING_DIR = RevHubOrientationOnRobot.UsbFacingDirection.LEFT;
public static final RevHubOrientationOnRobot.LogoFacingDirection LOGO_FACING_DIR = RevHubOrientationOnRobot.LogoFacingDirection.UP; 
```

#### This all has to be very specific to make it work better

When tuning trackWidth, I would recommend running it multiple times, and making sure to change the values on [FTC Dashboard][dash] to make it more accurate.

#### Note: when changing anything in the Dashboard MAKE SURE you press enter to save the values and once you are finished, make sure to put all changed values into the correct file

If you are tuning Manual FeedForward:

When tuning kV make everything else (kP, kA) 0

kV changes the max velocity to make the top of the peak

kA is acceleration(lower = slower acceleration)

kP is fine tuning to make sure it is closer to the path we want it to be at

##### Now you should be able to go and just go through the rest of Learn Road Runner and it should work if you have tuned everything properly

### Troubleshooting

If the robot is supposed to be going straight, and it isn't, make sure your motor directions are set correctly in SampleMecanumDrive or your tracking localizer


[rhc]: https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
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

[blcP]: /baseLevelCode.md
[cP]: /coding.md
[mlP]: /autonomous/machineLearning.mdd/machineLearning.md
[gbP]: /basics/githubBasics.md
[laP]: /.etc/linksAndAcknowledgements.md
[eP]: /autonomous/encoders.md
[hP]: /README.md
[rr]: /autonomous/roadRunner.mdvanced/roadRunner.md
[cv]: /autonomous/openCV.mds/advanced/openCV.md