# WHS-FTC-GramGra07-Code_Training_Mod       
## Created by Graden FTC Team 10448 Mach 5 
### To help everyone that wants to understand the coding process and language involved in FTC programming and Java

Github Repo located [here][repo]

Github Pages located [here][page]

Code Training Module Info/Feedback located [here][feed] ( this is a HTML coded website )

# Table of Contents <a name="top"></a>
- [Links](/linksAndAcknowledgements.md#link)
- [Tips and Hints](#tip)
- [Fatal Errors](/coding.md#fatal)
- [Getting Started](/githubBasics.md)
  - [Set-up Android Studio](/githubBasics.md#setup)
  - [Forking](/githubBasics.md#fork)
  - [Cloning the repository](/githubBasics.md#clone)
- [Github Basics](/githubBasics.md#gbasics)
  - [Commits](/githubBasics.md#commit)
  - [Push](/githubBasics.md#push)
  - [Pull/merge](/githubBasics.md#pull)
  - [Managing your server](/githubBasics.md#manage)
  - [Personal Access Token](/githubBasics.md#pat)
  - [Video Explanation of GitHub](/githubBasics.md#gitvid)
- [Coding](/coding.md#code)
  - [Code Basics](/baseLevelCode.md#cbasics)
    - [What is a...](/baseLevelCode.md#wia)
      - [Operation](/baseLevelCode.md#oper)
      - [Variable](/baseLevelCode.md#var)
      - [Function](/baseLevelCode.md#func)
      - [If Statement](/baseLevelCode.md#if)
      - [Print/Telemetry System](/baseLevelCode.md#print)
      - [Loop](/baseLevelCode.md#loop)
      - [Import](/baseLevelCode.md#import)
  - [Getting Started](/coding.md#start2)
  - [Setting up your files](/coding.md#files)
  - [Using Variables](/coding.md#usevar)
  - [TeleOp](/coding.md#tele)
  - [Autonomous](/coding.md#auto)
  - [Editing your code](/coding.md#edit)
  - [Functions](/coding.md#functions)
  - [Hardware](/coding.md#ware)
    - [Motors and Servos](/coding.md#motor)
    - [Sensors](/coding.md#sense)
    - [Indicators](/coding.md#indicator)
    - [Built in Functions](/coding.md#built)
  - [GamePad Input](/coding.md#gp)
- [Encoders](/encoders.md#encode)
  - [How do they work?](/encoders.md#eWork)
  - [How do I use them?](/encoders.md#eUse)
  - [Why should I use them?](/encoders.md#eyUse)
- [Running your code](#run)
- [Machine Learning and TFOD](/machineLearning.md#ml)
- [Updating your devices](#update)
- [Overall game](#ovr)
- [Feedback](#feed)
- [Acknowledgements](/linksAndAcknowledgements.md#agk)
- [Glossary](#gloss)
- 
## Tips and Hints <a name="tip"></a>
### 1. PRACTICE!!
- It is known that if you practice something, you will get better at it over time, this is the same for coding and robotics
### 2. Ask Questions
- A lot of people know what they are doing and are willing to help if you just ask
### 3. If you don't know a concept, look it up
- There are a lot of helpful solutions and people on the internet, someone **WILL** usually know the answer to your problem
### 4. READ
- All of the example opModes have very helpful comments to show you exactly what each part does, also if you read this whole thing you should be good to go
### 5. Collaborate
- A lot of problems can be solved by collaboration with friends and peers
### 6. Use prior knowledge
- Even if your prior knowledge is in a different language, it **will** help you understand this code.
- - - - - - - -

## Running your code <a name="run"></a>
To put the code onto your robot, you will plug in the RC phone or the control hub to your computer and press the ![runa][run] button. It will take a bit to load and once it finishes, you can disconnect and then go to your DS phone and select your opmode, then select the run button once, tap it again and your code will run.

## Updating your devices <a name="update"></a>
Go to this [website][rhc]. It will take you to rev hardware client. Once you download the app you will be able to connect the DS phone or the Control Hub and it will show you your possible updates, take them all and you are good to go!
  
## Overall Game <a name="ovr"></a>
The game begins with a 30 second autonomous period, runtime helps us achieve this, and then a 2 minute TeleOp period, the goal is to score as many points as possible.
  
## Feedback <a name="feed"></a>
I would love to have feedback on this repository. You can contact me through the discussions! Thanks!

## Glossary <a name="gloss"></a>

A repository is a folder hosted on github that contains code and items.

A TeleOp is an opmode that uses your gamepad inputs to control your robot, it is on the right side of the phone when selecting an opmode.

A  Automonous opmode is an opmode that continuously loops for 30 seconds at the beginning of the each match, it is on the left side of the phone when selecting an opmode.

My apologies if this doesn't work, some code software allows this exact code, some doesn't.  

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
