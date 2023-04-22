## Getting started <a name="start"></a>
In order to setup your repository correctly you will do 2 things. 
1.Fork and 2. Clone this will get the repository to your github account and then put that repository local on your computer. Remember **only one person will need to fork the repo** then you will share it to the rest of your team. You will go through ![settingsa][step1] and to **collaborators** then add your team members using the add people button.

### Android Studio Setup <a name="setup"></a>

Android Studio Setup Video Tutorial:

https://user-images.githubusercontent.com/101433010/229647434-4ded3127-106e-4e6b-9b0e-e24864b23ba8.mov

### Forking <a name="fork"></a>
Go to this [website][ftcpage] and find the latest repository from the company. Press the ![fork button][fork] button. This will "copy" the repository onto your github account. Remember **only one person will need to fork the repo**!

### Cloning the repository <a name="clone"></a>
To clone the repository, first find it on your github profile. You have 2 options on what to do you can do it through android studio or through github.
**Everyone will need to do this!!**

Android Studio:
Tap ![fila][file], then ![newa][new] , ![vcsa][vcs]. Go back to your repository and copy the url, paste it into the box and make sure the destination is desktop. You might need to have an access token to do this.

Github:
Navigate to the repository you want to clone. Tap ![codea][code] then select ![zipa][zip]. This will download it to your computer. Extract the zip file (double click) and move it to desktop. Then, go back to Android Studio. Tap ![filea][file] then ![opena][open] and select the path where the folder is (desktop).

## Github basics <a name="gbasics"></a>
Github is organized in a few sections. One, the code section, this is where your code and files are stored. Your repositories, where all of your code is stored and your profile, where all of your repositories are stored.

### Commits  <a name="commit"></a>

Committing is an essential part in every part of coding while connected to github, it makes sure you have the latest edited version of your code local    on your computer, we got the code local to the computer in cloning. In a github file it is a green rectangular button at the bottom of the    file that says commit changes, ![gitCommita][gitcommit] when committing directly from github it strictly gives the code to github, you will not have the code local yet. To make your code local you will need to pull in your code app, most likely android studio. In android studio, the commit button is a check mark in your top right corner.![commita][commit] You are also allowed to commit and push, to be explained later in push. You will also need a commit message to be able to push the commit.

### Push <a name="push"></a>
- What is a push?
    - A push will essentially do exactly as it says, push the code to github. This makes sure that you not only have the latest version of code locally, but also sent to github through the cloud. This is essential for working on code together as a team and collaborating. The push button is the arrow next to the commit button, it will be pointing out, where you want the code to go.![pusha][push] Commit and push does both at the same time to simplify the process. Also see pull/merge

### Pull/merge <a name="pull"></a>
- What is a pull?
    - A pull is the exact opposite of a push. It will take the current version of the code directly from github and sync it locally to your device/coding app. This is also essential as it allows you to get the teams latest version of code. This is helpful when multiple people are working on code all at once. If you are pushing sometimes it will ask you to merge your current code, this means you don't have the latest version, not to worry though as if you say yes github will automatically merge and add your code to the latest code. The pull button is an arrow pointing in, or towards your computer. ![pulla][pull]

### Managing your server <a name="manage"></a>
Managing a server is really not that hard if you do it correctly from the start. There is a settings ![settingsa][setting] button in your repository, in this tab you will find a bunch of options, it is better if you don't mess with anything that you don't know what it does. In the collaborator tab you will need to add @stcline (if you are a part of WHS). Other than that there are really no settings you need to mess with except maybe email notifications if you would like that.


### Personal Access Token <a name="pat"></a>
In github, tap on your profile ( top right corner ), then:

1. ![step1a][step1]
2. ![step2a][step2]
3. ![step3a][step3]
4. ![step4a][step4]
5. ![step5a][step5]
6. ![step6a][step6]  ( Select all, it will work better that way )

### Video Explanation of GitHub <a name="gitvid"></a>
https://user-images.githubusercontent.com/101433010/227430075-0f257d68-aff1-4b53-9fdb-045a19c1fb97.mov

[Up next: baseLevelCode if you are not proficient in coding][blcP]
[Or: coding if you are proficient in coding][cP]

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