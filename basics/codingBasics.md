### Coding Basics <a name="cbasics"></a> 
Go through this section if you have no experience coding, if you are experienced, skip this.
### What is a... <a name="wia"></a>
- Operation <a name = "oper"></a>

```==``` is equals

```!=``` is not equals

```<=``` less than or equal to

```>=``` greater than or equal to

```>``` greater than

```<``` less than

Math:

```++``` increments by one

```--``` decreases by one

```variable += 1``` equivalent of variable + 1 = variable

```variable /= 1``` equivalent of variable / 1 = variable

```variable -= 1``` equivalent of variable - 1 = variable

```variable *= 1``` equivalent of variable * 1 = variable


- Variable <a name="var"></a>

  A variable is a holder of a value, these values can be anything, as explained in Using Variables. You can use these to store values such as an on off switch, or a progress update, you can also use this as a place to store the power for motors. You will also declare your motors and servos as variables. A local variable can only be used where it was defined or set. A global variable can be used wherever. FTC documentation also lets us use some of their universal variables such as DcMotors and Servos, these are all imported by import statements at the beginning of your code.

- Function <a name="func"></a>

  Functions are statements to make the code run one part when you "call" the function. It is like calling a whole new section of the code. This is useful to have the code execute specific instructions. This is useful to tell the code to update something or to set a value to a variable. You can also set parameters that are localized variables. A local variable can only be used in that function. Parameters are very useful to help us define and change local variables inside of of the function.

- If statement <a name="if"></a>
  An if statement is simply ```if (condition) { (do something) }```. Conditions can be found in [operations](#oper).

- Print/telemetry statement <a name="print"></a>

  Print statements are very useful in debugging your code, essentially what they do is show you a value that you tell it to. ```telemetry.addData("caption"," info")``` This will give you values on the Driver Station phone and you can use this to see values like if a certain variable is on or off. In other languages you would use ```print('',value)``` to get the same information.

- Loops <a name="loop"></a>

  While loops are very helpful in robot code. They can help you to make the robot do something until a condition is met. These are used by the ftc company in their own opModes to have the robot be on when you tell it to. These are very useful for distance or color sensors. For loops run the event a certain amount of times. In Java: ```for (int i = 0; i < 100; i++){``` this is the same as you would use in python: ```for i in range(100){```, this would have the stuff in the loop run 10 times.

- Imports <a name="import"></a>

  Imports are very useful and can give you many more abilities in your code, one of the biggest known things to import is time. Other than that, every different sensor and motor you use will need to be imported.

[Next up: Coding][cP]

[Go back home][hP]

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

[blcP]: /basics/codingBasics.mdsics.md
[cP]: /coding.md
[mlP]: /autonomous/advanced/machineLearning.md
[gbP]: /basics/githubBasics.mdsics.md
[laP]: /.etc/linksAndAcknowledgements.md
[eP]: /autonomous/encoders.md
[hP]: /README.md
[rr]: /autonomous/advanced/roadRunner.md
[cv]: /autonomous/advanced/openCV.md