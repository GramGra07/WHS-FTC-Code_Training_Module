## Machine learning <a name="ml"></a>
In FTC we typically use machine learning an AI's to detect images. In the FTC sample code in concept tensor flow object detection or TFOD, this is exactly what this does, it uses a tensorflow lite model in order for the robot to detect certain images, FTC has already trained some of it for us, but if you want to create your own AI it will take a little bit more work. [Here is the FTC object detection software][tfodweb] To start, make sure your team is registered and you have roles set up correctly, this [website][mlset] will show you exactly how that is possible. Note that only coaches can put video into the recognition so either arrange for a time or have your coach sign in for you *wink*. Then you will take your videos, I would recommend (for Power Play season) to have 6 videos, all 3 sides on both color cones, this will allow for the most accurate design. I just used wevideo to combine these videos into one. Once your coach or you have uploaded the video to the [Machine learning site][ml], you will have to wait for it to "extract" the frames. Then you will click on the description and get to work, you will get a picture of your video, make your object detection by dragging your box over the part you want it to detect and name it. Then click start tracking. This might take a while and you will have to watch it like a hawk. It might think some of your images are the same label in which case go to the first frame it messes up and simply change the label and hit start tracking. Once you have labeled all of your frames, you will select your video and click produce dataset, all of the default settings should be good and this is the shortest part of the process. Next you will have to select the dataset and click start training. This part will take as long as you want it to take, I would recommend 3000 steps as this will give you the highest accuracy. Once you download your model, place it into your assets folder and change ```private static final String TFOD_MODEL_ASSET = "PowerPlay.tflite";``` in your code to ```private static final String TFOD_MODEL_ASSET = "your file name.tflite";```. Now you will have to go back to the datasets and look at your labels, put these labels into the FTC sample code and you are good to go.

- Getting a VuForia key

Go to [this website][vu] and log in, and create a new key.

Video showing entire process:

https://user-images.githubusercontent.com/101433010/199403553-69995287-3eaf-4af7-b74c-d8ae17b0868a.mp4

[Back to coding][cP]

[Go back home][hP]

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

[blcP]: /baseLevelCode.md
[cP]: /coding.md
[mlP]: /machineLearning.md
[gbP]: /githubBasics.md
[laP]: /linksAndAcknowledgements.md
[eP]: /encoders.md
[hP]: /README.md